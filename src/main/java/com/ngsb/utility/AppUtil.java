package com.ngsb.utility;

import com.ngsb.dto.AppUserDto;
import com.ngsb.dto.ProductDto;
import com.ngsb.entity.AppUser;
import com.ngsb.entity.Product;

public interface AppUtil {

	public static Product copyProductObject(Product dbProduct, ProductDto uiProduct) {
		if(uiProduct.getProdName()!=null)
			dbProduct.setProdName(uiProduct.getProdName());
		if(uiProduct.getProdQty()!=null)
			dbProduct.setProdQty(uiProduct.getProdQty());
		if(uiProduct.getProdPrice()!=null)
			dbProduct.setProdPrice(uiProduct.getProdPrice());
		if(uiProduct.getIsProdAvailable()!=null)
			dbProduct.setIsProdAvailable(uiProduct.getIsProdAvailable());
		return dbProduct;
	}
	
	public static AppUser getAppUser(AppUserDto userDto) {
		AppUser appUser = new AppUser();
		appUser.setFName(userDto.getFirstName());
		appUser.setLName(userDto.getLastName());
		appUser.setRoles(userDto.getRoles());
		appUser.setUsername(userDto.getUsername());
		appUser.setPassword(userDto.getPassword());
		return appUser;
	}
}
