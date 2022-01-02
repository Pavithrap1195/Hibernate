package com.xworkz.mobile.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

//metadata-data about data

//this annotation is used to map db table name with hibernate
@Table(name = "mobile_details")
//to make this java object as entity or persistence object
@Entity
public class MobileEntity {

	// to tell hibernate that this will be our primary key ,as in db mobile id is
	// primary key
	@Id
	// this map db to java program properties
	// name = the name that as given in database wrt all columns
	@Column(name = "mobile_id")
	@GeneratedValue(generator = "abc")
	@GenericGenerator(name="abc",strategy="increment")
	private int mobileId;

	@Column(name = "mobile_brand")//column name shld be uppercase
	private String mobileBrand;

	@Column(name = "mobile_price")
	private double mobilePrice;

	@Column(name = "mobile_rom")
	private String rom;

	@Column(name = "mobile_color")
	private String color;

	@Column(name = "mobile_camera")
	private double cameraInPixel;

	@Column(name = "mobile_fingerprint")
	private boolean isFingerPrintAvailable;

	@Column(name = "mobile_ostype")
	private String ostype;

	public int getMobileId() {
		return mobileId;
	}

	public void setMobileId(int mobileId) {
		this.mobileId = mobileId;
	}

	public String getMobileBrand() {
		return mobileBrand;
	}

	public void setMobileBrand(String mobileBrand) {
		this.mobileBrand = mobileBrand;
	}

	public double getMobilePrice() {
		return mobilePrice;
	}

	public void setMobilePrice(double mobilePrice) {
		this.mobilePrice = mobilePrice;
	}

	public String getRom() {
		return rom;
	}

	public void setRom(String rom) {
		this.rom = rom;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getCameraInPixel() {
		return cameraInPixel;
	}

	public void setCameraInPixel(double cameraInPixel) {
		this.cameraInPixel = cameraInPixel;
	}

	public boolean isFingerPrintAvailable() {
		return isFingerPrintAvailable;
	}

	public void setFingerPrintAvailable(boolean isFingerPrintAvailable) {
		this.isFingerPrintAvailable = isFingerPrintAvailable;
	}

	public String getOstype() {
		return ostype;
	}

	public void setOstype(String ostype) {
		this.ostype = ostype;
	}

	public MobileEntity() {
		// TODO Auto-generated constructor stub
	}

	public MobileEntity( String mobileBrand, double mobilePrice, String rom, String color,
			double cameraInPixel, boolean isFingerPrintAvailable, String ostype) {
		super();
//		this.mobileId = mobileId;
		this.mobileBrand = mobileBrand;
		this.mobilePrice = mobilePrice;
		this.rom = rom;
		this.color = color;
		this.cameraInPixel = cameraInPixel;
		this.isFingerPrintAvailable = isFingerPrintAvailable;
		this.ostype = ostype;
	}

	@Override
	public String toString() {
		return "MobileEntity [mobileId=" + mobileId + ", mobileBrand=" + mobileBrand + ", mobilePrice=" + mobilePrice
				+ ", rom=" + rom + ", color=" + color + ", cameraInPixel=" + cameraInPixel + ", isFingerPrintAvailable="
				+ isFingerPrintAvailable + ", ostype=" + ostype + "]";
	}

}
