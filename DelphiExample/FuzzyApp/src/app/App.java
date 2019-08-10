package app;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        Long numberRound = (long) 1;
        Long codeQuiz = (long) 1;
        Long codeQuestion = (long) 1;// codeExpert;
        float threshold = (float) 70.0; // Umbral, Indice de convergencia o determinante...

        Long codeItem = (long) 1;
        List<ItemResponse> itemResponseList = new ArrayList<ItemResponse>();

        itemResponseList.add(new ItemResponse(numberRound, codeQuiz, codeQuestion, (long) 1, codeItem, (double) 10,
                (double) 20, (double) 30));
        itemResponseList.add(new ItemResponse(numberRound, codeQuiz, codeQuestion, (long) 2, codeItem, (double) 10,
                (double) 20, (double) 30));
        itemResponseList.add(new ItemResponse(numberRound, codeQuiz, codeQuestion, (long) 3, codeItem, (double) 10,
                (double) 20, (double) 30));
        itemResponseList.add(new ItemResponse(numberRound, codeQuiz, codeQuestion, (long) 4, codeItem, (double) 10,
                (double) 20, (double) 30));

        Item item = new Item(numberRound, codeQuiz, codeQuestion, codeItem, threshold, itemResponseList);
        item.runFuzzyDelphiMethod();
        item.determinateConsensusByItemResponses();

        System.out.println(item.toString());

    }

}