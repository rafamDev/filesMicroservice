package com.filesMicroservices.persistence;

import java.math.BigDecimal;
import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "role")
    private String role;

    @Column(name = "salary")
    private BigDecimal salary;

    public Employee() {
    }

    public Employee(String name, String code, String role, BigDecimal salary) {
        this.name = name;
        this.code = code;
        this.role = role;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
        return name;
    }

    public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
    	this.salary = salary;
    }
}
