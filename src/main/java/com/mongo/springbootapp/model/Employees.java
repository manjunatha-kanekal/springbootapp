package com.mongo.springbootapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(collection = "Employees")
public class Employees {
    @Id
    private String id;
    @Indexed(direction = IndexDirection.ASCENDING)
    private String first_name;
    private String last_name;
    @Indexed(direction = IndexDirection.ASCENDING)
    private String department;
    private Date dob;
    @Indexed(direction = IndexDirection.ASCENDING)
    private String designation;
    private Date doj;
    private Date doe;
    private Address address;
    private List<Skillset> skillsets;

    protected Employees() {
        this.skillsets = new ArrayList<>();
    }

    public Employees(String first_name, String last_name, String department, Date dob, String designation, Date doj, Date doe, Address address, List<Skillset> skillsets) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.department = department;
        this.dob = dob;
        this.designation = designation;
        this.doj = doj;
        this.doe = doe;
        this.address = address;
        this.skillsets = skillsets;
    }

    public String getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getDepartment() {
        return department;
    }

    public Date getDob() {
        return dob;
    }

    public String getDesignation() {
        return designation;
    }

    public Date getDoj() {
        return doj;
    }

    public Date getDoe() {
        return doe;
    }

    public Address getAddress() {
        return address;
    }

    public List<Skillset> getSkillsets() {
        return skillsets;
    }
}
