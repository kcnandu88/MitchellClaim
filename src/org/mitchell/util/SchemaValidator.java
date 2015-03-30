package org.mitchell.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import com.sun.org.apache.xml.internal.security.utils.ElementCheckerImpl.EmptyChecker;

import java.io.File;

import org.w3c.dom.Document;


public class SchemaValidator {

	public boolean schemavalidator(Source Inputfile) throws IOException,
			SAXException, URISyntaxException {

		InputStream configStream = this.getClass().getClassLoader()
				.getResourceAsStream("/MitchellClaim.xsd");

		Source xmlFile = new StreamSource(configStream);

		SchemaFactory schemaFactory = SchemaFactory
				.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(xmlFile);
		Validator validator = schema.newValidator();
		try {
			validator.validate(Inputfile);
			System.out.println(Inputfile.getSystemId() + " is valid");
			return true;
		} catch (SAXException e) {
			System.out.println(Inputfile.getSystemId() + " is NOT valid");
			System.out.println("Reason: " + e.getLocalizedMessage());
			return false;
		}
	}
}
