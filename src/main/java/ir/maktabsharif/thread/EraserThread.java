//package ir.maktabsharif.thread;
//
//import java.io.BufferedReader;
//import java.io.Console;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class ConsoleUtil {
//
//    /**
//     * Handles console input when running outside of Eclipse.
//     *
//     * @param console the console to use in order to receive input
//     * @param msg the prompt message
//     * @return the password input by the user
//     */
//    public static String getPasswordMasked(Console console, String msg)
//    {
//        char[] passwd;
//        while (true) {
//            passwd = console.readPassword("%s", msg);
//            if (passwd != null) {
//                if (passwd.length > 0) {
//                    return new String(passwd);
//                } else {
//                    System.out.println("Invalid input\n");
//                }
//            }
//        }
//    }
//
//    /**
//     * Handles console input when running inside of Eclipse; See Eclipse bug
//     * #122429.
//     *
//     * @param msg the prompt message
//     * @return the password input by the user
//     * @throws IOException if password is zero-length
//     */
//    public static String getPasswordWithinEclipse(String msg)
//            throws IOException
//    {
//        // In Eclipse IDE
//        System.out.print(msg);
//        BufferedReader reader = new BufferedReader(new InputStreamReader(
//                System.in));
//        String password = reader.readLine();
//        if (password != null) {
//            if (password.length() <= 0) {
//                System.out.println("Invalid input\n");
//                throw new IOException("Error reading in password");
//            }
//        }
//        return password;
//    }
//
//
//    public static void main(String[] args) {
//        String password = null;
//        String pwdMessage = "Enter the password: ";
//        Console cons = System.console();
//        if (cons == null) {
//            // We are in the Eclipse IDE.
//            try {
//                System.out.println("LOG: Running within Eclipse IDE...");
//                System.out.println("LOG: Password will not be masked");
//                password = Util.getPasswordWithinEclipse(pwdMessage);
//                System.out.println("LOG: Password entered");
//            } catch (IOException e) {
//                System.err.println("Error getting password" + e.getMessage());
//                System.exit(1);
//            }
//        } else {
//            password = Util.getPasswordMasked(cons, pwdMessage);
//        }
//    }
//}