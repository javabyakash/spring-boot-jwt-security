package com.ngsb.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prod_id")
	private Long prodId;
	@Column(name = "prod_name")
	private String prodName;
	@Column(name = "prod_qty")
	private Integer prodQty;
	@Column(name = "prod_price")
	private Double prodPrice;
	@Column(name = "is_available")
	private Boolean isProdAvailable;

	@Column(name = "created_by")
	private String createdBy;
	
	@CreationTimestamp
	@Column(name = "created_on", updatable = false)
	private Date createdOn;

	@Column(name = "updatd_by")
	private String updatedBy;
	
	@UpdateTimestamp
	@Column(name = "updated_on",insertable = false)
	private Date updatedOn;
}
