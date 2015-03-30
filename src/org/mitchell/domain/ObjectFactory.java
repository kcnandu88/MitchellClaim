package org.mitchell.domain;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
 
@XmlRegistry
public class ObjectFactory {

    private final static QName _MitchellClaim_QNAME = new QName("http://www.mitchell.com/examples/claim", "MitchellClaim");

    public ObjectFactory() {
    }

    public MitchellClaim createMitchellClaimType() {
        return new MitchellClaim();
    }

    public LossInfoType createLossInfoType() {
        return new LossInfoType();
    }

    public VehicleInfoType createVehicleInfoType() {
        return new VehicleInfoType();
    }

    public VehicleListType createVehicleListType() {
        return new VehicleListType();
    }

    @XmlElementDecl(namespace = "http://www.mitchell.com/examples/claim", name = "MitchellClaim")
    public JAXBElement<MitchellClaim> createMitchellClaim(MitchellClaim value) {
        return new JAXBElement<MitchellClaim>(_MitchellClaim_QNAME, MitchellClaim.class, null, value);
    }

}
