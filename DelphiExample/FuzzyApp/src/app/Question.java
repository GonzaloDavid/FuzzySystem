package app;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Survey
 */
public class Question {

    private ArrayList<Item> itemList;
    private ArrayList<Double> promedioSj; // Sj = ( min + ave + max)/3
    private float determinante;

    protected static String MIN = "minimo";
    protected static String MED = "medio";
    protected static String MAX = "maximo";

    public Question(float determinante, ArrayList<Item> itemList) {
        this.itemList = itemList;
        this.promedioSj = new ArrayList<Double>();
        this.determinante = determinante;
    }

    // Algoritmos !!! =========================

    public Item getTriangularFuzzyNumberPorItem(int idItem) {

        idItem = 1;
        ArrayList<Integer> menores = getValuesPorItem(idItem, MIN);
        ArrayList<Integer> medios = getValuesPorItem(idItem, MED);
        ArrayList<Integer> mayores = getValuesPorItem(idItem, MAX);
        menores.add(1);
        menores.add(10);
        menores.add(100);

        mayores.add(2);
        mayores.add(60);
        mayores.add(400);
        Item itemTFN = new Item(0, idItem, 0, 0, 0);

        System.out.println("getNumeroMenor: " + getNumeroMenor(menores));
        System.out.println("getNumeroMedio: " + getNumeroMedio(medios));
        System.out.println("getNumeroMaximo: " + getNumeroMaximo(mayores));
        return itemTFN;
    }

    private ArrayList<Integer> getValuesPorItem(int idItem, String tipoValue) {
        ArrayList<Integer> valuesPorItem = new ArrayList<Integer>();

        if (tipoValue == MIN)
            for (Item item : this.itemList) {
                if (item.getIdItem() == idItem)
                    valuesPorItem.add(item.getMin());
            }
        else if (tipoValue == MED)
            for (Item item : this.itemList) {
                if (item.getIdItem() == idItem)
                    valuesPorItem.add(item.getMed());
            }
        else if (tipoValue == MAX)
            for (Item item : this.itemList) {
                if (item.getIdItem() == idItem)
                    valuesPorItem.add(item.getMax());
            }

        System.out.println(tipoValue + ": " + valuesPorItem);

        return valuesPorItem;
    }

    private int getNumeroMenor(ArrayList<Integer> numeros) {
        int menor = 0;
        menor = Collections.min(numeros);
        return menor;
    }

    private double getNumeroMedio(ArrayList<Integer> numeros) {
        int total = numeros.size();
        double producto = 1.0;

        for (int med : numeros) {
            producto = producto * med;
        }

        return Math.pow(producto, (1.0 / total));
    }

    private int getNumeroMaximo(ArrayList<Integer> numeros) {
        int mayor = 0;
        mayor = Collections.max(numeros);
        return mayor;
    }

    public float getDeterminante() {
        return this.determinante;
    }

    public void setDeterminante(float determinante) {
        this.determinante = determinante;
    }

    public ArrayList<Double> getPromedioSj() {
        return this.promedioSj;
    }

    public void setPromedioSj(ArrayList<Double> promedioSj) {
        this.promedioSj = promedioSj;
    }

    public Question() {
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
        return "{" + " itemList='" + getItemList() + "'" + "}" + " " + getTriangularFuzzyNumberPorItem(1);
    }

}