package jessi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Catalog {

	private ArrayList<CandyBars> candyList; 
	
	public Catalog() {
		candyList = new ArrayList<CandyBars>(); 
		candyList.add(new CandyBars("Twix", 0.75));
		candyList.add(new CandyBars("Crunch", 1));
		//Collections.sort(list);
	}

	public static void main(String[] args) {
		Catalog maker = new Catalog();
		System.out.println(maker.getCSVContent());
		//maker.addItem();

	}
	
	private static void addItem(ArrayList<CandyBars> candyList) {
        for (int i = 0; i < 2; i++) {
            System.out.println("ENTER NAME");
            Scanner addName = new Scanner(System.in);
            String name = (addName.nextLine());

            System.out.println("ENTER PRICE");
            Scanner addPrice = new Scanner(System.in);
            double price = (addPrice.nextDouble());

            candylist.add(new CandyBars(name, price));
        }
        //for (CandyBars list : list) {
          //  System.out.println("NAME " + list.getName() + ", PRICE " + list.getPrice());
        //}
    }
	
	public String getCSVContent(){
		String data = "";
		for(CandyBars t: candyList) {
			data += data + t + "\n";
		}
		return data;
	
	}
}
