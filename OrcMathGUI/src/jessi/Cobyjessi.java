package jessi;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Cobyjessi {
	public static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		String s = in.nextLine();
		save(s);
		
	}
	public static void save(String fileContent) {
		try{    
			 FileWriter fw=new FileWriter("text.csv");    
			 fw.write(fileContent);
			 fw.close();    
			 System.out.println("Success! File \""+"text.csv"+"\" saved!");
		 }catch(IOException e){
			 System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");
		 }
	}
}
