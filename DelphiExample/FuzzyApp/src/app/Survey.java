package app;

import java.util.ArrayList;

/**
 * Survey
 */
public class Survey {

    private int idExpert;
    private ArrayList<Item> itemList;

    public Survey(int idExpert, ArrayList<Item> itemList) {
        this.idExpert = idExpert;
        this.itemList = itemList;
    }

    public Survey() {
    }

    public int getIdExpert() {
        return this.idExpert;
    }

    public void setIdExpert(int idExpert) {
        this.idExpert = idExpert;
    }

    public ArrayList<Item> getItemList() {
        return this.itemList;
    }

    public void setItemList(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    public Survey idExpert(int idExpert) {
        this.idExpert = idExpert;
        return this;
    }

    public Survey itemList(ArrayList<Item> itemList) {
        this.itemList = itemList;
        return this;
    }

    @Override
    public String toString() {
        return "{" + " idExpert='" + getIdExpert() + "'" + ", itemList='" + getItemList() + "'" + "}";
    }

}