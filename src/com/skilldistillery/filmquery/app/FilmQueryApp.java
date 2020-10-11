package com.skilldistillery.filmquery.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
//    app.test();
		app.launch();
	}

//	private void test() {
//		Film film = db.findFilmById(1);
//		System.out.println(film);
//	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		showMenu(input);

	}

	private void showMenu(Scanner input) {
		System.out.println();
		System.out.println("==================== MENU =================");
		System.out.println("|                                         |");
		System.out.println("|      Enter a number from the list       |");
		System.out.println("|                                         |");
		System.out.println("|  1. Lookup a film by its id.            |");
		System.out.println("|  2. Lookup a film by a search keyword.  |");
		System.out.println("|  3. Exit the application.               |");
		System.out.println("|                                         |");
		System.out.println("===========================================");
		System.out.println();
		menuAction(input);
	}

	private void menuAction(Scanner input) {
		String menuSelection = input.next();
		Film f = new Film();
		List<Film> filmList = new ArrayList<>();
		boolean keepGoing = true;
		while (keepGoing) {
			switch (menuSelection) {
			case "1":
				input.nextLine();
				System.out.print("Enter the film id: ");
				f = db.findFilmById(input.nextInt());
				if (f != null) {
					System.out.println(f);
				} else {
					System.out.println("Flim id not found. Please try again.");
				}
				showSubMenu(input, f, filmList);
				break;
			case "2":
				input.nextLine();
				System.out.print("Enter the search word: ");
				filmList = db.findFilmByKeyword(input.nextLine());
				if (filmList != null) {
					System.out.println(filmList);
				} else {
					System.out.println("Keyword not found. Please try again.");
				}
				showSubMenu(input, f, filmList);
				break;
			case "3":
				input.nextLine();
				System.out.println("You selected to exit the application. Goodbye.");
				System.exit(0);
			default:
				System.out.println("Invalid selection. Please enter a number 1 - 3.");
				keepGoing = false;
				showMenu(input);
				break;
			}

		}
	}

	private void showSubMenu(Scanner input, Film f, List<Film> filmList) {
		System.out.println();
		System.out.println("============== MENU ==============");
		System.out.println("|                                |");
		System.out.println("|  Enter a number from the list  |");
		System.out.println("|                                |");
		System.out.println("|  1. Return to main menu.       |");
		System.out.println("|  2. View all film details.     |");
		System.out.println("|                                |");
		System.out.println("|                                |");
		System.out.println("==================================");
		System.out.println();
		SubMenuAction(input, f, filmList);
	}

	private void SubMenuAction(Scanner input, Film f, List<Film> lf) {
		String menuSelection = input.next();
		boolean keepGoing = true;
		while (keepGoing) {
			switch (menuSelection) {
			case "1":
				input.nextLine();
				showMenu(input);
				break;
			case "2":
				input.nextLine();
				if(f.getActors() != null) {
					f.showFilmDetails();
					showMenu(input);
					break;
				}
				else if(lf !=null){

					for (Film film : lf) {
						film.showFilmDetails();
					}
					showMenu(input);
					break;
				}
			default:System.out.println("Invalid selection. Please enter a number 1 - 3.");
			keepGoing = false;
			showMenu(input);
			break;
				
				}
			}
				
		}
	}
