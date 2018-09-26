package com.zd.entity;

public class Compensation_item {
	private String standard_id;
	private double travel;
	private double traffic;
	private double housing;
	private double basic;
	private double year_end;
	private double mistakes;
	public String getStandard_id() {
		return standard_id;
	}
	public void setStandard_id(String standard_id) {
		this.standard_id = standard_id;
	}
	public double getTravel() {
		return travel;
	}
	public void setTravel(double travel) {
		this.travel = travel;
	}
	public double getTraffic() {
		return traffic;
	}
	public void setTraffic(double traffic) {
		this.traffic = traffic;
	}
	public double getHousing() {
		return housing;
	}
	public void setHousing(double housing) {
		this.housing = housing;
	}
	public double getBasic() {
		return basic;
	}
	public void setBasic(double basic) {
		this.basic = basic;
	}
	public double getYear_end() {
		return year_end;
	}
	public void setYear_end(double year_end) {
		this.year_end = year_end;
	}
	public double getMistakes() {
		return mistakes;
	}
	public void setMistakes(double mistakes) {
		this.mistakes = mistakes;
	}
	public Compensation_item(String standard_id, double travel, double traffic, double housing, double basic,
			double year_end, double mistakes) {
		super();
		this.standard_id = standard_id;
		this.travel = travel;
		this.traffic = traffic;
		this.housing = housing;
		this.basic = basic;
		this.year_end = year_end;
		this.mistakes = mistakes;
	}
	public Compensation_item() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
