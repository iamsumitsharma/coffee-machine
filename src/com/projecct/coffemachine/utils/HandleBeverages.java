package com.projecct.coffemachine.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.projecct.coffemachine.beverages.Beverages;
import com.projecct.coffemachine.inventory.Ingredients;

public class HandleBeverages {

	// this method is to add the beverages by processing the ingredients and checking their quantity
	public ArrayList<Beverages> addBevarage(Map beverages, double outlet, HashMap<String, Ingredients> inventory) {
		
		  Iterator<Map.Entry> bitr = beverages.entrySet().iterator();
          ArrayList<Beverages> beverage = new ArrayList<Beverages>();
          while(bitr.hasNext()) {
          	Map.Entry pair = bitr.next();
          	String drink = (String)pair.getKey();
          	 ArrayList<Ingredients> ingts = new ArrayList<Ingredients>();
          	 Map ingred = (Map) beverages.get(drink);
          	 Iterator<Map.Entry> itr = ingred.entrySet().iterator();
               while (itr.hasNext()) { 
  	             Map.Entry pair1 = itr.next(); 
  	             String name = (String)pair1.getKey();
  	             double quantity = ((Number) pair1.getValue()).doubleValue();
  	             Ingredients ing = new Ingredients(name, quantity);
  	             ingts.add(ing);
               }
               Beverages b = new Beverages(drink, ingts);
               beverage.add(b);
               
               //If N beverages are processed via parser then we start producing the drink
               if(beverage.size() == outlet) {
              	 System.out.println("Processing " + beverage.size() + " order/s...");
              	 try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
              	 for(int s = 0; s < outlet; ++s) {
              		 Beverages b1 = beverage.get(s);
              		 GetCoffee drink1 = new GetCoffee();
                   	 drink1.getDrink(b1, inventory);
              	 }
              	 beverage = new ArrayList<Beverages>();
              	 System.out.println();
               }
          }
          return beverage;
	}
}
