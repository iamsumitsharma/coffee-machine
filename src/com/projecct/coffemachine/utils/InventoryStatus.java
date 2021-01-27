package com.projecct.coffemachine.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import com.projecct.coffemachine.inventory.Ingredients;
import com.projecct.coffemachine.notification.Notification;




public class InventoryStatus extends Notification{
	public InventoryStatus() {
		
	}
	public void checkIngredients(HashMap<String, Ingredients> inventory) {
		Iterator<Entry<String, Ingredients>> it = inventory.entrySet().iterator();
		
		//check the quantity of all ingredients
		//raises alert if quantity is lower than or equal to 50 
		while(it.hasNext()) {
			HashMap.Entry<String, Ingredients> pair = (HashMap.Entry<String, Ingredients>) it.next();
			if(pair.getValue().getQuantity() <= 50) {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("ATTENTION!!!" + pair.getValue().getIngredient() + " is low");
			}
		}
	}
}
