package org.example.listviewuloha;

public class ShoppingItems {
    private String name;
    private int num;

    public ShoppingItems(String name, int number){
        if(!name.isEmpty() && number >= 0){
            this.name = name;
            this.num = number;
        }
    }

    @Override
    public String toString(){
        return this.name + ", " + this.num;
    }

    public void setName(String name){ if(!name.isEmpty()){this.name = name;}}
    public void setNumber(int num){ if(num >= 0){this.num = num;}}
}
