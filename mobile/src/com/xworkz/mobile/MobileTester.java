package com.xworkz.mobile;

import com.xworkz.mobile.dao.MobileDAOImpl;

public class MobileTester {

	public static void main(String[] args) {
		MobileDAOImpl dao = new MobileDAOImpl();
		//dao.saveMobileEntity();
		//dao.getMobileEntity();
		//dao.updateMobileEntity();
		dao.deleteMobileEntity();
		
	}

}
