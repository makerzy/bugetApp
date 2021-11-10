package com.example.budgetmanager;

public class BankClass {

    private  String name;
    private int Id;
    private int bankLogo;

    public BankClass(String name, int id, int logo) {
        this.name = name;
        this.bankLogo = logo;
        this.Id = id;
    }


    public  String getName(){
        return this.name;
    }

    public int getLogo(){
        return this.bankLogo;
    }

    public int getId(){
       return  this.Id;
    }

}
