package com.BikeWale.BikeWale.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Schema(description = "User enquiry related to a bike")
public class Enquiry {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(example = "5001", accessMode = Schema.AccessMode.READ_ONLY)
	private int id;
	@Schema(description = "Customer Name")
	private String customername;
	@Schema(description = "Mobile number")
	private long phone;
	@Schema(description = "User remarks on the bike")
	private String remarks;
	@Schema(description = "Date of Enquiry")
	private String dateofenquiry;
	@Schema(description = "Description of the vechicle")
	private String description;
	@Schema(description = "Status of the enquriy")
	private String status;
	@Schema(description = "User who raised the enquiry")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User_info user;
	@Schema(description = "Bike for which enquiry is raised")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bike_id")
	private Bike bike;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDateofenquiry() {
		return dateofenquiry;
	}

	public void setDateofenquiry(String dateofenquiry) {
		this.dateofenquiry = dateofenquiry;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User_info getUser() {
		return user;
	}

	public void setUser(User_info user) {
		this.user = user;
	}

	public Bike getBike() {
		return bike;
	}

	public void setBike(Bike bike) {
		this.bike = bike;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
