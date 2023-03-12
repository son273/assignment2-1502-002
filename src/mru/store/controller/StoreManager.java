package mru.store.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
		menuOptions();
		//
	}

	public void menuOptions() {
		boolean flag = true;
		int choice = 0;
//		boolean exceptionLoop = true;
//		while (exceptionLoop) {
	
		while (flag) {
			try {
				choice = menu.showMainMenu();
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
				default:
				menu.validateOptionNotValid();
				break;
				}
			}
			catch(InputMismatchException e) {
				menu.validateNumNotValid();
				menu.promptEnterKeyMainMenu();
				
			}
		}
	}

	private void findAndPurchase() {
		boolean flag = true;
		// use case to
		while (flag) {
			try {
				int choice = menu.searchMenu();
					switch (choice) {
					case 1:
						serialSearch();
						break;
						
					case 2:
						nameSearch();
						break;
					case 3:
						typeSearch();	
						break;
					case 4:
						flag = false;
						break;
			
					}
			}catch(InputMismatchException mismatch){
				menu.validateNumNotValid();
				menu.promptEnterKey();
			}
		}

	}
	public void serialSearch() { //Responsible for search serial number
		boolean found = false; // Becomes true if item is found
		boolean enter = false;
		boolean exceptionLoop = true; //Used to keep looping try/catch until exception is cleared
		long serialNum = 0; 
		while (exceptionLoop) {
			try {
				serialNum = menu.promptSerialNum(); // prompts for serial num
				
				
				for (Toys item : toy) // iterates through file array
					if(item.getSerialNumber() == serialNum && item.getAvalibleCount() > 0) { 
						found = true;
						while (enter != true) {
						menu.serialSearchResults(item.toString()); // Displays the what the user can purchase
						int choice = menu.promptPurchase(); // Prompts purchase
						if(choice == 1) { // If they choose 1, they purchase item
							int stock = item.getAvalibleCount();
							stock -= 1; // deals with stock
							item.setAvalibleCount(stock);
							menu.purchaseSuccessful(); // displays purchase is successful
							menu.promptEnterKey(); // prompts for user to press enter
							enter = true;
							
						}
						else if (choice == 2) { // If they type 2, they go back a menu
							enter = true;
							break;
						}
						else { // Any other input is invalid
							menu.validateOptionNotValid();
							menu.promptEnterKey();
							
							}
						}
					}
					else if(item.getSerialNumber() == serialNum && item.getAvalibleCount() == 0) {
						menu.noStock(); // if the specific item has a stock cound of 0, then displays out of stock
						found = true;
						menu.promptEnterKey();
						break;
					}
				if (found != true) { // If item serial num is not in arraylist, displays item doesn't exist
					menu.doesntExist();
					menu.promptEnterKey();
					}
				exceptionLoop = false;
				}
			catch(InputMismatchException mismatch) {
				menu.validateNumNotValid();
			}	
		}
	}
	
	
	
	
	private void nameSearch() { //Responsible for searching for name of toy
		boolean found = false; // Becomes true once item is found
		boolean enter = false; // Becomes true once user presses enter
		String name = menu.prompToyName().trim().toLowerCase(); //prompts for user to input a toy name
		ArrayList<Toys> nameArray = new ArrayList<>(); 
		int itemCount = 0; 
		int listSize = 0;
		int choice = 0;
		
		
		for (Toys item: toy) { //This for loop is responsible for iterating through the list and adding items that contain the users input
			if(item.getName().toLowerCase().trim().contains(name) && item.getAvalibleCount() > 0) {
				nameArray.add(item);
				itemCount++;
				found = true;	
			}
//			else if (item.getAvalibleCount() == 0){
//				menu.noStockName(item);
//			}
			
		}
		
		if (found != true) { // This If statement is responsible for telling user that the item they were looking for was not found and going back to the search menu
			menu.doesntExist();
			enter = true;
			menu.promptEnterKey();

		}
		

		while(enter != true) { // This loops is responsible for dealing with purchase of item and validating proper inputs when purchasing
			listSize = menu.nameSearchResults(nameArray, itemCount);
			try {
				
				choice = menu.promptPurchase(); //Prompts purchase
				choice -= 1;
				listSize -= 1;
				if (choice == listSize) { // If user input is equal to list size, goes back to main menu
					break;
				}
				else if (choice > listSize || choice < 0){ // If user input is larger than list size ot smaller than the # of choices, displays error
					menu.validateOptionNotValid();
					menu.promptEnterKey();

				}
				
				else{ // If user chooses a toy to purchase, it will -1 from stock and prints purchase was successful
					Toys item = nameArray.get(choice);
					int stock = item.getAvalibleCount();
					stock -= 1;
					item.setAvalibleCount(stock);
					menu.purchaseSuccessful();
					
					menu.promptEnterKey(); //Asks user to press enter and breaks the while loop once done
					enter = true;
				}
			}
			catch(InputMismatchException mismatch){
				menu.validateNumNotValid();
				menu.promptEnterKey();
			}
		}
	}
	
	
	private void typeSearch() { //Responsible for searching Type of toy
		String type = menu.promptType().trim().toLowerCase(); // Prompts user to enter a type of toy
		ArrayList<Toys> nameArray = new ArrayList<>();
		int listSize = 0;
		int itemCount = 0;
		int choice = 0;
		boolean found = false;
		boolean enter = false; // Becomes true once user presses enter
		for (Toys item : toy) { // Iterates through lists and uses if statements to deterine which item shows
			if (type.equals("animals")|| type.equals("animal") ) { // Adds Animal toys to list and item count (Will be sent to AppMenu for display later)
				if (item instanceof Animals) {
					if (item.getAvalibleCount() > 0) {
						nameArray.add(item);
						itemCount ++;
						found = true;
					}
						
				}
				//instance of...
				//show it like in names
				//
			}
			else if(type.equals("figures")|| type.equals( "figure")) { // Adds Figure toys to list and item count (Will be sent to AppMenu for display later)
				if (item instanceof Figures) {
					if (item.getAvalibleCount() > 0) {
						nameArray.add(item);
						itemCount ++;
						found = true;

					}
					
						
				}
				
			}
			else if (type.equals("puzzles")||type.equals("puzzle")) { // Adds Puzzle toys to list and item count (Will be sent to AppMenu for display later)
				if (item instanceof Puzzles) {
					if (item.getAvalibleCount() > 0) {
						nameArray.add(item);
						itemCount ++;
						found = true;

					}
						
				}
				
			}
			else if (type.equals("board")||type.equals("boards")||type.equals("boardgame")||type.equals("boardgames")) { // Adds Board Games toys to list and item count (Will be sent to AppMenu for display later)
				if (item instanceof BoardGames) {
					if (item.getAvalibleCount() > 0) {
						nameArray.add(item);
						itemCount ++;
						found = true;

					}
						
				}
				
			}
		}
		if (found != true) { //If User enters a wrong input, sends back to search menu
			menu.validateOptionNotValid();
			enter = true;
			menu.promptEnterKey();
			
		}
		
		while (enter != true) {  // This loops is responsible for dealing with purchase of item and validating proper inputs when purhcasing
		listSize = menu.nameSearchResults(nameArray, itemCount); // Sends array and item count to AppMenu to be displayed
		try {
			choice = menu.promptPurchase();//Prompts user which toy they want to purchase
			choice -= 1;
			listSize -= 1;
			if (choice == listSize) { // If choice is equal to the list size, goes back to menu
				break;
			}
			else if (choice > listSize || choice < 0){ // if input was larger than list size or smaller than 0, displays invalid imput
				menu.validateOptionNotValid();
				menu.promptEnterKey();
		
			}
			
			else{// If user chooses a toy to purchase, it will -1 from stock and prints purchase was successful
	
				Toys item = nameArray.get(choice);
				int stock = item.getAvalibleCount();
				stock -= 1;
				item.setAvalibleCount(stock);
				menu.purchaseSuccessful();
				
				menu.promptEnterKey();//Asks user to press enter and breaks the while loop once done
				enter = true;
			}
			
		}
		catch(InputMismatchException mismatch){
			menu.validateNumNotValid();
			menu.promptEnterKey();
		}
		
		}
	}
	

	private void addToy() {
		// prompt for serial number
		long serialNum = serialNum();
		boolean serialNumExists = false;
		while (true) {
			for (Toys item : toy) {
				if (item.getSerialNumber() == serialNum) {
					menu.validateExistingSN();
					serialNum = menu.promptSerialNum();
					serialNumExists = true;
					break;
				}
			}
			if (!serialNumExists) {
				break;
			}
			serialNumExists = false;
		}
		String toyName = menu.prompToyName();
		String toyBrand = menu.prompBrandName();
		float toyPrice = menu.promptToyPrice();
		int availability = menu.promptAvailability();
		int age = menu.promptAge();
		String serialNumString = Long.toString(serialNum);
		char firstVal = serialNumString.charAt(0);
		int firstNum = Character.getNumericValue(firstVal);

		if (firstNum <= 1) {
			String figureClass = menu.promptFigureClass();
			Toys newFigures = new Figures(serialNum, toyName, toyBrand, toyPrice, availability, age, figureClass);
			toy.add(newFigures);
		} else if (firstNum <= 3) {
			String material = menu.promptAnimalMaterial();
			String size = menu.promptAnimalSize();
			Toys newAnimals = new Animals(serialNum, toyName, toyBrand, toyPrice, availability, age, material, size);
			toy.add(newAnimals);
		} else if (firstNum <= 6) {
			String puzzleType = menu.promptPuzzleType();
			Toys newPuzzles = new Puzzles(serialNum, toyName, toyBrand, toyPrice, availability, age, puzzleType);
			toy.add(newPuzzles);
		} else if (firstNum <= 9) {
			int minPlayers = menu.promptBoardGameMinPlayers();
			int maxPlayers = menu.promptBoardGameMaxPlayers();
			String designers = menu.promptBoardGameDesigners();
			Toys newBoardGames = new BoardGames(serialNum, toyName, toyBrand, toyPrice, availability, age, minPlayers,
					maxPlayers, designers);
			toy.add(newBoardGames);
		}

		menu.toyAddedMessage();
		menu.promptEnterKey();
	}

	private long serialNum() {
		long serialNum;
		do {
			try {
				serialNum = menu.promptSerialNum();
				if ((Long.toString(serialNum)).length() != 10) {
					menu.validateSNLength();
				} else {
					return serialNum;
				}
			} catch (InputMismatchException e) {
				menu.validateSN();
				menu.promptSerialNum();
			}
		} while (true);
	}

	private void removeToy() {
		// prompt serial num
	}

	private void gift() {
		
	}

	private void saveExit() {// NOT FINISHED
		File txt = new File(FILE_PATH);
		try {
			PrintWriter pw = new PrintWriter(txt);
			for (int i = 0; i < toy.size(); i++) {
				pw.println(toy.get(i).format());

			}
			pw.close();

		} catch (FileNotFoundException c) {
			System.out.println("File Not Found");
			
		}
		menu.saveMessage();
	}

	private void loadData() { // NOT FINISHED
		File txt = new File(FILE_PATH); // opens file
		String currentLine;
		String[] splittedLine;

		if (txt.exists()) { // checks if file exists
			// TRY HERE
			try {
				Scanner fileReader = new Scanner(txt); // Creates scanner class to read file

				while (fileReader.hasNextLine()) { // checks if the line exists

					currentLine = fileReader.nextLine(); // reads current line
					splittedLine = currentLine.split(";"); // splits line at ,
					String serialNum = splittedLine[0];
					char firstNum = serialNum.charAt(0);
					int firstNumber = Character.getNumericValue(firstNum);
					if (firstNumber <= 1 && splittedLine.length == 7) {
						Toys figures = new Figures(Long.parseLong(splittedLine[0]), splittedLine[1], splittedLine[2],
								Float.parseFloat(splittedLine[3]), Integer.parseInt(splittedLine[4]),
								Integer.parseInt(splittedLine[5]), splittedLine[6]);
						toy.add(figures);

					} else if (firstNumber <= 3 && splittedLine.length == 8) {
						Toys animal = new Animals(Long.parseLong(splittedLine[0]), splittedLine[1], splittedLine[2],
								Float.parseFloat(splittedLine[3]), Integer.parseInt(splittedLine[4]),
								Integer.parseInt(splittedLine[5]), splittedLine[6], splittedLine[7]);
						toy.add(animal);
					} else if (firstNumber <= 6 && splittedLine.length == 7) {
						Toys puzzles = new Puzzles(Long.parseLong(splittedLine[0]), splittedLine[1], splittedLine[2],
								Float.parseFloat(splittedLine[3]), Integer.parseInt(splittedLine[4]),
								Integer.parseInt(splittedLine[5]), splittedLine[6]);
						toy.add(puzzles);

					} else if (firstNumber <= 9) {
						String[] numPlayers = splittedLine[6].split("-");
						Toys boardGames = new BoardGames(Long.parseLong(splittedLine[0]), splittedLine[1],
								splittedLine[2], Float.parseFloat(splittedLine[3]), Integer.parseInt(splittedLine[4]),
								Integer.parseInt(splittedLine[5]), Integer.parseInt(numPlayers[0]),
								Integer.parseInt(numPlayers[1]), splittedLine[7]);
						toy.add(boardGames);
					}
					// Use nested if else
					// Each if is the serialnum
					// inside it adds to the object and casts it
					// add to toys
				}
				fileReader.close();
			}

			// CATCH HERE
			catch (FileNotFoundException c) {
				System.out.println("File Was not Found");
			}
			

		}
	}

}
