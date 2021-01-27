package com.projecct.coffemachine;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import org.json.simple.parser.ParseException;

import com.projecct.coffemachine.constant.Constant;



public class Main {
	public static void main(String[] args) throws Exception  
    { 
		Scanner sc = new Scanner(System.in);
		
		System.out.println(Constant.PICKING_FILE);
		String file_location = "./input_file.json";
		
		//Getting the instance for Singleton class CoffeeImpl
        CoffeeImpl impl = CoffeeImpl.getInstance();
        try {
        	
        	//Processing all drinks , N drinks at a time
        	impl.getOutput(file_location);
        	
        	//Check whether the user needs to refill
        	System.out.println(Constant.REFILL_STATEMENT);
        	
            String s = sc.nextLine();
            
            if(s.equals("Y") || s.contentEquals("y")) {
           	 impl.addIngredients();
            }
           System.out.println("\nTHANK YOU !!!!!");
           sc.close();
        }
        catch(NullPointerException e) {
        	System.out.println(Constant.JSON_EXC);
        }
        catch(FileNotFoundException e){
        	System.out.println(Constant.FILE_EXC);
        }
		catch(IOException e){
			System.out.println(Constant.IO_EXC);
        }
		catch(ParseException e){
			System.out.println(Constant.PARSE_EXC);
        }
		catch(Exception e){
        	e.printStackTrace();
        }
         
    }

}
