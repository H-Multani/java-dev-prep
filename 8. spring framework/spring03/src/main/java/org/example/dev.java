package org.example;



public class dev {

//    now we want ki spring mereko yaha laptop ka object de
    private laptop laptop;

//    iske getter setter bana lena since spring vahi setter use karega assign karne ke liye


    public laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(laptop laptop) {
        this.laptop = laptop;
    }

    private int age;


    public dev(){
        System.out.println("dev ka object made");
    }

//    constructor injection ke liye constructor bana do, for simple variable
//    public dev(int age,int salary) {
//        this.age = age;
//    }

//    constructor injection ke liye, for object of classes
    public dev(laptop l){
        this.laptop=l;
    }

    public int getAge() {
        return age;
    }

//    setter injection ke liye constructor bana do
    public void setAge(int age) {
        this.age = age;
    }

    public void build(){

        System.out.println("building smth swag");
        laptop.compile();
    }
}
