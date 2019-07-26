package app;

/**
 * Item: Lista de criterios
 */
public class Item {

    private int idExperto; // id del criterio
    private int idItem; // id del criterio
    private double min;
    private double med;
    private double max;

    public Item(int idExperto, int idItem, double min, double med, double max) {
        this.idExperto = idExperto;
        this.idItem = idItem;
        this.min = min;
        this.med = med;
        this.max = max;
    }

    public int getIdExperto() {
        return this.idExperto;
    }

    public void setIdExperto(int idExperto) {
        this.idExperto = idExperto;
    }

    public int getIdItem() {
        return this.idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public double getMin() {
        return this.min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMed() {
        return this.med;
    }

    public void setMed(double med) {
        this.med = med;
    }

    public double getMax() {
        return this.max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    @Override
    public String toString() {
        return "{" + " idExperto='" + getIdExperto() + "'" + ", idItem='" + getIdItem() + "'" + ", min='" + getMin()
                + "'" + ", med='" + getMed() + "'" + ", max='" + getMax() + "'";
    }

}