package app;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        // experto 1 ================================================
        ArrayList<Item> encuesta1 = new ArrayList<>();
        encuesta1.add(new Item(1, 6, 7, 8));
        encuesta1.add(new Item(2, 5, 8, 9));
        encuesta1.add(new Item(3, 2, 7, 8));
        encuesta1.add(new Item(4, 3, 6, 8));
        encuesta1.add(new Item(5, 5, 7, 8));
        encuesta1.add(new Item(6, 4, 7, 9));

        Survey encuestaExperto1 = new Survey(1, encuesta1);

        // experto 2 ================================================
        ArrayList<Item> encuesta2 = new ArrayList<>();
        encuesta2.add(new Item(1, 6, 7, 8));
        encuesta2.add(new Item(2, 6, 7, 8));
        encuesta2.add(new Item(3, 6, 7, 8));
        encuesta2.add(new Item(4, 6, 7, 8));
        encuesta2.add(new Item(5, 6, 7, 8));
        encuesta2.add(new Item(6, 6, 7, 8));

        Survey encuestaExperto2 = new Survey(2, encuesta2);

        // experto 3 ================================================
        ArrayList<Item> encuesta3 = new ArrayList<>();
        encuesta3.add(new Item(1, 6, 7, 8));
        encuesta3.add(new Item(2, 6, 7, 8));
        encuesta3.add(new Item(3, 6, 7, 8));
        encuesta3.add(new Item(4, 6, 7, 8));
        encuesta3.add(new Item(5, 6, 7, 8));
        encuesta3.add(new Item(6, 6, 7, 8));

        Survey encuestaExperto3 = new Survey(3, encuesta3);

        // Tabla Encuestas ==============================================
        // ===============================================================

        ArrayList<Survey> tablaEncuestas = new ArrayList<>();
        tablaEncuestas.add(encuestaExperto1);
        tablaEncuestas.add(encuestaExperto2);
        tablaEncuestas.add(encuestaExperto3);

        TableSurveys surveys = new TableSurveys();
        surveys.setSurveys(tablaEncuestas);
        surveys.generarNumerosTriangularesFuzzys();

        // System.out.println(tablaEncuestas.toString());

    }
}