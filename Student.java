package Student_Management;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private int Id;
    private String name;
    private int age;
    private String course;

    Student(int Id,String name,int age,String course){
        this.Id=Id;
        this.age=age;
        this.name=name;
        this.course=course;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student [Id=" + Id + ", name=" + name + ", age=" + age + ", course=" + course + "]";
    }

    
}
