package mru.store.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import mru.store.model.Animals;
import mru.store.model.BoardGames;
import mru.store.model.Figures;
import mru.store.model.Puzzles;
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
		loadData();
		menu.welcomeMessage();
		menuOptions();
		//
	}
	
	public void menuOptions() {
		boolean flag = true;
		while(flag){
			int choice = menu.showMainMenu();
			switch (choice) {
			case 1:
				findAndPurchase();
				break;
			case 2:
				addToy();
				break;
			case 3:
				removeToy();
				break;
			case 4:
				saveExit();
				flag = false;
				break;
			}
		}
	}	
	
	
	
	
	private void findAndPurchase() {
		int choice = menu.searchMenu();
		//use case to
		switch(choice) {
		case 1:
			//prompt enter serial
			//use array list to search for serial num matching it
			break;
		case 2:
			//prompt enter name
			//use array list to search for name matching it
			break;
		case 3:
			//prompt enter type
			//use array list to search for type matching it
			//if item is instanceof typeOfToy(animals, boardGames, etc) then print out 
			break;
		case 4:
			//back to main menu
			break;
			
		}
		
	}
	
	private void addToy() {
		//prompt everything
		
	}
	
	private void removeToy() {
		//prompt serial num
	}
	
	private void gift() {
		
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
		menu.saveMessage();
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
				String serialNum = splittedLine[0];
				char firstNum = serialNum.charAt(0);
				int firstNumber = Character.getNumericValue(firstNum);
				if (firstNumber <= 1) {
					Toys figures = new Figures(Long.parseLong(splittedLine[0]), splittedLine[1], splittedLine[2], Float.parseFloat(splittedLine[3]), Integer.parseInt(splittedLine[4]), Integer.parseInt(splittedLine[5]), splittedLine[6]);
					toy.add(figures);
					
				}
				else if(firstNumber <=3){
					Toys animal = new Animals(Long.parseLong(splittedLine[0]), splittedLine[1], splittedLine[2], Float.parseFloat(splittedLine[3]), Integer.parseInt(splittedLine[4]), Integer.parseInt(splittedLine[5]), splittedLine[6], splittedLine[7]);
					toy.add(animal);
				}
				else if(firstNumber <= 6) {
					Toys puzzles = new Puzzles(Long.parseLong(splittedLine[0]), splittedLine[1], splittedLine[2], Float.parseFloat(splittedLine[3]), Integer.parseInt(splittedLine[4]), Integer.parseInt(splittedLine[5]), splittedLine[6]);
					toy.add(puzzles);
					
				}
				else if(firstNumber <=9) {	
					String[] numPlayers = splittedLine[6].split("-");
					Toys boardGames = new BoardGames(Long.parseLong(splittedLine[0]), splittedLine[1], splittedLine[2], Float.parseFloat(splittedLine[3]), Integer.parseInt(splittedLine[4]), Integer.parseInt(splittedLine[5]), Integer.parseInt(numPlayers[0]), Integer.parseInt(numPlayers[1]), splittedLine[7]);
					toy.add(boardGames);
				}
				//Use nested if else
					// Each if is the serialnum
						//inside it adds to the object and casts it
				//add to toys
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
