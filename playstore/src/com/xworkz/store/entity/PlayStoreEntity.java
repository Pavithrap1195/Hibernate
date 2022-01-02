package com.xworkz.store.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Table(name = "play_store")
@Entity
@NamedQuery(name = "updateSizeById", query = "update PlayStoreEntity set sizeInMb=:Size where applicationId=:ApplicationId")
@NamedQuery(name = "updateRatingByName", query = "update PlayStoreEntity set ratedInStar=:Rating where applicationName=:ApplicationName")
@NamedQuery(name = "getTypeByName", query = "select type from PlayStoreEntity where applicationName=:ApplicationName")
@NamedQuery(name = "getPlayStoreEntityByRating", query = "from PlayStoreEntity where ratedInStar=:Rating")
@NamedQuery(name = "maxRatingOfPlayStoreEntity", query = "from PlayStoreEntity where MAX(ratedInStar)=:Rating")
@NamedQuery(name="deleteById",query="delete from PlayStoreEntity where applicationId=:ApplicationId")


public class PlayStoreEntity implements java.io.Serializable {

	@Id
	@Column(name = "APPLICATION_ID")
	@GeneratedValue(generator = "abc")
	@GenericGenerator(name = "abc", strategy = "increment")
	public int applicationId;

	@Column(name = "APPLICATION_NAME")
	public String applicationName;

	@Column(name = "TYPE")
	public String type;

	@Column(name = "SIZE")
	public int sizeInMb;

	@Column(name = "RATING")
	public double ratedInStar;

	public PlayStoreEntity() {
		// TODO Auto-generated constructor stub
	}

	public PlayStoreEntity(String applicationName, String type, int sizeInMb, double ratedInStar) {
		super();
//		this.applicationId = applicationId;
		this.applicationName = applicationName;
		this.type = type;
		this.sizeInMb = sizeInMb;
		this.ratedInStar = ratedInStar;
	}

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getSizeInMb() {
		return sizeInMb;
	}

	public void setSizeInMb(int sizeInMb) {
		this.sizeInMb = sizeInMb;
	}

	public double getRatedInStar() {
		return ratedInStar;
	}

	public void setRatedInStar(double ratedInStar) {
		this.ratedInStar = ratedInStar;
	}

	@Override
	public String toString() {
		return "PlayStoreEntity [applicationId=" + applicationId + ", applicationName=" + applicationName + ", type="
				+ type + ", sizeInMb=" + sizeInMb + ", ratedInStar=" + ratedInStar + "]";
	}

}
