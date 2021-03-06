//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.03.19 at 01:08:13 AM PDT 
//


package org.mitchell.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@Table(name="VehicleListType")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VehicleListType", propOrder = {"vehicle_id",
    "vehicleDetails"
})
public class VehicleListType {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="vehicle_id")
	int vehicle_id;
	
    @XmlElement(name = "VehicleDetails", required = true)
	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="vin")
    protected VehicleInfoType vehicleDetails;

	public int getId() {
		return vehicle_id;
	}

	public void setId(int id) {
		this.vehicle_id = id;
	}


	public VehicleInfoType getVehicleDetails() {
		return vehicleDetails;
	}

	public void setVehicleDetails(VehicleInfoType vehicleDetails) {
		this.vehicleDetails = vehicleDetails;
	}
}
