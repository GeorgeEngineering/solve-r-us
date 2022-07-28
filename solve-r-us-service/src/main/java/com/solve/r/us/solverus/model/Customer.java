package com.solve.r.us.solverus.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {
    private static final long serialVersionUID = -5401932334669729075L;
    @Id
    @Column(name = "customerid", nullable = false)
    private Long customerId;

    @Column(name = "firstname", nullable = false, length = 40)
    private String firstName;

    @Column(name = "lastname", nullable = false, length = 20)
    private String lastName;

    @Column(name = "company", length = 80)
    private String company;

    @Column(name = "address", length = 70)
    private String address;

    @Column(name = "city", length = 40)
    private String city;

    @Column(name = "state", length = 40)
    private String state;

    @Column(name = "country", length = 40)
    private String country;

    @Column(name = "postalcode", length = 10)
    private String postalCode;

    @Column(name = "phone", length = 24)
    private String phone;

    @Column(name = "fax", length = 24)
    private String fax;

    @Column(name = "email", nullable = false, length = 60)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supportrepid")
    private Employee supportRep;

    public Long getId() {
        return customerId;
    }

    public void setId(Long customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Employee getSupportRep() {
        return supportRep;
    }

    public void setSupportRep(Employee supportRep) {
        this.supportRep = supportRep;
    }

}