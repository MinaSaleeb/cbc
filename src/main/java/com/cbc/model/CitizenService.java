package com.cbc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the citizen_services database table.
 * 
 */
@Entity
@Table(name="citizen_services")
@NamedQuery(name="CitizenService.findAll", query="SELECT c FROM CitizenService c")
public class CitizenService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="service_name")
	private String serviceName;

	@Column(name="service_url")
	private String serviceUrl;

	public CitizenService() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getServiceName() {
		return this.serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceUrl() {
		return this.serviceUrl;
	}

	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}

}