package org.mitchell.domain;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="LossInfoType")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LossInfoType", propOrder = {"id",
    "causeOfLoss",
    "reportedDate",
    "lossDescription",
    /*"claim",*/
    /*"DateTimeItem"
*/})
public class LossInfoType {


	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
    @XmlElement(name = "CauseOfLoss")
    @Column(name="causeOfLoss") 
    @Enumerated(EnumType.ORDINAL) 
    protected CauseOfLossCode causeOfLoss;
    
    @XmlElement(name = "ReportedDate")
    @XmlSchemaType(name = "dateTime")
    @Transient
    protected XMLGregorianCalendar reportedDate;
    
    @XmlElement(name = "LossDescription")
    @Column(name="lossDescription")
    protected String lossDescription;   
   
    public CauseOfLossCode getCauseOfLoss() {
        return causeOfLoss;
    }
 
    public void setCauseOfLoss(CauseOfLossCode value) {
        this.causeOfLoss = value;
    }
 
    public XMLGregorianCalendar getReportedDate() {
        return reportedDate;
    }
 
    public void setReportedDate(XMLGregorianCalendar value) {
        this.reportedDate = value;
    }
 
    public String getLossDescription() {
        return lossDescription;
    }

    public void setLossDescription(String value) {
        this.lossDescription = value;
    }

}
