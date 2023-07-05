package com.ngsb.entity;

import java.util.Date;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "product_user")
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;
	@Column(name = "first_name")
	private String fName;
	@Column(name = "last_name")
	private String lName;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(joinColumns = @JoinColumn(name = "userId"))
	@Column(name = "user_roles")
	private List<String> roles;
	
	@Column(name = "created_by")
	private String createdby="Admin";
	@Column(name = "created_on",updatable = false)
	@CreationTimestamp
	private Date createdOn;
	@Column(name = "updated_by")
	private String updatedBy;
	@Column(name = "updated_on",insertable = false)
	@UpdateTimestamp
	private Date updatedOn;
	
	@Column(name = "user_status")
	private String userStatus="Active";
}
