package com.projecct.coffemachine.inventory;

import java.util.HashMap;
import java.util.Scanner;

import com.projecct.coffemachine.constant.Constant;


public class AddIngredients {
	public void handleIngredients(HashMap<String, Ingredients> inventory) {
		//Refilling Ingredients as given by user
		String response;
		Scanner sc = new Scanner(System.in);
		do{
			System.out.println(Constant.MESSAGE);
			String name = sc.nextLine();
			System.out.println(Constant.INGREDIENT);
			double q = sc.nextDouble();
			if(q < 0) {
				System.out.println("Refill Quantity is Negative");
				System.out.println("Exiting.....");
				return;
			}
			try {
				double val = inventory.get(name).getQuantity();
				inventory.get(name).setQuantity(val + q);
				System.out.println(Constant.SUCCESS + name);
				System.out.println(Constant.CURR_QTY + inventory.get(name).getQuantity());
			}
			catch(Exception e) {
				System.out.println(name + " does not exist in inventory");
			}
			System.out.println(Constant.REFILL);
			response = sc.nextLine();
		}while(response.equals("Y") || response.contentEquals("y"));
		sc.close();
	}
}