package app;

/**
 * Item
 */
public class Item {

    public int min;
    public int med;
    public int max;

    public Item() {
    }

    public Item(int min, int med, int max) {
        this.min = min;
        this.med = med;
        this.max = max;
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