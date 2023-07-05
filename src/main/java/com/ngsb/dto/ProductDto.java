package com.ngsb.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String prodName;
	private Integer prodQty;
	private Double prodPrice;
	private Boolean isProdAvailable;
}
