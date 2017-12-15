package jessi;

import java.util.ArrayList;
import java.util.Collections;

public class Catalog {

	private ArrayList<CandyBars> list; 
	
	public Catalog() {
		list = new ArrayList<CandyBars>(); 
		list.add(new CandyBars("Twix", 20, 50));
		list.add(new CandyBars("Crunch", 30, 80));
		Collections.sort(list);
	}

	public static void main(String[] args) {
		Catalog maker = new Catalog();
		System.out.println(maker.getCSVContent());

	}
	
	public String getCSVContent(){
		String data = "";
		for(CandyBars t: list) {
			data += data + t + "\n";
		}
		return data;
	
	}
}
