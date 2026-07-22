package org.example;



public class dev {

//    developer should not be dependent on laptop, it should be dependent on computer
//    private laptop laptop;
    private computer comp;

//    computer ke liye getter setter bana lo


    public computer getComp() {
        return comp;
    }

    public void setComp(computer comp) {
        this.comp = comp;
    }



    public dev(){
        System.out.println("dev ka object made");
    }



    public void build(){

        System.out.println("building smth swag in dev");
        comp.compile();
    }
}
