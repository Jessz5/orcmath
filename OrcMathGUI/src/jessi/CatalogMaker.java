package jessi;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CatalogMaker {

	private static ArrayList<CandyBars> candyList; 
	Scanner in = new Scanner(System.in);

	public CatalogMaker() {
		candyList = new ArrayList<CandyBars>(); 
		candyList.add(new CandyBars("Twix", 0.75));
		candyList.add(new CandyBars("Crunch", 1));
	}

	public static void main(String[] args) {
		CatalogMaker maker = new CatalogMaker();
		System.out.println(maker.getCSVContent());
		maker.add();
		System.out.println(maker.getCSVContent());
		maker.save();
	}
	
	public String getCSVContent(){
		String data = "";
		for(CandyBars t: candyList) {
			data = data + t + "\n";
		}
		return data;
	}
	
	public void addCandyBars(CandyBars b) {
		candyList.add(b);
	}
	
	public void add() {
		System.out.println("Enter the name.");
		String s = in.nextLine();
		System.out.println("Please enter the price.");
		String t = in.nextLine();
		addCandyBars(new CandyBars(s, Integer.parseInt(t)));
    }
	
	public void save() {
		try{    
			 FileWriter fw=new FileWriter("CandyBarsCatalog.csv");    
			 for(CandyBars b: candyList){
					fw.write(b+"\n");    	
				}

				fw.close();    
				System.out.println("Success! File \"CandyBarsCatalog.csv\" saved!");
			}catch(IOException e){
				System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");
			}
	}
}
