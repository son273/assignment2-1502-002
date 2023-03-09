package mru.store.view;

import java.util.Scanner;

public class AppMenu {

	Scanner input;

	public AppMenu() {
		input = new Scanner(System.in);
		welcomeMessage();
	}

	public void welcomeMessage() {
		System.out.println("***********************************************");
		System.out.println("* WELCOME TO TOYSTORE COMPANY *");
		System.out.println("***********************************************\n");
	}

	public int showMainMenu() {
		System.out.println("How May We Help You?\n");
		System.out.println("\t (1) Search Inventory and Purchase Toy");
		System.out.println("\t (2) Add New Toy");
		System.out.println("\t (3) Remove Existing Toy");
		System.out.println("\t (4) Save and Exit\n");
		System.out.println("Enter Option:");
		int option = input.nextInt();
		return option;
	}

	public int searchMenu() {
		System.out.println("Find Toys With:\n");
		System.out.println("\t (1) Serial Number (SN)");
		System.out.println("\t (2) Toy Name");
		System.out.println("\t (3) Type");
		System.out.println("\t (4) Back to Main Menu\n");
		System.out.println("Enter Option:");
		int option = input.nextInt();
		return option;
	}

	public int promptOption() {
		System.out.println("Enter Option:\n");
		int option = input.nextInt();
		return option;
	}

	public void promptEnterKey() {
		System.out.println("Press Enter to Continue...");
		input.nextLine();
	}
	
	public String promptType() {
		System.out.println("Enter Type: ");
		String toyType = input.next().trim();
		return toyType;
	}

	public long promptSerialNum() {
		System.out.println("Enter Serial Number: ");
		long serialNum = input.nextLong();
		return serialNum;
	}

	public String prompToyName() {
		System.out.println("Enter Toy Name: ");
		String toyName = input.next();
		return toyName;
	}

	public String prompBrandName() {
		System.out.println("Enter Brand Name: ");
		String brandName = input.next();
		return brandName;
	}

	public float promptToyPrice() {
		System.out.println("Enter Toy Price: ");
		float toyPrice = input.nextFloat();
		return toyPrice;
	}

	public int promptAvailability() {
		System.out.println("Enter Available Counts: ");
		int availability = input.nextInt();
		return availability;
	}

	public int promptAge() {
		System.out.println("Enter Appropriate Age: ");
		int minAge = input.nextInt();
		return minAge;
	}

	public String promptFigureClass() {
		System.out.println("Enter Figure Classification (Action, Doll, or Historic): ");
		String figureClass = input.next().toLowerCase();
		return figureClass;
	}

	public String promptAnimalMaterial() {
		System.out.println("Enter Animal Material: ");
		String animalMaterial = input.next().toLowerCase();
		return animalMaterial;
	}

	public String promptAnimalSize() {
		System.out.println("Enter Animal Size (Small, Medium, or Large): ");
		String animalSize = input.next().toLowerCase();
		return animalSize;
	}

	public String promptPuzzleType() {
		System.out.println("Enter Puzzle Type (Mechanical, Cryptic, Logic, Trivia, or Riddle): ");
		String puzzleType = input.next().toLowerCase();
		return puzzleType;
	}

	public int promptBoardGameMinPlayers() {
		System.out.println("Enter Minimum Number of Players: ");
		int minPlayers = input.nextInt();
		return minPlayers;
	}

	public int promptBoardGameMaxPlayers() {
		System.out.println("Enter Maximum Number of Players: ");
		int maxPlayers = input.nextInt();
		return maxPlayers;
	}

	public String promptBoardGameDesigners() {
		System.out.println("Enter Designer Names (Seperate Names Using ','): ");
		String designerName = input.next();
		return designerName;
	}

	public void toyAddedMessage() {
		System.out.println("New Toy Added!");
	}

	public char promptRemoval() {
		System.out.println("Do you want to remove it? (Y/N)");
		char option = input.nextLine().toLowerCase().charAt(0);
		return option;
	}

	public void toyRemovedMessage() {
		System.out.println("Item Removed!");
	}
	

	public void saveMessage() {
		System.out.println("Saving Data Into Database\n");
		System.out.println("***********************************************");
		System.out.println("* THANKS FOR VISTING US! *");
		System.out.println("***********************************************");
	}

	public void validateNumNotValid() {
		System.out.println("This is Not an Integer Number! Try Again.\n");
	}

	public void validateOptionNotValid() {
		System.out.println("This is Not an Valid Option! Try Again.\n");
	}

	public void validateExistingSN() {
		System.out.println("A Toy With This Serial Number Already Exists! Try Again.\n");

	}

	public void validateSN() {
		System.out.println("The Serial Number should only contain Digits! Try Again.\n");

	}

	public void validateSNLength() {
		System.out.println("The Serial Number's legnth MUST be 10 digits! Try Again.\n");

	}
	public void doesntExist() {
		System.out.println("Item does not exist");
	}



}
