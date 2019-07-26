package app;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        // Experto 1 ================================================
        ArrayList<Item> pregunta1 = new ArrayList<>();
        pregunta1.add(new Item(1, 1, 6, 7, 8));
        pregunta1.add(new Item(1, 2, 5, 8, 9));
        pregunta1.add(new Item(1, 3, 2, 7, 8));
        pregunta1.add(new Item(1, 4, 3, 6, 8));
        pregunta1.add(new Item(1, 5, 5, 7, 8));
        pregunta1.add(new Item(1, 6, 4, 7, 9));
        // Experto 2 ====================================
        pregunta1.add(new Item(2, 1, 4, 6, 8));
        pregunta1.add(new Item(2, 2, 5, 8, 9));
        pregunta1.add(new Item(2, 3, 2, 7, 8));
        pregunta1.add(new Item(2, 4, 3, 6, 8));
        pregunta1.add(new Item(2, 5, 4, 6, 8));
        pregunta1.add(new Item(2, 6, 4, 7, 9));
        // Experto 3 ====================================
        pregunta1.add(new Item(3, 1, 4, 6, 8));
        pregunta1.add(new Item(3, 2, 4, 6, 9));
        pregunta1.add(new Item(3, 3, 2, 7, 9));
        pregunta1.add(new Item(3, 4, 4, 6, 7));
        pregunta1.add(new Item(3, 5, 5, 7, 8));
        pregunta1.add(new Item(3, 6, 4, 7, 9));

        Question preguntaExperto1 = new Question(pregunta1, 7, 6);

        System.out.println(preguntaExperto1);
        System.out.println("=========================================");

    }

}