package com.Day2;

class Student{
    String name;
    int rno;
    String dept;
    static String college;
    public void display(){
        System.out.println("Name: "+name+"\nRno: "+rno+"\nDept: "+dept+"\nCollege Name: "+college);
    }
}
public class StudentDemo {
    public static void main(String[] args) {
        Student s1=new Student();
        s1.name="Madhan";
        s1.rno=201;
        s1.dept="CSE";
        Student.college="MSAJ";
        s1.display();
        System.out.println("----------------------");
        Student s2=new Student();
        s2.name="Akhil";
        s2.rno=102;
        s2.dept="CSE";
        s2.display();

    }
}
