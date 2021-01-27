package com.projecct.coffemachine.beverages;


import java.util.ArrayList;

import com.projecct.coffemachine.inventory.Ingredients;


//All Beverages to be processed
public class Beverages {
	private String beverage;
	private ArrayList<Ingredients> ingts = new ArrayList<Ingredients>();
	public Beverages(String beverage, ArrayList<Ingredients> ingts) {
		this.beverage = beverage;
		this.ingts = ingts;
	}
	public String getBeverage() {
		return beverage;
	}
	public ArrayList<Ingredients> getIngts() {
		return ingts;
	}
	public void setBeverage(String beverage) {
		this.beverage = beverage;
	}
	public void setIngts(ArrayList<Ingredients> ingts) {
		this.ingts = ingts;
	}
}