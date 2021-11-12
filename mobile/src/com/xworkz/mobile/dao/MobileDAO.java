package com.xworkz.mobile.dao;

import com.xworkz.mobile.entity.MobileEntity;

public interface MobileDAO {
	
	void saveMobileEntity();
	void getMobileEntity();
	void updateMobileEntity();
	void deleteMobileEntity();
	void getAllMobileEntity();
	void getMobileBrandById();
	void getMobileEntityById();
	void deleteById();
	void updateById();
	
	void saveMobileEntity(MobileEntity mobileEntity);
	void getMobileBrandByPrice(double mobilePrice);
	void updateMobilePriceByColor(String color);
	void updateMobileCameraInPixelByName(String mobileName);
	void getMobileBrandByostype(String ostype);
	
	
	
	
	
	
	
	
	
	
//	void maxPriceOfMobile();
//	void totalMobileBrand();
//	void orderByMobileName();
//	void totalPrice();
//	void avgPrice();
	

}
