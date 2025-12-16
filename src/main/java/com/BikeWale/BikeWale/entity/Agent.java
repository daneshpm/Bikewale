package com.BikeWale.BikeWale.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Schema(description = "Agent information who sells bikes")
public class Agent {
	@Id
	@Schema(description = "Unique Agent ID", accessMode = Schema.AccessMode.READ_ONLY)
	private int id;
	@Schema(description = "Full name of the agent", requiredMode = Schema.RequiredMode.REQUIRED)
	private String name;
	@Schema(description = "Contact phone number")
	private long phone;
	@Schema(description = "Email address of the agent", example = "ramesh@bikewale.com")
	private String email;
	@Schema(description = "Brand the agent represents")
	private String brand;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

}
