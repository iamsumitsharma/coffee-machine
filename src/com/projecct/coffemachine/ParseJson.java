package com.projecct.coffemachine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.projecct.coffemachine.beverages.Beverages;
import com.projecct.coffemachine.constant.Constant;
import com.projecct.coffemachine.inventory.Ingredients;
import com.projecct.coffemachine.utils.GetCoffee;
import com.projecct.coffemachine.utils.HandleBeverages;

class ParseJson {
	
	private static ParseJson instance = null;
	HandleBeverages handleBeverage = new HandleBeverages();
	HashMap<String, Ingredients> inventory =  new HashMap<>();;

	private ParseJson() {

	}

	public static ParseJson getInstance() {
		if (instance == null)
			instance = new ParseJson();
		return instance;
	}

	public void parseJsonFile(String file_location)
			throws FileNotFoundException, IOException, ParseException, NullPointerException {

		// parsing file_location
		URL path = Main.class.getResource("input_file.json");
		File f = new File(path.getFile());
		Object obj = new JSONParser().parse(new FileReader(f));
		System.out.println("Input file picked up. Processing the file!!!");

		// typecasting obj to JSONObject
		JSONObject jo = (JSONObject) obj;

		// getting Machine
		Map machine = (Map) jo.get(Constant.MACHINE);
		Map outlets = (Map) machine.get(Constant.OUTLETS);
		double outlet = (long) outlets.get(Constant.COUNT);

		// ADDING Ingredients IN INVENTORY
		@SuppressWarnings("unchecked")
		HashMap<String, Integer> Inventory = (HashMap<String, Integer>) machine.get(Constant.TOTAL_ITEM_QTY);
		Iterator<Entry<String, Integer>> items = Inventory.entrySet().iterator();
		handleInventory(items);

		// ADDING BEVERAGES REQUESTED BY USER
		@SuppressWarnings("unchecked")
		HashMap<String, Integer> beverages = (HashMap<String, Integer>) machine.get(Constant.BEVERAGES);
		ArrayList<Beverages> beverage = handleBeverage.addBevarage(beverages, outlet, inventory);
		handleBeverageProcessing(beverage);

	}

	private void handleBeverageProcessing(ArrayList<Beverages> beverage) {
		if (beverage.size() > 0) {
			System.out.println("Processing " + beverage.size() + " order/s...");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (int s = 0; s < beverage.size(); ++s) {
				Beverages b1 = beverage.get(s);
				GetCoffee drink1 = new GetCoffee();
				drink1.getDrink(b1, inventory);
			}
			beverage = new ArrayList<Beverages>();
		}
	}
	private void handleInventory(Iterator<Entry<String, Integer>> items) {
		while (items.hasNext()) {
			Entry<String, Integer> pair = items.next();
			String name = (String) pair.getKey();
			double quantity = ((Number) pair.getValue()).doubleValue();
			Ingredients ing = new Ingredients(name, quantity);
			inventory.put(name, ing);
		}

	}

	// Returns the Current State of Inventory
	public HashMap<String, Ingredients> getIngredients() {
		return inventory;
	}
}