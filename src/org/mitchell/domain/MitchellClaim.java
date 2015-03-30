package org.mitchell.domain;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import org.jvnet.hyperjaxb3.xml.bind.annotation.adapters.XMLGregorianCalendarAsDateTime;
import org.jvnet.hyperjaxb3.xml.bind.annotation.adapters.XmlAdapterUtils;

@XmlRootElement(name = "MitchellClaim")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "MITCHELLCLAIMTYPE")
@XmlType(name = "MitchellClaim", propOrder = {
    "claimNumber",
    "claimantFirstName",
    "claimantLastName",
    "status",
    "lossDate",
    "lossInfo",
    "assignedAdjusterID",
    "vehicles",
    "lossdateitem"
})
public class MitchellClaim {

	 @XmlElement(name = "ClaimNumber", required = true)
	    @Id
	    @Column(name="claimNumber")
	    protected String claimNumber;
	    
	    @XmlElement(name = "ClaimantFirstName")
	    @Column(name="claimantFirstName")
	    protected String claimantFirstName;
	    
	    @XmlElement(name = "ClaimantLastName")
	    @Column(name="claimantLastName")
	    protected String claimantLastName;
	    
	    @XmlElement(name = "Status")
	    @Column(name="status")
	    @Enumerated(EnumType.ORDINAL) 
	    protected StatusCode status;
	    
	    @XmlElement(name = "LossDate")
	    @XmlSchemaType(name = "dateTime")
	    @Transient
	    protected XMLGregorianCalendar lossDate;
	    
	    @XmlElement(name = "LossInfo")
	    @OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	    @JoinColumn(name="id")
	    protected LossInfoType lossInfo;
	    
	    @XmlElement(name = "AssignedAdjusterID")
	    protected Long assignedAdjusterID;
	    
	    @XmlElement(name = "Vehicles")
	    @OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	    @JoinColumn(name="vehicle_id")
	    protected VehicleListType vehicles;
    
	    @Column(name="lossdateitem")
	    protected Date lossdateitem;
	    
	    public String getClaimNumber() {
        return claimNumber;
    }

	    
	    
	    public Date getLossdateitem() {
	        return lossdateitem;
		}



		public void setLossdateitem(Date lossdateitem) {
			this.lossdateitem = lossdateitem;
		}



	public void setClaimNumber(String value) {
        this.claimNumber = value;
    }

    public String getClaimantFirstName() {
        return claimantFirstName;
    }

    public void setClaimantFirstName(String value) {
        this.claimantFirstName = value;
    }

    public String getClaimantLastName() {
        return claimantLastName;
    }

    public void setClaimantLastName(String value) {
        this.claimantLastName = value;
    }

    public StatusCode getStatus() {
        return status;
    }

    public void setStatus(StatusCode value) {
        this.status = value;
    }

    public XMLGregorianCalendar getLossDate() {
        return lossDate;
    }

    public void setLossDate(XMLGregorianCalendar value) {
        this.lossDate = value;
    }

    public LossInfoType getLossInfo() {
        return lossInfo;
    }

    public void setLossInfo(LossInfoType value) {
        this.lossInfo = value;
    }

    @Column(name="assignedAdjusterID")
    public Long getAssignedAdjusterID() {
        return assignedAdjusterID;
    }

    public void setAssignedAdjusterID(Long value) {
        this.assignedAdjusterID = value;
    }

    public VehicleListType getVehicles() {
        return vehicles;
    }

    public void setVehicles(VehicleListType value) {
        this.vehicles = value;
    }
    
    public Date getDateTimeItem() {
        return XmlAdapterUtils.unmarshall(XMLGregorianCalendarAsDateTime.class, this.getLossDate());
    }
}
