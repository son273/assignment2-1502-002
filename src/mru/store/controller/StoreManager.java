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
//		boolean exceptionLoop = true;
//		while (exceptionLoop) {
//			try {
				while (flag) {
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
//						exceptionLoop = false;
						flag = false;
						break;
					}
//				}
//			}catch(InputMismatchException e) {
//				menu.validateNumNotValid();
			}
//		}
	}

	private void findAndPurchase() {
		boolean flag = true;
		// use case to
		while (flag) {
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
			case 4:
				flag = false;
				break;
	
			}
		}

	}
	public void serialSearch() {
		boolean found = false;
		boolean exceptionLoop = true;
		boolean enter = true;
		long serialNum = 0;
		while (exceptionLoop) {
			try {
				serialNum = menu.promptSerialNum();
				
				
				for (Toys item : toy)
					if(item.getSerialNumber() == serialNum && item.getAvalibleCount() > 0) {
						found = true;
						menu.serialSearchResults(item.toString());
						int choice = menu.promptPurchase();
						if(choice == 1) {
							int stock = item.getAvalibleCount();
							stock -= 1;
							item.setAvalibleCount(stock);
							menu.purchaseSuccessful();
							menu.promptEnterKey();
							enter = false;
							
						}
						else if (choice == 2) {
							enter = false;
							break;
						}
						else {
							menu.validateOptionNotValid();
							menu.promptEnterKey();
							break;
						}
						break;
					}
					
					else if(item.getSerialNumber() == serialNum && item.getAvalibleCount() == 0) {
						menu.noStock();
						break;
					}
				if (found != true) {
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
	
	
	
	
	private void nameSearch() {
		boolean found = false;
		boolean enter = false;
		String name = menu.prompToyName().trim().toLowerCase();;
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
		}
		if (found != true) {
			menu.doesntExist();
			enter = true;
			menu.promptEnterKey();

		}
		

		while(enter != true) { // This loops is responsible for dealing with purchase of item and validating proper inputs
			listSize = menu.nameSearchResults(nameArray, itemCount);
			try {
				
				choice = menu.promptPurchase();
				choice -= 1;
				listSize -= 1;
				if (choice == listSize) {
					break;
				}
				else if (choice > listSize || choice < 0){
					menu.validateOptionNotValid();
					menu.promptEnterKey();
					break;
				}
				
				else{
					Toys item = nameArray.get(choice);
					int stock = item.getAvalibleCount();
					stock -= 1;
					item.setAvalibleCount(stock);
					menu.purchaseSuccessful();
					
				menu.promptEnterKey();
				enter = true;
				}
			}
			catch(InputMismatchException mismatch){
				menu.validateNumNotValid();
			}
		
		}
		
		
		
	}
	
	private void typeSearch() {
		String type = menu.promptType().trim().toLowerCase();
		ArrayList<Toys> nameArray = new ArrayList<>();
		int listSize = 0;
		int itemCount = 0;
		boolean enter = false;
		for (Toys item : toy) {
			if (type == "animals" || type == "animal") {
				if (item instanceof Animals) {
					if (item.getAvalibleCount() > 0) {
						nameArray.add(item);
						itemCount ++;
					}
						
				}
				//instance of...
				//show it like in names
				//
			}
			else if(type == "figures" || type == "figure") {
				if (item instanceof Figures) {
					if (item.getAvalibleCount() > 0) {
						nameArray.add(item);
						itemCount ++;
					}
						
				}
				
			}
			else if (type == "puzzles" || type == "puzzle") {
				if (item instanceof Puzzles) {
					if (item.getAvalibleCount() > 0) {
						nameArray.add(item);
						itemCount ++;
					}
						
				}
				
			}
			else if (type == "boardgames" || type == "boardgame") {
				if (item instanceof BoardGames) {
					if (item.getAvalibleCount() > 0) {
						nameArray.add(item);
						itemCount ++;
					}
						
				}
				
			}
			else {
				menu.validateOptionNotValid();
				enter = true;
				menu.promptEnterKey();
				break;
			}
			
		}
		while (enter != true) {
		listSize = menu.nameSearchResults(nameArray, itemCount);
		try {
			
		}
		catch(InputMismatchException mismatch){
			menu.validateNumNotValid();
		}
		//prompt enter type
		//use array list to search for type matching it
		//if item is instanceof typeOfToy(animals, boardGames, etc) then print out 
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
			for (Toys t : toy) {
				pw.printf(t.format());
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
					if (firstNumber <= 1) {
						Toys figures = new Figures(Long.parseLong(splittedLine[0]), splittedLine[1], splittedLine[2],
								Float.parseFloat(splittedLine[3]), Integer.parseInt(splittedLine[4]),
								Integer.parseInt(splittedLine[5]), splittedLine[6]);
						toy.add(figures);

					} else if (firstNumber <= 3) {
						Toys animal = new Animals(Long.parseLong(splittedLine[0]), splittedLine[1], splittedLine[2],
								Float.parseFloat(splittedLine[3]), Integer.parseInt(splittedLine[4]),
								Integer.parseInt(splittedLine[5]), splittedLine[6], splittedLine[7]);
						toy.add(animal);
					} else if (firstNumber <= 6) {
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
