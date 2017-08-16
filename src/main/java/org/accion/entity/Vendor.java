
package org.accion.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vendors_list")
public class Vendor {
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getResourceCount() {
		return resourceCount;
	}

	public void setResourceCount(int resourceCount) {
		this.resourceCount = resourceCount;
	}

	public double getBillRate() {
		return billRate;
	}

	public void setBillRate(double billRate) {
		this.billRate = billRate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "vendor_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name="vendor_name")
	private String name;
	
	@Column(name="vendor_category")
	private String category;
	 
	@Column(name="start_date")
	private  String startDate;
	
	@Column(name="end_date")
	private  String endDate;
	
	@Column(name="resource_count")
	private  int resourceCount;
	
	@Column(name="bill_rate")
	private  double billRate;
	
	@Column(name="status")
	private  String status;
	
	@Column(name="address")
	private  String address;
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id=id;
	}

	public Vendor(Long id,String name, String category, String startDate, String endDate, int resourceCount,
			double billRate, String status, String address) {
		super();
		this.id=id;
		this.name = name;
		this.category = category;
		this.startDate = startDate;
		this.endDate = endDate;
		this.resourceCount = resourceCount;
		this.billRate = billRate;
		this.status = status;
		this.address = address;
	}
      
	public Vendor(){
		
	}

	public Vendor(String name, String category, String startDate, String endDate, int resourceCount, double billRate,
			String status, String address) {
		this.name = name;
		this.category = category;
		this.startDate = startDate;
		this.endDate = endDate;
		this.resourceCount = resourceCount;
		this.billRate = billRate;
		this.status = status;
		this.address = address;
	}
	
	

	
	 
}

