package org.mitchell.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.mitchell.domain.LossInfoType;
import org.mitchell.domain.MitchellClaim;
import org.mitchell.domain.VehicleInfoType;
import org.mitchell.util.SchemaValidator;
import org.xml.sax.SAXException;

import com.google.common.collect.Lists;

@Path("/claim")
public class ClaimWebService {

	/*
	 * For Reading all Claims: Method: GET
	 * 
	 * http://localhost:8080/MitchellClaim/rest/claim/readallclaims
	 */
	@GET
	@Path("/readallclaims")
	public List<MitchellClaim> getAllProducts() throws Exception {
		Session session = HibernateUtil.getSessionAnnotationFactory()
				.getCurrentSession();

		org.hibernate.Transaction tx = session.beginTransaction();

		List<MitchellClaim> list = session.createCriteria(MitchellClaim.class)
				.list();

		return list;
	}

	/*
	 * For Reading specific claim by claimnumber, Method: POST
	 * 
	 * http://localhost:8080/MitchellClaim/rest/claim/getspecificproducts
	 */
	@POST
	@Path("/getspecificproducts")
	@Consumes(MediaType.APPLICATION_XML)
	public List<MitchellClaim> getSpecficProducts(MitchellClaim claim)
			throws Exception {
		Session session = HibernateUtil.getSessionAnnotationFactory()
				.getCurrentSession();

		org.hibernate.Transaction tx = session.beginTransaction();
		org.hibernate.Query q = session
				.createQuery("SELECT m FROM MitchellClaim m WHERE m.claimNumber = :claimNumber");
		q.setParameter("claimNumber", claim.getClaimNumber());
		System.out.println(q.list().size());
		List<MitchellClaim> value = q.list();
		return value;
	}

	/*
	 * For Deleting Specific Products by ClaimNUmber, Method: POST
	 * 
	 * http://localhost:8080/MitchellClaim/rest/claim/deletespecificproducts
	 */
	@POST
	@Path("/deletespecificproducts")
	@Consumes(MediaType.APPLICATION_XML)
	//@Consumes(MediaType.TEXT_PLAIN)
	public void deleteSpecficProducts(MitchellClaim claim) throws Exception {
		Session session = HibernateUtil.getSessionAnnotationFactory()
				.getCurrentSession();

		org.hibernate.Transaction tx = session.beginTransaction();
		org.hibernate.Query q = session
				.createQuery("delete MitchellClaim m WHERE m.claimNumber = :claimNumber");
		q.setParameter("claimNumber", claim.getClaimNumber());
		q.executeUpdate();

		session.getTransaction().commit();
		HibernateUtil.getSessionAnnotationFactory().close();
	}

	/*
	 * For Updating the claim based on Update-Claim XML, Method: POST
	 * 
	 * http://localhost:8080/MitchellClaim/rest/claim/updatespecificproducts
	 */
	@POST
	@Path("/updatespecificproducts")
	@Consumes(MediaType.APPLICATION_XML)
	public void updateSpecficProducts(MitchellClaim claim) throws Exception {
		Session session = HibernateUtil.getSessionAnnotationFactory()
				.getCurrentSession();
		org.hibernate.Transaction tx = session.beginTransaction();

		try {
			session.update(claim);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}

		session.getTransaction().commit();
		HibernateUtil.getSessionAnnotationFactory().close();
	}

	/*
	 * For Persisting Data into Database: Method: POST
	 * 
	 * http://localhost:8080/MitchellClaim/rest/claim/store
	 */
	@POST
	@Path("/store")
	@Consumes(MediaType.APPLICATION_XML)
	public void persistData(InputStream incomingData) throws Exception {
		// TODO Auto-generated method stub
		SchemaValidator validate = new SchemaValidator();
		Source xmlFile = new StreamSource(incomingData);
		// validate.schemavalidator(xmlFile);

		if (true) {
			JAXBContext jc = JAXBContext.newInstance(MitchellClaim.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();

			MitchellClaim sc = (MitchellClaim) unmarshaller
					.unmarshal(new StreamSource(incomingData));
			sc.setLossdateitem(sc.getDateTimeItem());
			System.out.println(sc.getVehicles().getId());
			LossInfoType lo = sc.getLossInfo();

			Session session = HibernateUtil.getSessionAnnotationFactory()
					.getCurrentSession();

			session.beginTransaction();
			session.save(lo);
			session.save(sc);

			System.out.println("Hibernate serviceRegistry created");

			session.getTransaction().commit();

			HibernateUtil.getSessionAnnotationFactory().close();
		}
	}

	/*
	 * For getting specific products between two different dates Method:Get
	 * 
	 * http://localhost:8080/MitchellClaim/rest/claim/getbydate
	 */
	@GET
	@Path("/getbydate")
	public List functiondate(/* Date startDate, Date endDate */)
			throws ParseException {
		Session session = HibernateUtil.getSessionAnnotationFactory()
				.getCurrentSession();
		org.hibernate.Transaction tx = session.beginTransaction();

		Date d = new Date();
		d.UTC(2006, 5, 12, 5, 30, 12);
		Date d1 = new Date();
		d1.UTC(2008, 5, 12, 6, 30, 12);
		Criteria criteria = session.createCriteria(MitchellClaim.class);
		if (d != null) {
			criteria.add(Expression.ge("lossdateitem", d));
		}
		if (d1 != null) {
			criteria.add(Expression.le("lossdateitem", d1));
		}
		System.out.println(criteria.list().size());
		List<MitchellClaim> results = criteria.list();
		return results;
	}

	/*
	 * For getting specific product by date. Method: POST
	 * 
	 * http://localhost:8080/MitchellClaim/rest/claim/getspecificdate
	 */
	@POST
	@Path("/getspecificdate")
	@Consumes(MediaType.APPLICATION_XML)
	public List<MitchellClaim> getSpecficProductsbydate(MitchellClaim claim)
			throws Exception {

		Session session = HibernateUtil.getSessionAnnotationFactory()
				.getCurrentSession();

		org.hibernate.Transaction tx = session.beginTransaction();
		org.hibernate.Query q = session
				.createQuery("SELECT m FROM MitchellClaim m WHERE m.lossdateitem = :lossdateitem");
		q.setParameter("lossdateitem", claim.getDateTimeItem());
		System.out.println(q.list().size());
		List<MitchellClaim> value = q.list();
		return value;
	}

}
