package com.beehood.main;

import java.util.Scanner;

import com.beehood.inventory.system.InventorySystem;
import com.beehood.library.system.LibrarySystem;
import com.beehood.student.system.StudentSystem;

public class MainSystem {

	public static void main(String[] args) {

		Scanner sn = new Scanner(System.in);
		StudentSystem student = new StudentSystem();
		LibrarySystem library = new LibrarySystem();
		InventorySystem inventory = new InventorySystem();

		int choice = 0;

		do {

			System.out.println("\n===== MAIN MENU =====");
			System.out.println("1. Student System");
			System.out.println("2. Library System");
			System.out.println("3. Inventory System");
			System.out.println("4. Exit");
			System.out.print("Enter choice: ");

			while (!sn.hasNextInt()) {
				System.out.println("Invalid input! Please enter a number.");
				sn.next();
				System.out.print("Enter choice: ");
			}

			choice = sn.nextInt();
			sn.nextLine();

			switch (choice) {

			case 1:

				int studentChoice = 0;

				do {

					System.out.println("\n--- Student Menu ---");
					System.out.println("1. Add");
					System.out.println("2. View");
					System.out.println("3. Search");
					System.out.println("4. Update");
					System.out.println("5. Delete");
					System.out.println("6. Back");
					System.out.print("Enter choice: ");

					while (!sn.hasNextInt()) {
						System.out.println("Invalid input! Please enter a number.");
						sn.next();
						System.out.print("Enter choice: ");
					}

					studentChoice = sn.nextInt();
					sn.nextLine();

					switch (studentChoice) {

					case 1:

						System.out.print("Enter ID: ");

						while (!sn.hasNextInt()) {
							System.out.println("Invalid ID! Please enter a number.");
							sn.next();
							System.out.print("Enter ID: ");
						}

						int sid = sn.nextInt();

						while (sid <= 0) {
							System.out.println("ID must be greater than 0.");
							System.out.print("Enter ID: ");
							sid = sn.nextInt();
						}

						while (student.exists(sid)) {
							System.out.println("Duplicate ID! Please enter a different ID.");
							System.out.print("Enter ID: ");
							while (!sn.hasNextInt()) {
								System.out.println("Invalid ID! Please enter a number.");
								sn.next();
								System.out.print("Enter ID: ");
							}
							sid = sn.nextInt();
							while (sid <= 0) {
								System.out.println("ID must be greater than 0.");
								System.out.print("Enter ID: ");
								sid = sn.nextInt();
							}
						}

						sn.nextLine();

						System.out.print("Enter Name: ");
						String sname = sn.nextLine();

						while (sname.trim().isEmpty() || !sname.matches("[a-zA-Z ]+")) {
							System.out.println("Invalid name! Only letters allowed.");
							System.out.print("Enter Name: ");
							sname = sn.nextLine();
						}

						System.out.print("Enter Marks: ");

						while (!sn.hasNextDouble()) {
							System.out.println("Invalid marks! Please enter a number.");
							sn.next();
							System.out.print("Enter Marks: ");
						}

						double marks = sn.nextDouble();

						while (marks < 0 || marks > 100) {
							System.out.println("Marks must be between 0 and 100.");
							System.out.print("Enter Marks: ");
							while (!sn.hasNextDouble()) {
								System.out.println("Invalid marks!");
								sn.next();
							}
							marks = sn.nextDouble();
						}

						student.add(sid, sname, marks);
						break;

					case 2:

						student.view();
						break;

					case 3:

						System.out.print("Enter ID: ");

						while (!sn.hasNextInt()) {
							System.out.println("Invalid ID!");
							sn.next();
							System.out.print("Enter ID: ");
						}

						student.search(sn.nextInt());
						break;

					case 4:

						System.out.print("Enter ID: ");

						while (!sn.hasNextInt()) {
							System.out.println("Invalid ID!");
							sn.next();
							System.out.print("Enter ID: ");
						}

						int uid = sn.nextInt();

						while (uid <= 0) {
							System.out.println("ID must be greater than 0.");
							System.out.print("Enter ID: ");
							uid = sn.nextInt();
						}

						sn.nextLine();

						System.out.print("Enter New Name: ");
						String uname = sn.nextLine();

						while (uname.trim().isEmpty() || !uname.matches("[a-zA-Z ]+")) {
							System.out.println("Invalid name! Only letters allowed.");
							System.out.print("Enter New Name: ");
							uname = sn.nextLine();
						}

						System.out.print("Enter New Marks: ");

						while (!sn.hasNextDouble()) {
							System.out.println("Invalid marks!");
							sn.next();
							System.out.print("Enter New Marks: ");
						}

						double umarks = sn.nextDouble();

						while (umarks < 0 || umarks > 100) {
							System.out.println("Marks must be between 0 and 100.");
							System.out.print("Enter New Marks: ");
							while (!sn.hasNextDouble()) {
								System.out.println("Invalid marks!");
								sn.next();
							}
							umarks = sn.nextDouble();
						}

						student.update(uid, uname, umarks);
						break;

					case 5:

						System.out.print("Enter ID: ");

						while (!sn.hasNextInt()) {
							System.out.println("Invalid ID!");
							sn.next();
							System.out.print("Enter ID: ");
						}

						student.delete(sn.nextInt());
						break;

					case 6:

						System.out.println("Returning...");
						break;

					default:

						System.out.println("Invalid choice!");
					}

				} while (studentChoice != 6);

				break;

			case 2:

				int libraryChoice = 0;

				do {

					System.out.println("\n--- Library Menu ---");
					System.out.println("1. Add");
					System.out.println("2. View");
					System.out.println("3. Search");
					System.out.println("4. Update");
					System.out.println("5. Delete");
					System.out.println("6. Back");
					System.out.print("Enter choice: ");

					while (!sn.hasNextInt()) {
						System.out.println("Invalid input!");
						sn.next();
						System.out.print("Enter choice: ");
					}

					libraryChoice = sn.nextInt();
					sn.nextLine();

					switch (libraryChoice) {

					case 1:

						System.out.print("Enter ID: ");

						while (!sn.hasNextInt()) {
							System.out.println("Invalid ID!");
							sn.next();
							System.out.print("Enter ID: ");
						}

						int bid = sn.nextInt();

						while (bid <= 0) {
							System.out.println("ID must be greater than 0.");
							System.out.print("Enter ID: ");
							bid = sn.nextInt();
						}

						while (library.exists(bid)) {
							System.out.println("Duplicate ID! Please enter a different ID.");
							System.out.print("Enter ID: ");
							while (!sn.hasNextInt()) {
								System.out.println("Invalid ID! Please enter a number.");
								sn.next();
								System.out.print("Enter ID: ");
							}
							bid = sn.nextInt();
							while (bid <= 0) {
								System.out.println("ID must be greater than 0.");
								System.out.print("Enter ID: ");
								bid = sn.nextInt();
							}
						}

						sn.nextLine();

						System.out.print("Enter Title: ");
						String title = sn.nextLine();

						while (title.trim().isEmpty()) {
							System.out.println("Title cannot be empty.");
							System.out.print("Enter Title: ");
							title = sn.nextLine();
						}

						System.out.print("Enter Author: ");
						String author = sn.nextLine();

						while (author.trim().isEmpty() || !author.matches("[a-zA-Z ]+")) {
							System.out.println("Invalid author name!");
							System.out.print("Enter Author: ");
							author = sn.nextLine();
						}

						library.add(bid, title, author);
						break;

					case 2:

						library.view();
						break;

					case 3:

						System.out.print("Enter ID: ");

						while (!sn.hasNextInt()) {
							System.out.println("Invalid ID!");
							sn.next();
							System.out.print("Enter ID: ");
						}

						library.search(sn.nextInt());
						break;

					case 4:

						System.out.print("Enter ID: ");

						while (!sn.hasNextInt()) {
							System.out.println("Invalid ID!");
							sn.next();
							System.out.print("Enter ID: ");
						}

						int ubid = sn.nextInt();
						sn.nextLine();

						System.out.print("Enter New Title: ");
						String utitle = sn.nextLine();

						while (utitle.trim().isEmpty()) {
							System.out.println("Title cannot be empty.");
							System.out.print("Enter New Title: ");
							utitle = sn.nextLine();
						}

						System.out.print("Enter New Author: ");
						String uauthor = sn.nextLine();

						while (uauthor.trim().isEmpty() || !uauthor.matches("[a-zA-Z ]+")) {
							System.out.println("Invalid author name!");
							System.out.print("Enter New Author: ");
							uauthor = sn.nextLine();
						}

						library.update(ubid, utitle, uauthor);
						break;

					case 5:

						System.out.print("Enter ID: ");

						while (!sn.hasNextInt()) {
							System.out.println("Invalid ID!");
							sn.next();
							System.out.print("Enter ID: ");
						}

						library.delete(sn.nextInt());
						break;

					case 6:

						System.out.println("Returning...");
						break;

					default:

						System.out.println("Invalid choice!");
					}

				} while (libraryChoice != 6);

				break;

			case 3:

				int inventoryChoice = 0;

				do {

					System.out.println("\n--- Inventory Menu ---");
					System.out.println("1. Add");
					System.out.println("2. View");
					System.out.println("3. Search");
					System.out.println("4. Update");
					System.out.println("5. Delete");
					System.out.println("6. Back");
					System.out.print("Enter choice: ");

					while (!sn.hasNextInt()) {
						System.out.println("Invalid input!");
						sn.next();
						System.out.print("Enter choice: ");
					}

					inventoryChoice = sn.nextInt();
					sn.nextLine();

					switch (inventoryChoice) {

					case 1:

						System.out.print("Enter ID: ");

						while (!sn.hasNextInt()) {
							System.out.println("Invalid ID!");
							sn.next();
							System.out.print("Enter ID: ");
						}

						int iid = sn.nextInt();

						while (iid <= 0) {
							System.out.println("ID must be greater than 0.");
							System.out.print("Enter ID: ");
							iid = sn.nextInt();
						}

						while (inventory.exists(iid)) {
							System.out.println("Duplicate ID! Please enter a different ID.");
							System.out.print("Enter ID: ");
							while (!sn.hasNextInt()) {
								System.out.println("Invalid ID! Please enter a number.");
								sn.next();
								System.out.print("Enter ID: ");
							}
							iid = sn.nextInt();
							while (iid <= 0) {
								System.out.println("ID must be greater than 0.");
								System.out.print("Enter ID: ");
								iid = sn.nextInt();
							}
						}

						sn.nextLine();

						System.out.print("Enter Name: ");
						String iname = sn.nextLine();

						while (iname.trim().isEmpty() || !iname.matches("[a-zA-Z ]+")) {
							System.out.println("Invalid name!");
							System.out.print("Enter Name: ");
							iname = sn.nextLine();
						}

						System.out.print("Enter Price: ");

						while (!sn.hasNextDouble()) {
							System.out.println("Invalid price!");
							sn.next();
							System.out.print("Enter Price: ");
						}

						double price = sn.nextDouble();

						while (price < 0) {
							System.out.println("Price cannot be negative.");
							System.out.print("Enter Price: ");
							price = sn.nextDouble();
						}

						System.out.print("Enter Quantity: ");

						while (!sn.hasNextInt()) {
							System.out.println("Invalid quantity!");
							sn.next();
							System.out.print("Enter Quantity: ");
						}

						int qty = sn.nextInt();

						while (qty < 0) {
							System.out.println("Quantity cannot be negative.");
							System.out.print("Enter Quantity: ");
							qty = sn.nextInt();
						}

						inventory.add(iid, iname, price, qty);
						break;

					case 2:

						inventory.view();
						break;

					case 3:

						System.out.print("Enter ID: ");

						while (!sn.hasNextInt()) {
							System.out.println("Invalid ID!");
							sn.next();
							System.out.print("Enter ID: ");
						}

						inventory.search(sn.nextInt());
						break;

					case 4:

						System.out.print("Enter ID: ");

						while (!sn.hasNextInt()) {
							System.out.println("Invalid ID!");
							sn.next();
							System.out.print("Enter ID: ");
						}

						int uiid = sn.nextInt();
						sn.nextLine();

						System.out.print("Enter New Name: ");
						String uiname = sn.nextLine();

						while (uiname.trim().isEmpty() || !uiname.matches("[a-zA-Z ]+")) {
							System.out.println("Invalid name!");
							System.out.print("Enter New Name: ");
							uiname = sn.nextLine();
						}

						System.out.print("Enter New Price: ");

						while (!sn.hasNextDouble()) {
							System.out.println("Invalid price!");
							sn.next();
							System.out.print("Enter New Price: ");
						}

						double uprice = sn.nextDouble();

						while (uprice < 0) {
							System.out.println("Price cannot be negative.");
							System.out.print("Enter New Price: ");
							uprice = sn.nextDouble();
						}

						System.out.print("Enter New Quantity: ");

						while (!sn.hasNextInt()) {
							System.out.println("Invalid quantity!");
							sn.next();
							System.out.print("Enter New Quantity: ");
						}

						int uqty = sn.nextInt();

						while (uqty < 0) {
							System.out.println("Quantity cannot be negative.");
							System.out.print("Enter New Quantity: ");
							uqty = sn.nextInt();
						}

						inventory.update(uiid, uiname, uprice, uqty);
						break;

					case 5:

						System.out.print("Enter ID: ");

						while (!sn.hasNextInt()) {
							System.out.println("Invalid ID!");
							sn.next();
							System.out.print("Enter ID: ");
						}

						inventory.delete(sn.nextInt());
						break;

					case 6:

						System.out.println("Returning...");
						break;

					default:

						System.out.println("Invalid choice!");
					}

				} while (inventoryChoice != 6);

				break;

			case 4:

				System.out.println("Exiting...");
				break;

			default:

				System.out.println("Invalid choice!");
			}

		} while (choice != 4);

	}

}