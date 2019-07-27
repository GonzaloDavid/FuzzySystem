package app;

/**
 * Validacion
 */
public class Consenso {

    private Question pregunta;

    // Constructores ===================
    public Consenso() {
    }

    public Consenso(Question pregunta) {
        this.pregunta = pregunta;
    }

    // ================= Algoritmos ==================

    public Question getPregunta() {
        return this.pregunta;
    }

    public void setPregunta(Question pregunta) {
        this.pregunta = pregunta;
    }

    @Override
    public String toString() {
        return "{" + " pregunta='" + getPregunta() + "'" + "}";
    }

}