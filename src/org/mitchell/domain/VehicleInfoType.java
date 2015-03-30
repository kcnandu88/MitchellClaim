package org.mitchell.domain;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import org.jvnet.hyperjaxb3.xml.bind.annotation.adapters.XMLGregorianCalendarAsDateTime;
import org.jvnet.hyperjaxb3.xml.bind.annotation.adapters.XmlAdapterUtils;


@Entity
@Table(name="VehicleInfoType")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VehicleInfoType", propOrder = {
    "modelYear",
    "makeDescription",
    "modelDescription",
    "engineDescription",
    "exteriorColor",
    "vin",
    "licPlate",
    "licPlateState",
    "licPlateExpDate",
    "damageDescription",
    "mileage"//,
    //"licplatedate"
})
public class VehicleInfoType {

    @XmlElement(name = "ModelYear")
    @Column(name="modelYear")
    protected int modelYear;
    
    @XmlElement(name = "MakeDescription")
    @Column(name="makeDescription")
    protected String makeDescription;
    
    @XmlElement(name = "ModelDescription")
    @Column(name="modelDescription")
    protected String modelDescription;
    
    @XmlElement(name = "EngineDescription")
    @Column(name="engineDescription")
    protected String engineDescription;
    
    @XmlElement(name = "ExteriorColor")
    @Column(name="exteriorColor")
    protected String exteriorColor;
    
    @XmlElement(name = "Vin")
    @Id
    @Column(name="vin")
    protected String vin;
    
    @XmlElement(name = "LicPlate")
    @Column(name="licPlate")
    protected String licPlate;
    
    @XmlElement(name = "LicPlateState")
    @Column(name="licPlateState")
    protected String licPlateState;
    
    @XmlElement(name = "LicPlateExpDate")
    @XmlSchemaType(name = "date")
    @Transient
    protected XMLGregorianCalendar licPlateExpDate;
    
    @XmlElement(name = "DamageDescription")
    @Column(name="damageDescription")
    protected String damageDescription;
    
    @XmlElement(name = "Mileage")
    @Column(name="mileage")
    protected Integer mileage;

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int value) {
        this.modelYear = value;
    }


    public String getMakeDescription() {
        return makeDescription;
    }

    public void setMakeDescription(String value) {
        this.makeDescription = value;
    }

    public String getModelDescription() {
        return modelDescription;
    }

    public void setModelDescription(String value) {
        this.modelDescription = value;
    }

    public String getEngineDescription() {
        return engineDescription;
    }


    public void setEngineDescription(String value) {
        this.engineDescription = value;
    }

    public String getExteriorColor() {
        return exteriorColor;
    }

    public void setExteriorColor(String value) {
        this.exteriorColor = value;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String value) {
        this.vin = value;
    }

    public String getLicPlate() {
        return licPlate;
    }

    public void setLicPlate(String value) {
        this.licPlate = value;
    }

    public String getLicPlateState() {
        return licPlateState;
    }

    public void setLicPlateState(String value) {
        this.licPlateState = value;
    }

    public XMLGregorianCalendar getLicPlateExpDate() {
        return licPlateExpDate;
    }

    public void setLicPlateExpDate(XMLGregorianCalendar value) {
        this.licPlateExpDate = value;
    }

    public String getDamageDescription() {
        return damageDescription;
    }

    public void setDamageDescription(String value) {
        this.damageDescription = value;
    }
    
    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer value) {
        this.mileage = value;
    }
}
