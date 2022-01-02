package com.xworkz.store;

import java.util.Scanner;

import com.xworkz.store.dao.PlayStoreDAO;
import com.xworkz.store.dao.PlayStoreDAOImpl;

public class PlayStoreTester {

	public static void main(String[] args) {

		PlayStoreDAO dao = new PlayStoreDAOImpl();

		/*
		 * PlayStoreEntity playStoreEntity=new
		 * PlayStoreEntity("Jio Saavan","Music",28,4.75);
		 * dao.savePlayStoreEntity(playStoreEntity);
		 * 
		 * dao.updateSizeById(4,18); dao.updateRatingByName(5.00, "Whattsapp");
		 * 
		 * Scanner scanner=new Scanner(System.in);
		 * System.out.println("Invoking getTypeByName()");
		 * System.out.println("Enter Application Name"); String name=scanner.next();
		 * 
		 * dao.getTypeByName(name);
		 */

		/*Scanner scanner = new Scanner(System.in);
		System.out.println("Invoking getPlayStoreEntityByRating()");
		System.out.println("Enter Rating");
		double rating = scanner.nextDouble();
		dao.getPlayStoreEntityByRating(rating);
*/
		
//		dao.maxRatingOfPlayStoreEntity();
		
		dao.deleteById(8);
		
	}
}
