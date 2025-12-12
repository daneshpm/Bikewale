package com.BikeWale.BikeWale.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User_info {

    @Id
    private int id;
    private String name;
    private String email;
    private long phone;
    private String password;

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public long getPhone() { return phone; }
    public void setPhone(long phone) { this.phone = phone; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
