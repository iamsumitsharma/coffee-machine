package com.projecct.coffemachine.utils;

import java.util.ArrayList;
import java.util.HashMap;

import com.projecct.coffemachine.beverages.Beverages;
import com.projecct.coffemachine.inventory.Ingredients;
import com.projecct.coffemachine.notification.Notification;

public class GetCoffee {
	public void getDrink(Beverages b, HashMap<String, Ingredients> inventory) {
		ArrayList<Ingredients> ingred = b.getIngts();

		// Process Drinks for the user and checks for quantity 
		for (int i = 0; i < ingred.size(); ++i) {
			if (inventory.containsKey(ingred.get(i).getIngredient())) {
				if (ingred.get(i).getQuantity() > inventory.get(ingred.get(i).getIngredient()).getQuantity()) {
					System.out.println(b.getBeverage() + " cannot be processed because " + ingred.get(i).getIngredient()
							+ " is not sufficient");
					return;
				}
			} else {
				System.out.println(b.getBeverage() + " cannot be processed because " + ingred.get(i).getIngredient()
						+ " is not available");
				return;
			}
		}

		for (int i = 0; i < ingred.size(); ++i) {
			double val = inventory.get(ingred.get(i).getIngredient()).getQuantity() - ingred.get(i).getQuantity();
			inventory.get(ingred.get(i).getIngredient()).setQuantity(val);
		}
		System.out.println(b.getBeverage() + " is prepared");
		Notification notification = new InventoryStatus();
		notification.checkIngredients(inventory);
	}
}