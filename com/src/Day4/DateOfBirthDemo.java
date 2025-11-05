package com.Day4;

class Person {
    String name;
    String dateOfBirth;

    void Details(String n, String dob) {
        name = n;
        dateOfBirth = dob;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Date of Birth: " + dateOfBirth);
    }
}

class Teacher extends Person {
    double salary;
    String subject;

    void Details(String n, String dob, double s, String sub) {
        name = n;
        dateOfBirth = dob;
        salary = s;
        subject = sub;
    }

    void display() {
        System.out.println("----- Teacher Details -----");
        System.out.println("Name: " + name);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Salary: " + salary);
        System.out.println("Subject: " + subject);
    }
}

class Student extends Person {
    String studentId;

    void Details(String n, String dob, String id) {
        name = n;
        dateOfBirth = dob;
        studentId = id;
    }

    void display() {
        System.out.println("----- Student Details -----");
        System.out.println("Name: " + name);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Student ID: " + studentId);
    }
}

class CollegeStudent extends Student {
    String collegeName;
    String year;

    void Details(String n, String dob, String id, String cname, String y) {
        name = n;
        dateOfBirth = dob;
        studentId = id;
        collegeName = cname;
        year = y;
    }

    void display() {
        System.out.println("----- College Student Details -----");
        System.out.println("Name: " + name);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Student ID: " + studentId);
        System.out.println("College Name: " + collegeName);
        System.out.println("Year: " + year);
    }
}

public class DateOfBirthDemo {
    public static void main(String[] args) {


        Person p;


        p = new Person();
        p.Details("Ravi ", "10-05-2000");
        p.display();


        p = new Teacher();
        ((Teacher)p).Details("Meena ", "12-09-1975", 5000, "Mathematics");
        p.display();


        p = new Student();
        ((Student)p).Details("Arjun ", "15-08-2005", "STU101");
        p.display();


        p = new CollegeStudent();
        ((CollegeStudent)p).Details("Kumar", "25-11-2003", "C102", "ABC Engineering College", "Third Year");
        p.display();
    }
}

