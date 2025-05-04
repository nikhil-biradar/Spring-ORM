package org.example;



import javax.persistence.*;

@Entity
@Table(name = "student_details")
public class Student {

    @Id
    @Column(name = "student_id")
    private int id;
    @Column(name = "student_name")
    private String name;
    @Column(name = "student_city")
    private String city;

    public Student() {
    }

    public Student(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}