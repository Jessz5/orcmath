package jessi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Catalog {

	private static ArrayList<CandyBars> candyList; 
	
	public Catalog() {
		candyList = new ArrayList<CandyBars>(); 
		candyList.add(new CandyBars("Twix", 0.75));
		candyList.add(new CandyBars("Crunch", 1));
	}

	public static void main(String[] args) {
		Catalog maker = new Catalog();
		while(true) {
			System.out.println(maker.getCSVContent());
			maker.addCandy();
	
		}
		//maker.addCandy();
	}
	
	public void addCandy() {
		 System.out.println("ENTER NAME");
         Scanner addName = new Scanner(System.in);
         String name = (addName.nextLine());

         System.out.println("ENTER PRICE");
         Scanner addPrice = new Scanner(System.in);
         double price = (addPrice.nextDouble());

         candyList.add(new CandyBars(name, price));
    }
	
	public String getCSVContent(){
		String data = "";
		for(CandyBars t: candyList) {
			data = data + t + "\n";
		}
		return data;
	
	}
}
