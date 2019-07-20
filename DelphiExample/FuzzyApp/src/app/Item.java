package app;

/**
 * Item: Lista de criterios
 */
public class Item {

    private int id; // id del criterio
    private int min;
    private int med;
    private int max;

    public Item() {
    }

    public Item(int id, int min, int med, int max) {
        this.id = id;
        this.min = min;
        this.med = med;
        this.max = max;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMin() {
        return this.min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMed() {
        return this.med;
    }

    public void setMed(int med) {
        this.med = med;
    }

    public int getMax() {
        return this.max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public Item min(int min) {
        this.min = min;
        return this;
    }

    public Item med(int med) {
        this.med = med;
        return this;
    }

    public Item max(int max) {
        this.max = max;
        return this;
    }

    @Override
    public String toString() {
        return "{" + " min='" + getMin() + "'" + ", med='" + getMed() + "'" + ", max='" + getMax() + "'" + "}";
    }

}