package ir.maktabsharif.menu;

import ir.maktabsharif.util.ApplicationContext;
import ir.maktabsharif.util.Printer;
import ir.maktabsharif.util.Util;

public class Menu {

    public static void startMenu(){
        System.out.println("\u001B[91m" + "Welcome to School Management System");

        while (true) {
            Printer.printItem(ApplicationContext.LOGIN_MENU_ITEM);
            int choice = Util.getIntInput("SELECT ONE ITEM --> ");
            switch (choice) {
                case 1 -> loginMenu();
                case 2 -> System.exit(0);
                default -> System.out.println("Invalid Choice");
            }
        }
    }
    public static void loginMenu(){



    }

}
