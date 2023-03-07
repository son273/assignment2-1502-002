package mru.store.view;

import java.util.Scanner;

public class AppMenu {

	Scanner input;

	public AppMenu() {
		input = new Scanner(System.in);
	}

	public int showMainMenu() {
		System.out.println("***********************************************");
		System.out.println("* WELCOME TO TOYSTORE COMPANY *");
		System.out.println("***********************************************\n");
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

	public void saveMessage() {
		System.out.println("Saving Data Into Database\n");
		System.out.println("***********************************************");
		System.out.println("* THANKS FOR VISTING US! *");
		System.out.println("***********************************************");

	}

}
