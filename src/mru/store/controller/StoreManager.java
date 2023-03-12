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

				String type = menu.promptType();

			case 4:
				flag = false;
				break;

			}
		}

	}

	public void serialSearch() {
		long serialNum = menu.promptSerialNum();
		boolean found = false;

		for (Toys item : toy)
			if (item.getSerialNumber() == serialNum && item.getAvalibleCount() > 0) {
				found = true;
				menu.serialSearchResults(item.toString());
				int choice = menu.promptPurchase();
				if (choice == 1) {
					int stock = item.getAvalibleCount();
					stock -= 1;
					item.setAvalibleCount(stock);
					menu.purchaseSuccessful();

				} else if (choice == 2) {
					break;
				} else {
					menu.validateOptionNotValid();
				}
				break;
			} else if (item.getSerialNumber() == serialNum && item.getAvalibleCount() == 0) {
				menu.noStock();
				break;
			}
		if (found != true) {
			menu.doesntExist();

		}
	}

	private void nameSearch() {
		boolean found = false;
		String name = menu.prompToyName().trim().toLowerCase();
		;
		ArrayList<Toys> nameArray = new ArrayList<>();
		int count = 0;

		for (Toys item : toy) {
			if (item.getName().toLowerCase().trim().contains(name) && item.getAvalibleCount() > 0) {
				nameArray.add(item);
				count++;
				found = true;
			} else if (item.getName().toLowerCase().trim().contains(name) && item.getAvalibleCount() == 0) {
				nameArray.remove(item);
			}
		}
		menu.nameSearchResults(nameArray, count);

		// name.trim.tolowercase
		// make another array list
		// put everything with the name
		// item.getName.trim().tolowercase().contains(name)
		//
		if (found != true) {
			menu.doesntExist();

		}
	}

	private void typeSearch() {
		String type = menu.promptType();
		// prompt enter type
		// use array list to search for type matching it
		// if item is instanceof typeOfToy(animals, boardGames, etc) then print out

	}

	private void addToy() {
		// prompt for serial number
		long serialNum = serialNum();
		String toyName = menu.prompToyName();
		String toyBrand = menu.prompBrandName();
		float toyPrice = getToyPrice();
		int availability = getAvailability();
		int age = getAge();
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

		long serialNum = 0;

		try {
			// prompt to enter a serial number
			serialNum = menu.promptSerialNum();

			// validate length of the serial number
			while (String.valueOf(serialNum).length() != 10) {
				menu.validateSNLength();
				serialNum = menu.promptSerialNum();
			}

			// check if the serial number exists
			boolean serialNumExists = true;
			while (serialNumExists) {
				serialNumExists = false;
				for (Toys item : toy) {
					if (item.getSerialNumber() == serialNum) {
						menu.validateExistingSN();
						serialNum = menu.promptSerialNum();
						serialNumExists = true;
						break;
					}
				}
			}
		} catch (InputMismatchException e) {
			menu.validateSN();
			serialNum = menu.promptSerialNum();
		}

		return serialNum;
	}

	private float getToyPrice() {
		float toyPrice = 0;
		try {
			toyPrice = menu.promptToyPrice();
			if (toyPrice < 0) {
				menu.validateNegativeNum();
				return getToyPrice();
			}
		} catch (InputMismatchException e) {
			menu.validateEnterNum();
			toyPrice = menu.promptToyPrice();
		}
		return toyPrice;
	}

	private int getAvailability() {
		int toyAvailability = 0;
		try {
			toyAvailability = menu.promptAvailability();
			if (toyAvailability < 0) {
				menu.validateNegativeNum();
				return getAvailability();
			}
		} catch (InputMismatchException e) {
			menu.validateEnterNum();
			toyAvailability = menu.promptAvailability();
		}
		return toyAvailability;
	}

	private int getAge() {
		int minAge = 0;
		try {
			minAge = menu.promptAge();
			if (minAge < 0) {
				menu.validateNegativeNum();
				return getAvailability();
			}
		} catch (InputMismatchException e) {
			menu.validateEnterNum();
			minAge = menu.promptAge();
		}
		return minAge;
	}

	private void removeToy() {
		long serialNum = menu.promptSerialNum();
		boolean found = false;

		for (Toys item : toy)
			if (item.getSerialNumber() == serialNum) {
				found = true;
				menu.serialSearchRemoval(item.toString());
				char choice = menu.promptRemoval();
				switch (choice) {
				case 'y':
					toy.remove(item);
					menu.toyRemovedMessage();
				case 'n':
					break;
				default:
					menu.validateOptionNotValid();
				}
			}
		if (found != true) {
			menu.doesntExist();
		}
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
