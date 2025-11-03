package com.Day5;

interface Payable{
    void generatePayslip();

}
class Contractor implements Payable{
    public void generatePayslip(){
        System.out.println("Contractor pay is on day basis");
    }
}

class FullTimeEmployee implements Payable{
    @Override
    public void generatePayslip() {
        System.out.println("Full Time Employee salary will be on month basis");
    }
}

public class Interface {
    public static void main(String[] args) {
     Payable p=new Contractor();
     Payable p1=new FullTimeEmployee();
     p.generatePayslip();
    }
}
