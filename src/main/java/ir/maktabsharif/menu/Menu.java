package ir.maktabsharif.menu;

import ir.maktabsharif.model.enums.UserType;
import ir.maktabsharif.util.ApplicationContext;
import ir.maktabsharif.util.Printer;
import ir.maktabsharif.util.Util;

public class Menu {

    public static void startMenu() {
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

    public static void loginMenu() {
        String username = Util.getStringInput("Enter Username : ");
        String password = Util.getStringInput("enter Password : ");
        try {
            UserType userType = ApplicationContext.userService.login(username, password);
            switch (userType) {
                case ADMIN -> adminMenu();
                case TEACHER -> teacherMenu();
                case STUDENT -> studentMenu();
                default -> System.out.println("Invalid User");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    public static void adminMenu() {
        System.out.println("\u001B[91m" + "Welcome to Admin Management System");
        while (true) {
            Printer.printItem(ApplicationContext.ADMIN_MENU_ITEM);
            int choice = Util.getIntInput("SELECT ONE ITEM --> ");
            switch (choice) {
                //create course
                case 1:
                    String title = Util.getStringInput("Enter Title : ");
                    String unit = Util.getStringInput("Enter Unit : ");
                    ApplicationContext.courseService.addCourse(title, unit);
                    break;
                //update course
                case 2:
                    Long id = (long) Util.getIntInput("Enter ID Course");
                    String title1 = Util.getStringInput("Enter Title : ");
                    String unit1 = Util.getStringInput("Enter Unit : ");
                    ApplicationContext.courseService.updateCourse(id, title1, unit1);
                    break;
                //delete course
                case 3:
                    Long id1 = (long) Util.getIntInput("Enter ID Course ");
                    ApplicationContext.courseService.deleteCourse(id1);
                    break;
                //create teacher
                case 4:{
                    String firstName = Util.getStringInput("Enter First Name : ");
                    String lastName = Util.getStringInput("Enter Last Name : ");
                    String gender = Util.getStringInput("Enter Gender : ");
                    Long id2 = (long) Util.getIntInput("Enter ID Course ");
                    String nationalCode = Util.getStringInput("Enter National Code : ");
                    String username = Util.getStringInput("Enter Username : ");
                    String password1 = Util.getStringInput("Enter Password : ");
                    ApplicationContext.teacherService.addTeacher(firstName,lastName,nationalCode,username,password1,id2,gender);
                }
                    break;
                case 5://update teacher
                    break;
                case 6://delete teacher
                    break;
                case 7://create student
                    break;
                case 8://update student
                    break;
                case 9://delete student
                    break;
                case 10:
                    startMenu();
                default:
                    System.out.println("Invalid Choice");

            }
        }

    }

    public static void studentMenu() {
        System.out.println("\u001B[91m" + "Welcome to Student Management System");
        while (true) {
            Printer.printItem(ApplicationContext.STUDENT_MENU_ITEM);
            int choice = Util.getIntInput("SELECT ONE ITEM --> ");
            switch (choice) {
                case 1://Assign course
                    break;
                case 2://see gpu information
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    public static void teacherMenu() {
        System.out.println("\u001B[91m" + "Welcome");
        while (true) {
            Printer.printItem(ApplicationContext.TEACHER_MENU_ITEM);
            int choice = Util.getIntInput("SELECT ONE ITEM --> ");
            switch (choice) {
                case 1://SET SCORE FOR STUDENT
                        break;
                        case 2://SEE COURSE INFORMATION
                            break;
                            case 3:break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

}
