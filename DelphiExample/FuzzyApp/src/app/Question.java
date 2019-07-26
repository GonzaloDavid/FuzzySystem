package app;

import java.util.ArrayList;

/**
 * Survey
 */
public class Question {

    private ArrayList<Item> itemList;

    public Question() {
    }

    public Question(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    public ArrayList<Item> getItemList() {
        return this.itemList;
    }

    public void setItemList(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    public Question itemList(ArrayList<Item> itemList) {
        this.itemList = itemList;
        return this;
    }

    @Override
    public String toString() {
        return "{" + " itemList='" + getItemList() + "'" + "}";
    }

}