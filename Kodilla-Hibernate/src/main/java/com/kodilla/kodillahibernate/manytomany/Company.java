package com.kodilla.kodillahibernate.manytomany;

import com.sun.istack.NotNull;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@NamedQuery(
        name = "Company.retrieveCompaniesWhichName",
        query = "FROM Company WHERE SUBSTRING(name,1,3) = :STARTS_WITH"
)
@Entity
@Table(name = "COMPANIES")
public class Company {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "COMPANY_ID", unique = true)
    private int id;
    @NotNull
    @Column(name = "COMPANY_NAME")
    private String name;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "companies")
    private List<Employee> employees = new ArrayList<>();



    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }


    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }
}