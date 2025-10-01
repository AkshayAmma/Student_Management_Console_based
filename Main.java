package Student_Management;

import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StudentServices services=new StudentServices();

    private static int readPositiveIntegers(String message) {
        while (true) {
            try {
                System.out.println(message);
                int value = Integer.parseInt(sc.nextLine());
                if (value > 0)
                    return value;
                else
                    System.out.println("Please Enter a valid Number");
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String readNonEmptyString(String message) {
        while (true) {
            try {
                System.out.println(message);
                String input = sc.nextLine().trim();
                if (!input.isEmpty())
                    return input;
                else
                    System.out.println("input cannot be empty");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("=====Student Management Application=====");

            System.out.println("1) Add a Student");
            System.out.println("2) View all Students");
            System.out.println("3) Search Student By ID");
            System.out.println("4) Delete Student");
            System.out.println("5) Update Student Details");
            System.out.println("6) Exit");

            int choice = readPositiveIntegers("Enter Your Choice: (1-6)");

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudentsMenu();
                case 3 -> searchMenu();
                case 4 -> deleteStudent();
                case 5 -> updateStudent();
                case 6 -> {
                    System.out.println("Thank You !");
                    return;
                }
            }
        }

    }

    private static void updateStudent() {
        
        int sId = readPositiveIntegers("Enter Student Id: ");

        Student s=services.getStudentById(sId);
        if(s==null){
            System.out.println("NO Student Found");
            return;
        }

        String name=readNonEmptyString("Enter New Name: ");
        int age=readPositiveIntegers("Enter New Age: ");
        String course=readNonEmptyString("Enter New Course: ");

        if(services.updateStudent(sId, name, age, course)){
            System.out.println("Student Updated Successfully");
        }else{
            System.out.println("Update Failed");
        }

        
    }

    private static void deleteStudent() {

        int id=readPositiveIntegers("Enter Student Id: ");

        if(services.deleteStudent(id)){
            System.out.println("Student Deleted Successfully");
        }else{
            System.out.println("Student Not Found");
        }

    }

    private static void searchById() {
       int id=readPositiveIntegers("Enter Student Id: ");
       Student s=services.getStudentById(id);

       if(s!=null){
        System.out.println("Student Found: "+s);
       }else{
        System.out.println("NO Students Found with id: "+id);
       }
    }

    private static void addStudent() {

        
        String name = readNonEmptyString("Enter Student Name:");
        
        int age = readPositiveIntegers("Enter Student Age: ");
       
        String course = readNonEmptyString("Enter Student Course: ");

        services.addStudent(name, age, course);
        System.out.println("Student Added Successfully");

    }

    private static void viewStudentsMenu() {

        System.out.println("1) View All");
        System.out.println("2) Sort By Name");
        System.out.println("3) Sort By Age");
        System.out.println("4) Sort By Course");

        int option = readPositiveIntegers("Enter Option: ");
        List<Student> result;

        switch (option) {
            case 1 -> result=services.getAllStudents();
            case 2 -> result=services.getSortedStudents("name");
            case 3 -> result=services.getSortedStudents("age");
            case 4 -> result=services.getSortedStudents("course");
            default -> {
                System.out.println("Invalid Choice");
                return;
            }
        }

        if(result.isEmpty()){
            System.out.println("NO Students To Show");
        }else{
            result.forEach(System.out::println);
        }
    }

    private static void searchMenu() {
        System.out.println("1) Search By Id: ");
        System.out.println("2) Searh By Name: ");
        System.out.println("3) Search By Course: ");

        int choice = readPositiveIntegers("Enter choice: ");

        switch (choice) {
            case 1 -> searchById();
            case 2 -> searchByName();
            case 3 -> searchByCourse();
            default -> System.out.println("Invalic choice");
        }
    }

    private static void searchByName() {
        String name=readNonEmptyString("Enter Name :");
        List<Student> result=services.searchByName(name);

        if(result.isEmpty()){
            System.out.println("NO Students Found with name Containing: "+name);
        }else{
            result.forEach(System.out::println);
        }
    }

    private static void searchByCourse() {
        String course=readNonEmptyString("Enter Course: ");
        List<Student> result=services.searchByCourse(course);

        if(result.isEmpty()){
            System.out.println("NO Students found enrolled in course: "+course);
        }else{
            result.forEach(System.out::println);
        }

    }
}
