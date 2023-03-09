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
		menuOptions();
		//
	}

	public void menuOptions() {
		boolean flag = true;
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
				flag = false;
				break;
			}
		}
	}

	private void findAndPurchase() {
		int choice = menu.searchMenu();
		// use case to
		switch (choice) {
		case 1:
			//Here we just check if the item exist or not
			//send 
			long serialNum = menu.promptSerialNum();	
			boolean serialNumExists = false;
			long serialNumber = 0;
			
			for (Toys item : toy)
				if(item.getSerialNumber() == serialNum) {
					serialNumExists = true;
					serialNumber = item.getSerialNumber();
				}
			searchNumResults(serialNumExists, serialNumber);
			break;
		case 2:
			// prompt enter name
			// use array list to search for name matching it
			String name = menu.prompBrandName();
			//prompt enter name
			//use array list to search for name matching it
			break;
		case 3:
			// prompt enter type
			// use array list to search for type matching it
			// if item is instanceof typeOfToy(animals, boardGames, etc) then print out
			String type = menu.promptType();
			//prompt enter type
			//use array list to search for type matching it
			//if item is instanceof typeOfToy(animals, boardGames, etc) then print out 
			break;
		case 4:
			// back to main menu
			break;

		}

	}
	
	
	private void searchNumResults(Boolean found, long serialNum) {
		if (found = false) {
			menu.doesntExist();
		}
		else {
			
		}
	}
	
	

	private void addToy() {
		// prompt for serial number
		long serialNum = menu.promptSerialNum();
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
		} else if (firstNum <= 3) {
			String material = menu.promptAnimalMaterial();
			String size = menu.promptAnimalSize();
		} else if (firstNum <= 6) {
			String puzzleType = menu.promptPuzzleType();
		} else if (firstNum <= 9) {
			int minPlayers = menu.promptBoardGameMinPlayers();
			int maxPlayers = menu.promptBoardGameMaxPlayers();
			String designers = menu.promptBoardGameDesigners();
		}

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
