package com.dnynn.model.product;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="product_table",uniqueConstraints=@UniqueConstraint(columnNames={"product_name","product_number"}))
public class ProductTable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="product_id")
	private int productId;
	
	@Column(name="product_name")
	@Size(max=255)
	@NotNull
	private String name;
	
	@Column(name="product_number")
	@Size(max=25)
	@NotNull
	private String productNumber;
	
	@Column(name="make_flag")
	@NotNull
	private int makeFlag; //0= Product is purchased, 1=Product is in house made
	
	@Column(name="color")
	@Null
	private String color;
	
	@Column(name="safety_stock_leve")
	@NotNull
	private int safetyStockLevel; //minimum alert stock quantity
	
	@Column(name="reorder_point")
	@NotNull
	private int reorderPoint; //quatity alert to reorder product
	
	@Column(name="standard_cost")
	@NotNull
	private double standardCost; //Standard Cost of the product
	
	@Column(name="list_price")
	@NotNull
	private double listPrice; //selling price
	
	@Column(name="size")
	@Null
	private String size; //Product size
	
	
	@Column(name="sale_start_date")
	@NotNull
	@DateTimeFormat(pattern="dd-MM-yyyy")
	//@Future
	private Date saleStartDate;
	
	@Column(name="sale_end_date")
	@NotNull
	@Future
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date saleEndDate;
	
	@Column(name="discontinue_date")
	@NotNull
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date discontinuedDate;
	
	@Column(name="last_modified_date")
	@NotNull
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date lastModifiedDate;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}

	public int getMakeFlag() {
		return makeFlag;
	}

	public void setMakeFlag(int makeFlag) {
		this.makeFlag = makeFlag;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getSafetyStockLevel() {
		return safetyStockLevel;
	}

	public void setSafetyStockLevel(int safetyStockLevel) {
		this.safetyStockLevel = safetyStockLevel;
	}

	public int getReorderPoint() {
		return reorderPoint;
	}

	public void setReorderPoint(int reorderPoint) {
		this.reorderPoint = reorderPoint;
	}

	public double getStandardCost() {
		return standardCost;
	}

	public void setStandardCost(double standardCost) {
		this.standardCost = standardCost;
	}

	public double getListPrice() {
		return listPrice;
	}

	public void setListPrice(double listPrice) {
		this.listPrice = listPrice;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Date getSaleStartDate() {
		return saleStartDate;
	}

	public void setSaleStartDate(Date saleStartDate) {
		this.saleStartDate = saleStartDate;
	}

	public Date getSaleEndDate() {
		return saleEndDate;
	}

	public void setSaleEndDate(Date saleEndDate) {
		this.saleEndDate = saleEndDate;
	}

	public Date getDiscontinuedDate() {
		return discontinuedDate;
	}

	public void setDiscontinuedDate(Date discontinuedDate) {
		this.discontinuedDate = discontinuedDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public ProductTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

}
