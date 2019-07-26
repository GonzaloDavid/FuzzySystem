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
        pregunta1.add(new Item(1, 1, 6, 7, 8));
        pregunta1.add(new Item(1, 2, 5, 8, 9));
        pregunta1.add(new Item(1, 3, 2, 7, 8));
        pregunta1.add(new Item(1, 4, 3, 6, 8));
        pregunta1.add(new Item(1, 5, 5, 7, 8));
        pregunta1.add(new Item(1, 6, 4, 7, 9));

        Question preguntaExperto1 = new Question(pregunta1);

        // experto 2 ================================================
        ArrayList<Item> pregunta2 = new ArrayList<>();
        pregunta2.add(new Item(1, 6, 7, 8));
        pregunta2.add(new Item(2, 6, 7, 8));
        pregunta2.add(new Item(3, 6, 7, 8));
        pregunta2.add(new Item(4, 6, 7, 8));
        pregunta2.add(new Item(5, 6, 7, 8));
        pregunta2.add(new Item(6, 6, 7, 8));

        Question preguntaExperto2 = new Question(2, pregunta2);

        // experto 3 ================================================
        ArrayList<Item> pregunta3 = new ArrayList<>();
        pregunta3.add(new Item(1, 6, 7, 8));
        pregunta3.add(new Item(2, 6, 7, 8));
        pregunta3.add(new Item(3, 6, 7, 8));
        pregunta3.add(new Item(4, 6, 7, 8));
        pregunta3.add(new Item(5, 6, 7, 8));
        pregunta3.add(new Item(6, 6, 7, 8));

        Question preguntaExperto3 = new Question(3, pregunta3);

        // Tabla preguntas ==============================================
        // ===============================================================

        ArrayList<Question> tablapreguntas = new ArrayList<>();
        tablapreguntas.add(preguntaExperto1);
        tablapreguntas.add(preguntaExperto2);
        tablapreguntas.add(preguntaExperto3);

        // TableSurveys surveys = new TableSurveys();
        // surveys.setSurveys(tablapreguntas);
        // surveys.generarNumerosTriangularesFuzzys();

        System.out.println(tablapreguntas.toString());

    }

}