package com.dnynn.productcategory;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.dnynn.productsubcategory.ProductSubCategory;

@Entity
@Table(name="product_category",uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
public class ProductCategory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="name", nullable=false)
	@NotEmpty(message="Name can not blank")
	private String name;
	
	@Column(name="last_modofied_date", nullable=false)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date lastModifiefDate;
	
	@OneToMany(mappedBy="productCategory",cascade=CascadeType.ALL)
	private List<ProductSubCategory> productSubCategory;

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

	public Date getLastModifiefDate() {
		return lastModifiefDate;
	}

	public void setLastModifiefDate(Date lastModifiefDate) {
		this.lastModifiefDate = lastModifiefDate;
	}

	public List<ProductSubCategory> getProductSubCategory() {
		return productSubCategory;
	}

	public void setProductSubCategory(List<ProductSubCategory> productSubCategory) {
		this.productSubCategory = productSubCategory;
	}

	public ProductCategory() {
		
	}
	
	

}
