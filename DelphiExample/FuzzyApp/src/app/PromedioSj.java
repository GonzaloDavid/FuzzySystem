package app;

/**
 * PromediosSj
 */
public class PromedioSj {

    private int idItem;
    private double indiceSj;
    private double determinante;
    private int estado;
    private String mensaje;

    protected static String ACEPTADO = "ACEPTADO";
    protected static String DESCARTADO = "DESCARTADO";

    // Constructores =====================
    public PromedioSj() {

    }

    public PromedioSj(int idItem, double indiceSj, double determinante) {
        this.idItem = idItem;
        this.indiceSj = indiceSj;
        this.determinante = determinante;
    }

    public PromedioSj(int idItem, double indiceSj, double determinante, int estado, String mensaje) {
        this.idItem = idItem;
        this.indiceSj = indiceSj;
        this.determinante = determinante;
        this.estado = estado;
        this.mensaje = mensaje;
    }
    // Getters and Setters ======================

    public int getIdItem() {
        return this.idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public double getIndiceSj() {
        return this.indiceSj;
    }

    public void setIndiceSj(double indiceSj) {
        this.indiceSj = indiceSj;
    }

    public double getDeterminante() {
        return this.determinante;
    }

    public void setDeterminante(double determinante) {
        this.determinante = determinante;
    }

    public int getEstado() {
        if (getIndiceSj() >= getDeterminante()) {
            this.estado = 1;
        } else {
            this.estado = 0;
        }
        return this.estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getMensaje() {
        if (this.estado == 1) {
            this.mensaje = ACEPTADO;
        } else {
            this.mensaje = DESCARTADO;
        }
        return this.mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "{" + " idItem='" + getIdItem() + "'" + ", indiceSj='" + getIndiceSj() + "'" + ", determinante='"
                + getDeterminante() + "'" + ", estado='" + getEstado() + "'" + ", mensaje='" + getMensaje() + "'" + "}";
    }

}