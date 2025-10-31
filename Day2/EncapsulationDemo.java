package com.Day3;

class Student{
    private int rno;
    private String name;
    private int marks;
    public Student(int rno,String name,int marks){
        this.rno=rno;
        this.name=name;
        this.marks=marks;
    }
    public int getRno(){
        return rno;
    }
    public String getName(){
        return name;
    }
    public int getMarks(){
        return marks;
    }
    public void setRno(int rno){
        this.rno=rno;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setMarks(int marks){
        this.marks=marks;
    }

}
public class EncapsulationDemo {
    public static void main(String[] args) {
        int[] nums=new int[10];
        Student[] students=new Student[3];
        students[0]=new Student(112,"Kalai",85);
        students[1]=new Student(113,"Thiru",93);
        students[2]=new Student(114,"krishna",56);

        int total=0;
        for(Student temp:students){
            System.out.println("Name: "+temp.getName()+"\nRno: "+temp.getRno()+"\nMarks: "+temp.getMarks());
            total+=temp.getMarks();
        }
        double average=(double)total/ students.length;
        System.out.println("Average Mark: "+average);
    }
}
