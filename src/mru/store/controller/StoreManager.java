package mru.store.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import mru.store.model.Toys;
import mru.store.view.AppMenu;
//Manages and runs the application

public class StoreManager {
	private ArrayList<Toys> toy;
	private AppMenu menu;	
	private final String FILE_PATH = "res/toys.txt";
	
	// 
	
	public StoreManager() {
		toy = new ArrayList<>();
		menu = new AppMenu();
		menuOptions();
		//
	}
	
	public void menuOptions() {
		//USE SWITCH CASES
	}
	
	
	
	
	
	
	
	private void saveExit(){//NOT FINISHED
		File txt = new File (FILE_PATH);
		try {
			PrintWriter pw = new PrintWriter(txt);
			for (Toys t: toy) {
				pw.printf(t.format());
			}
			pw.close();
			
		}
		catch (FileNotFoundException c) {
			System.out.println("File Not Found");	
		}
	}
	
	
	private void loadData(){	//NOT FINISHED
		File txt = new File(FILE_PATH); // opens file
		String currentLine;
		String[] splittedLine;

		if (txt.exists()) { // checks if file exists
			//TRY HERE
			try {
			Scanner fileReader = new Scanner(txt); // Creates scanner class to read file

			while (fileReader.hasNextLine()) { // checks if the line exists

				currentLine = fileReader.nextLine(); // reads current line
				splittedLine = currentLine.split(";"); // splits line at ,
					String name = splittedLine[0]; //
					int balance = Integer.parseInt(splittedLine[1]);//
					int wins = Integer.parseInt(splittedLine[2]); //
				}
			fileReader.close();
			}
			
			//CATCH HERE
			catch (FileNotFoundException c)
			{
				System.out.println("File Was not Found");
			}

			
		}
	}
	
	
	
	
	
	
}
