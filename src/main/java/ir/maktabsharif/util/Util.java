package ir.maktabsharif.util;

import ir.maktabsharif.thread.ConsoleEraser;

import java.io.Console;
import java.util.Scanner;

public class Util {
    private static final Scanner sc = new Scanner(System.in);
    private static final  Console console = System.console();


    public static String getStringInput(String prompt) {
        System.out.print("\u001B[35m"+">>" +prompt);
        return sc.next();
    }
    public static int getIntInput(String prompt) {
        System.out.print("\u001B[35m"+">>" +prompt);
        int input = sc.nextInt();
        sc.nextLine();
        return input;
    }

    public static String getPasswordInput(String prompt) {
        System.out.print("\u001B[35m"+">>" +prompt);
        return  readPassword();
    }
    private static String readPassword() {
        ConsoleEraser consoleEraser = new ConsoleEraser();
        consoleEraser.start();

        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        consoleEraser.halt();
        return password;
    }

}