package com.projecct.coffemachine;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

import com.projecct.coffemachine.inventory.AddIngredients;
import com.projecct.coffemachine.inventory.Ingredients;

public class CoffeeImpl {
	private static CoffeeImpl instance = null;
	private static ParseJson parse;
	private CoffeeImpl() {
		
	}
	public static CoffeeImpl getInstance() {
		if(instance == null)
			instance = new CoffeeImpl();
		return instance;
	}
	
	//to parse and run the all functionalities of machine
	public void getOutput(String file_location) throws FileNotFoundException, IOException, ParseException, NullPointerException {        
        	parse = ParseJson.getInstance();
            parse.parseJsonFile(file_location);     
	}
	//this is to run test cases
	public Boolean testOutput(String file_location) throws FileNotFoundException, IOException, ParseException, NullPointerException {        
    	parse = ParseJson.getInstance();
        parse.parseJsonFile(file_location);
		return true;     
}
	
	//Calls the function to refill ingredients
	public void addIngredients() {
		HashMap<String, Ingredients> inventory = parse.getIngredients();
		AddIngredients add = new AddIngredients();
		add.handleIngredients(inventory);
	}
}