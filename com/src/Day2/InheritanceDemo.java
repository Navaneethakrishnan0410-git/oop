package com.Day3;

class GrandFather{
    public void Flight(){
        System.out.println("10 flight Landed....");
    }
}
class Father extends GrandFather{
    public void Chraft(){
        System.out.println("Helipad in House....");
    }
}
class Son extends Father{
    public void Jet(){
        System.out.println("7 Seater Jet...");
    }
}
class Daughter extends Father{
    public void Chraft2(){
        System.out.println("...");
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        Father father=new Father();
        father.Chraft();
        System.out.println("---------------------------");
        Son son=new Son();
        son.Jet();
        son.Chraft();
    }
}
