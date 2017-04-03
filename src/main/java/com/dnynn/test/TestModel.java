package com.dnynn.test;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "test_model")
public class TestModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "customer_name")
	@NotEmpty(message = "name not empty")
	private String customerName;

	/*
	 * @Column(name = "date_of_birth")
	 * 
	 * @Past
	 * 
	 * @DateTimeFormat(pattern = "dd/MM/yyyy") private Date dateOfBirth;
	 * 
	 * @Column(name = "future_date")
	 * 
	 * @Future
	 * 
	 * @DateTimeFormat(pattern = "dd/MM/yyyy") private Date futureDate;
	 * 
	 * @DecimalMin("1")
	 * 
	 * @Column(name = "salary") private double salary;
	 * 
	 * @Column(name = "rank")
	 * 
	 * @Min(1) private int rank;
	 * 
	 * public int getId() { return id; }
	 * 
	 * public void setId(int id) { this.id = id; }
	 * 
	 * public String getCustomerName() { return customerName; }
	 * 
	 * public void setCustomerName(String customerName) { this.customerName =
	 * customerName; }
	 * 
	 * public Date getDateOfBirth() { return dateOfBirth; }
	 * 
	 * public void setDateOfBirth(Date dateOfBirth) { this.dateOfBirth =
	 * dateOfBirth; }
	 * 
	 * public Date getFutureDate() { return futureDate; }
	 * 
	 * public void setFutureDate(Date futureDate) { this.futureDate =
	 * futureDate; }
	 * 
	 * public double getSalary() { return salary; }
	 * 
	 * public void setSalary(double salary) { this.salary = salary; }
	 * 
	 * public int getRank() { return rank; }
	 * 
	 * public void setRank(int rank) { this.rank = rank; }
	 */
	public TestModel() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public TestModel(String customerName) {
		this.customerName = customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

}
