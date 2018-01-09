/*
 * Program introduction: Cellphone class.
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class CellPhone {
	private long serialNum;
	private String brand;
	private int year;
	private double price;
	
	/**
	 * default constructor
	 */
	public CellPhone() {
		this.serialNum = 0;
		this.brand = "";
		this.year = 0;
		this.price = 0;
	}
	/**
	 * parameterized constructor
	 * @param serialNum
	 * @param brand
	 * @param year
	 * @param price
	 */
	public CellPhone(long serialNum, String brand, int year, double price) {
		this.serialNum = serialNum;
		this.brand = brand;
		this.year = year;
		this.price = price;
	}
	/**
	 * getters and setters
	 */
	public long getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(long serialNum) {
		this.serialNum = serialNum;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * copy constructor
	 * @param c
	 * @param serialNum
	 */
	public CellPhone(CellPhone c, long serialNum) {
		this.serialNum = serialNum;
		this.brand = c.brand;
		this.year = c.year;
		this.price = c.price;
	}
	/**
	 * clone method
	 */
	public CellPhone clone() {
		Scanner kb = new Scanner (System.in);
		System.out.print("Please enter a new serial number: ");
		long nSn = kb.nextLong();		
		kb.close();
		return new CellPhone(this, nSn);
	}

	public String toString() {
		return ("["+serialNum+": "+ brand + " "+ price + "$ "+year + "]");
	}

	public boolean equals(Object obj) {
		if(obj==null || obj.getClass()!=this.getClass())
			return false;
		else {
			CellPhone c = (CellPhone) obj;
			return (c.getBrand().equals(this.getBrand())&&c.getPrice()==this.getPrice()&&c.getYear()==this.getYear());
		}
	}
	
	
}
