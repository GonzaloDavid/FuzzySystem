/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author ka
 */
public class Survey {

    private ArrayList<Item> itemList;
    private ArrayList<Item> triangularFuzzyNumbers;
    private ArrayList<CrispNumberSj> crispNumberSj; // Sj = ( min + ave + max)/3
    private double determinante;
    private int numberItems;

    protected static String MIN = "minimo";
    protected static String MED = "medio";
    protected static String MAX = "maximo";

    public Survey(ArrayList<Item> itemList, float determinante, int numberItems) {
        this.itemList = itemList;
        this.numberItems = numberItems;
        this.triangularFuzzyNumbers = new ArrayList();
        this.crispNumberSj = new ArrayList();
        this.determinante = determinante;
    }

    public void setValoresMenorMedioItems() {
        for (Item item : this.itemList) {
            int idItem = item.getIdItem();
            for (Item itemfuzzy : this.triangularFuzzyNumbers) {

                if (itemfuzzy.getIdItem() == idItem) {
                    item.setLowerValue(itemfuzzy.getMin());
                    item.setMiddleValue(itemfuzzy.getMed());
                }
            }
        }

    }

    public ArrayList<Item> getItemsAnulados() {

        ArrayList<Item> itemsAnulados = new ArrayList();

        for (Item item : this.itemList) {
            if (item.getEstadoRangoG() == 0 || item.getConsensoGC() == 0) {
                itemsAnulados.add(item);
            }
        }
        return itemsAnulados;
    }

    public ArrayList<Item> getTriangularFuzzyNumbers() {

        for (int idItem = 1; idItem <= numberItems; idItem++) {
            this.triangularFuzzyNumbers.add(getTriangularFuzzyNumberPorItem(idItem));
        }
        return this.triangularFuzzyNumbers;
    }

    public void setTriangularFuzzyNumbers(ArrayList<Item> triangularFuzzyNumbers) {
        this.triangularFuzzyNumbers = triangularFuzzyNumbers;
    }

    public ArrayList<CrispNumberSj> getCrispNumberSj() {
        Double promedio = 0.0;

        for (Item item : this.triangularFuzzyNumbers) {
            promedio = ((item.getMin() + item.getMed() + item.getMax()) / 3.0);
            this.crispNumberSj.add(new CrispNumberSj(item.getIdItem(), promedio, this.determinante));
        }

        return this.crispNumberSj;
    }

    private Item getTriangularFuzzyNumberPorItem(int idItem) {
        ArrayList<Double> menores = getValuesPorItem(idItem, MIN);
        ArrayList<Double> medios = getValuesPorItem(idItem, MED);
        ArrayList<Double> mayores = getValuesPorItem(idItem, MAX);

        double getNumeroMenor = getNumeroMenor(menores);
        double getNumeroMedio = getNumeroMedio(medios);
        double getNumeroMaximo = getNumeroMaximo(mayores);

        System.out.println("getNumeroMenor: " + getNumeroMenor);
        System.out.println("getNumeroMedio: " + getNumeroMedio);
        System.out.println("getNumeroMaximo: " + getNumeroMaximo);
        Item itemTFN = new Item(0, idItem, getNumeroMenor, getNumeroMedio, getNumeroMaximo);

        return itemTFN;
    }

    private ArrayList<Double> getValuesPorItem(int idItem, String tipoValue) {
        ArrayList<Double> valuesPorItem = new ArrayList();

        if (tipoValue.equals(MIN)) {
            for (Item item : this.itemList) {
                if (item.getIdItem() == idItem) {
                    valuesPorItem.add(item.getMin());
                }
            }
        } else if (tipoValue.equals(MED)) {
            for (Item item : this.itemList) {
                if (item.getIdItem() == idItem) {
                    valuesPorItem.add(item.getMed());
                }
            }
        } else if (tipoValue.equals(MAX)) {
            for (Item item : this.itemList) {
                if (item.getIdItem() == idItem) {
                    valuesPorItem.add(item.getMax());
                }
            }
        }

        System.out.println(tipoValue + ": " + valuesPorItem);

        return valuesPorItem;
    }

    private double getNumeroMenor(ArrayList<Double> numeros) {
        double menor = Collections.min(numeros);
        return menor;
    }

    private double getNumeroMedio(ArrayList<Double> numeros) {
        int total = numeros.size();
        double producto = 1.0;

        for (double med : numeros) {
            producto = producto * med;
        }

        return Math.pow(producto, (1.0 / total));
    }

    private double getNumeroMaximo(ArrayList<Double> numeros) {
        double mayor = Collections.max(numeros);
        return mayor;
    }

    public ArrayList<Item> getItemList() {
        return this.itemList;
    }

    public void setItemList(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    public void setCrispNumberSj(ArrayList<CrispNumberSj> promedioSj) {
        this.crispNumberSj = promedioSj;
    }

    public double getDeterminante() {
        return this.determinante;
    }

    public void setDeterminante(double determinante) {
        this.determinante = determinante;
    }

    public int getNumberItems() {
        return this.numberItems;
    }

    public void setNumberItems(int numberItems) {
        this.numberItems = numberItems;
    }

    @Override
    public String toString() {
        return "{" + " itemList='" + getItemList() + "'" + ", triangularFuzzyNumbers='" + getTriangularFuzzyNumbers()
                + "'" + ", crispNumber='" + getCrispNumberSj() + "'" + ", determinante='" + getDeterminante() + "'"
                + ", numberItems='" + getNumberItems() + "'" + "}";
    }
}
