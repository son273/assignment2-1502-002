package mru.store.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import mru.store.model.Toys;
import mru.store.view.AppMenu;
//Manages and runs the application

public class AppDriver {
	private ArrayList<Toys> toy;
	private AppMenu menu;	
	private final String FILE_PATH = "res/toys.txt";
	
	// 
	
	public AppDriver() {
		toy = new ArrayList<>();
		menu = new AppMenu();
		menuOptions();
		//
	}
	
	public void menuOptions() {
		//menu.mainmenu
	}
	
	
	
	//add save and exit
	//add load data up method
	//
	
	private void loadData() {
		File txt = new File(FILE_PATH); // opens file
		String currentLine;
		String[] splittedLine;

		if (txt.exists()) { // checks if file exists
			//TRY HERE
			Scanner fileReader = new Scanner(txt); // Creates scanner class to read file

			while (fileReader.hasNextLine()) { // checks if the line exists

				currentLine = fileReader.nextLine(); // reads current line
				splittedLine = currentLine.split(","); // splits line at ,
					String name = splittedLine[0]; //
					int balance = Integer.parseInt(splittedLine[1]);//
					int wins = Integer.parseInt(splittedLine[2]); //
			//CATCH HERE
				}
			
			fileReader.close();
		}
	}
	
	
	
	
	
	
}
