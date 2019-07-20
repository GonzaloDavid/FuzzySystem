package app;

import java.util.ArrayList;
import java.util.List;

/**
 * TableSurveys
 */
public class TableSurveys {

    private ArrayList<Survey> surveys; // Lista de encuestas
    private ArrayList<Item> ntfList; // Numeros triangulares difusos para cada item

    public TableSurveys() {
    }

    public TableSurveys(ArrayList<Survey> surveys, ArrayList<Item> ntfList) {
        this.surveys = surveys;
        this.ntfList = ntfList;
    }

    public void generarNumerosTriangularesFuzzys() {

        Survey encuestaExperto1 = new Survey();
        encuestaExperto1 = this.surveys.get(0);
        Survey encuestaExperto2 = new Survey();
        encuestaExperto2 = this.surveys.get(1);
        Survey encuestaExperto3 = new Survey();
        encuestaExperto3 = this.surveys.get(2);

        Item auxCriterio = new Item();
        ArrayList<Item> criterios = new ArrayList<>();

        // valor minimo lj
        System.out.println(encuestaExperto1);

    }

    // Utils Functions =====================
    private void calcularMinimos(int numItem) {

        List<Integer> t = new ArrayList<Integer>();

        int max = 0;
        for (int i = 0; i < t.size(); i++) {
            if (t.get(i) > max) {
                max = t.get(i);
            }
        }
    }

    private void calcularMedias(int numItem) {
    }

    private void calcularMaximos(int numItem) {

    }

    public ArrayList<Survey> getSurveys() {
        return this.surveys;
    }

    public void setSurveys(ArrayList<Survey> surveys) {
        this.surveys = surveys;
    }

    public ArrayList<Item> getNtfList() {
        return this.ntfList;
    }

    public void setNtfList(ArrayList<Item> ntfList) {
        this.ntfList = ntfList;
    }

    public TableSurveys surveys(ArrayList<Survey> surveys) {
        this.surveys = surveys;
        return this;
    }

    public TableSurveys ntfList(ArrayList<Item> ntfList) {
        this.ntfList = ntfList;
        return this;
    }

    @Override
    public String toString() {
        return "{" + " surveys='" + getSurveys() + "'" + ", ntfList='" + getNtfList() + "'" + "}";
    }

}