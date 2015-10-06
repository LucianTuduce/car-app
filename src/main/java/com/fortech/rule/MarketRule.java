package com.fortech.rule;


import com.fortech.enumcategory.StockCategory;

public class MarketRule {

	private String countryNumber;
	private Integer branch;
	private StockCategory stockCategory;
	private boolean active;
	private String rule;
	
	
	public String getCountryNumber() {
		return countryNumber;
	}
	public void setCountryNumber(String countryNumber) {
		this.countryNumber = countryNumber;
	}
	public Integer getBranch() {
		return branch;
	}
	public void setBranch(Integer branch) {
		this.branch = branch;
	}
	public StockCategory getStockCategory() {
		return stockCategory;
	}
	public void setStockCategory(StockCategory stockCategory) {
		this.stockCategory = stockCategory;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	
	public String toString(){
		return "[ "+countryNumber+" "+branch+" "+stockCategory+" "+active+" "+rule+" ]";
	}
}
