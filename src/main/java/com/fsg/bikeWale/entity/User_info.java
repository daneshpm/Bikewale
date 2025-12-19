package com.fsg.bikeWale.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Schema(description = "End user who browses and enquires about bikes")
public class User_info {

	@Id
	@Schema(example = "1001", accessMode = Schema.AccessMode.READ_ONLY)
	private int id;
	@Schema(description = "User full name", requiredMode = Schema.RequiredMode.REQUIRED)
	private String name;
	@Schema(description = "User email address")
	private String email;
	@Schema(description = "Mobile number")
	private long phone;
	@Schema(hidden = true)
	private String password;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
