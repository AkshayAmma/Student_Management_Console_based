package Student_Management;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class StudentServices {
    private List<Student> list = new ArrayList<>();
    private int nextId = 1;
    private static final String FILE_NAME = "students.dat";

    public StudentServices() {
        loadFromFile();
    }

    public void addStudent(String name, int age, String course) {
        list.add(new Student(nextId++, name, age, course));
        saveToFile();
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(list);
    }

    public List<Student> getSortedStudents(String key) {
        return switch (key.toLowerCase()) {
            case "name" -> list.stream().sorted(Comparator.comparing(Student::getName)).toList();
            case "age" -> list.stream().sorted(Comparator.comparing(Student::getAge)).toList();
            case "course" -> list.stream().sorted(Comparator.comparing(Student::getCourse)).toList();
            default -> getAllStudents();
        };
    }

    public Student getStudentById(int id) {
        return list.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }

    public List<Student> searchByName(String name) {
        return list.stream()
                .filter(s -> s.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Student> searchByCourse(String course) {
        return list.stream()
                .filter(s -> s.getCourse().toLowerCase().contains(course.toLowerCase()))
                .collect(Collectors.toList());
    }

    public boolean updateStudent(int id, String name, int age, String course) {
        Student s = getStudentById(id);
        if (s != null) {
            s.setName(name);
            s.setAge(age);
            s.setCourse(course);
            saveToFile();
            return true;
        }
        return false;
    }

    public boolean deleteStudent(int id) {
        Student s = getStudentById(id);
        if (s != null) {
            list.remove(s);
            saveToFile();
            return true;
        }
        return false;
    }

    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(list);
        } catch (Exception e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            list = (List<Student>) ois.readObject();
            if (!list.isEmpty()) {
                nextId = list.stream().mapToInt(Student::getId).max().orElse(0) + 1;
            }
        } catch (Exception e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}
