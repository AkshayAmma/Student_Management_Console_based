🎓 Student Management System (Java Console Application)

A simple console-based Java application to manage student records. It supports adding, viewing, searching, updating, deleting, and sorting student data. Student data is saved persistently using file serialization.


 📁 Project Structure
 1) Main.java - Main class with user interface and program entry point
 2) Student.java - Student Model Class (implements Serializable)
 3) StudentService.java - Service class Containing business logic and data handeling
 4) Students.dat - Data file storing serialized list of students


 🛠 Requirements

- Java Development Kit (JDK) 8 or higher
- Terminal or command prompt for compiling and running


🚀 How to Compile & Run

1. Pull or download this repository then extract files
2. After extracting open it with any IDE
3. Then Compile Program like javac Student_Management\*.java
4. This compiles the main.java, Student.java and StudentServices.java together
5. To run the application java Student_Management.Main
6. Once Started You Will See the Menu:

      =====Student Management Application=====
      1) Add a Student
      2) View all Students
      3) Search Student By ID
      4) Delete Student
      5) Update Student Details
      6) Exit
         
How it works:
1) Run the application the prgoram shows the menu with options.
2) Choose any option based on your option it will show or ask some data if you choose addStudent it will ask student details..etc.
3) Exit the program stops running.
4)The list of students is saved ini a file Students.dat using java serialization.
5) When the program starts,it loads this list from the file. When You add,update or delete it saves the list back so nothing is lost.
   
Sample Student Output:
  Student [Id=1, name=John Doe, age=20, course=Computer Science]

 

