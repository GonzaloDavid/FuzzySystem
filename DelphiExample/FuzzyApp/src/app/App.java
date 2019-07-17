package app;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Item item1 = new Item(6, 7, 8);
        Item item2 = new Item(5, 8, 9);
        Item item3 = new Item(2, 7, 8);
        Item item4 = new Item(3, 6, 8);
        Item item5 = new Item(5, 7, 8);
        Item item6 = new Item(4, 7, 9);

        ArrayList<Item> listaItems = new ArrayList<>();
        listaItems.add(item1);
        listaItems.add(item2);
        listaItems.add(item3);
        listaItems.add(item4);
        listaItems.add(item5);
        listaItems.add(item6);

        System.out.println(listaItems.get(5));

    }
}