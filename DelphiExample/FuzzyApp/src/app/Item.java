package app;

/**
 * Item: Lista de criterios
 */
public class Item {

    private int idExperto; // id del criterio
    private int idItem; // id del criterio
    private double min; // mij
    private double med; // lij
    private double max; // uij
    // Validacion de Items o Criterios´
    private double valorMenor; // Lj
    private double valorMedio; // Mj
    private double rangoG; // G(=Uij - Lj)
    private int estadoRangoG; // Verdadero o Falso 1 o 0;
    private double rangoC; // valorAbsoluto(Mj-mij)
    private int consensoGC; // Verdadero o Falso 1 o 0;

    // Constructores ===========================================================
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

    public double getValorMenor() {
        return this.valorMenor;
    }

    public void setValorMenor(double valorMenor) {
        this.valorMenor = valorMenor;
    }

    public double getValorMedio() {
        return this.valorMedio;
    }

    public void setValorMedio(double valorMedio) {
        this.valorMedio = valorMedio;
    }

    public double getRangoG() {
        this.rangoG = this.getMax() - this.getMin();
        return this.rangoG;
    }

    public void setRangoG(double valorRangoG) {
        this.rangoG = valorRangoG;
    }

    public int getEstadoRangoG() {
        if (this.getRangoG() > 0) {
            this.estadoRangoG = 1;
        } else {
            this.estadoRangoG = 0;
        }
        return this.estadoRangoG;
    }

    public void setEstadoRangoG(int estadoRangoG) {
        this.estadoRangoG = estadoRangoG;
    }

    public double getRangoC() {
        this.rangoC = Math.abs((this.getMed() - this.getValorMedio()));
        return this.rangoC;
    }

    public void setRangoC(double rangoC) {
        this.rangoC = rangoC;
    }

    public int getConsensoGC() {

        if (this.getRangoG() > this.getRangoC()) {
            this.consensoGC = 1;
        } else {

            this.consensoGC = 0;
        }

        return this.consensoGC;
    }

    public void setConsensoGC(int consensoGC) {
        this.consensoGC = consensoGC;
    }

    @Override
    public String toString() {
        return "{" + " idExperto='" + getIdExperto() + "'" + ", idItem='" + getIdItem() + "'" + ", min='" + getMin()
                + "'" + ", med='" + getMed() + "'" + ", max='" + getMax() + "'" + ", valorMenor='" + getValorMenor()
                + "'" + ", valorMedio='" + getValorMedio() + "'" + ", rangoG='" + getRangoG() + "'" + ", estadoRangoG='"
                + getEstadoRangoG() + "'" + ", rangoC='" + getRangoC() + "'" + ", consensoGC='" + getConsensoGC() + "'"
                + "}";
    }

}