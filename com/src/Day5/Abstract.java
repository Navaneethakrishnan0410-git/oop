package com.Day5;

abstract class Shape{
    String color;
    abstract void draw();
    public void addColor(String color){
        this.color=color;
    }
}

class Rectangle extends Shape{
    void draw(){
        System.out.println("Drawing Rectangle...");
    }
}

class Circle extends Shape{
    @Override
    void draw() {
        System.out.println("Drawing Circle...");
    }
}
public class Abstract {
    public static void main(String[] args) {
        Shape s=new Rectangle();
        Shape s1=new Circle();
        s1.draw();
    }
}

