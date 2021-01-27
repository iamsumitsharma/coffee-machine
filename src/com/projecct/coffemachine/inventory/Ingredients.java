package com.projecct.coffemachine.inventory;

public class Ingredients {
	private String ingredient;
	private double quantity;
	
	public Ingredients(String ingredient, double quantity) {
		this.ingredient = ingredient;
		this.quantity = quantity;
	}
	public String getIngredient() {
		return ingredient;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
}
