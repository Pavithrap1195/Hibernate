package com.xworkz.store.dao;

import com.xworkz.store.entity.PlayStoreEntity;

public interface PlayStoreDAO {
	
	
	void savePlayStoreEntity(PlayStoreEntity playStoreEntity);
	void updateSizeById(int applicationId,int sizeInMb);
	void updateRatingByName(double ratedInStar,String name);
	void getTypeByName(String applicationName);
	void getPlayStoreEntityByRating(double ratedInStar);
	void maxRatingOfPlayStoreEntity();
	void deleteById(int applicationId);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
