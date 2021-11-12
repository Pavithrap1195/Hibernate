package com.xworkz.mobile;

import java.util.Scanner;

import com.xworkz.mobile.dao.MobileDAOImpl;
import com.xworkz.mobile.entity.MobileEntity;

public class MobileTester {

	public static void main(String[] args) {
		MobileDAOImpl dao = new MobileDAOImpl();
		//dao.saveMobileEntity();
		//dao.getMobileEntity();
		//dao.updateMobileEntity();
//		dao.deleteMobileEntity();
//		dao.getAllMobileEntity();
//		dao.getMobileBrandById();
//		dao.updateById();
//		dao.deleteById();
	
//		MobileEntity mobileEntity = new MobileEntity("Apple",95000.00,"256GB","Black",128.00,true,"ios");
//		dao.saveMobileEntity(mobileEntity);
	
		Scanner scanner = new Scanner(System.in);
		System.out.println("Invoking getMobileBrandByPrice-Enter price:-");
		double price = scanner.nextDouble();
		dao.getMobileBrandByPrice(price);
		
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Invoking updateMobilePriceByColor-Enter Color:-");
//		String color = scanner.next();
//		dao.updateMobilePriceByColor(color);
		
//		
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Invoking updateMobileCameraInPixelByName-Enter mobileBrand:-");
//		String brand = scanner.next();
//		dao.updateMobileCameraInPixelByName(brand);
		
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Invoking getMobileBrandByostype-Enter OsType:-");
//		String ostype = scanner.next();
//		dao.getMobileBrandByostype(ostype);
//		
//	
//	
	}

}
