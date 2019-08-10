package app;

/**
 * ItemResponses
 */
public class ItemResponse {

    private Long numberRound;
    private Long codeQuiz;
    private Long codeQuestion;
    private Long codePerson; // codeExpert;
    private Long codeItem;

    private Double minValue; // valor menor o inferior
    private Double aveValue; // valor promedio o medio
    private Double maxValue; // valor maximo

    private Double rangeG; // G(=Uij - Lj)
    private int statusRangeG; // Verdadero o Falso 1 o 0;
    private Double rangeC; // valorAbsoluto(Mj-mij)
    private Double distanceGtoC; // distancia entre G y C
    private int validate; // False or True

    public ItemResponse() {
    }

    public ItemResponse(Long numberRound, Long codeQuiz, Long codeQuestion, Long codePerson, Long codeItem,
            Double minValue, Double aveValue, Double maxValue) {

        this.numberRound = numberRound;
        this.codeQuiz = codeQuiz;
        this.codeQuestion = codeQuestion;
        this.codePerson = codePerson;
        this.codeItem = codeItem;
        this.minValue = minValue;
        this.aveValue = aveValue;
        this.maxValue = maxValue;
    }

    public void calculateConsensus(Double lowerValue, Double middleValue) {

        this.rangeG = this.maxValue - lowerValue;
        this.statusRangeG = (this.rangeG > 0) ? 1 : 0;
        this.rangeC = Math.abs((this.aveValue - middleValue));
        this.distanceGtoC = this.rangeG - this.rangeC;
        this.validate = (this.distanceGtoC > 0) ? 1 : 0;

    }

    public Long getNumberRound() {
        return this.numberRound;
    }

    public void setNumberRound(Long numberRound) {
        this.numberRound = numberRound;
    }

    public Long getCodeQuiz() {
        return this.codeQuiz;
    }

    public void setCodeQuiz(Long codeQuiz) {
        this.codeQuiz = codeQuiz;
    }

    public Long getCodeQuestion() {
        return this.codeQuestion;
    }

    public void setCodeQuestion(Long codeQuestion) {
        this.codeQuestion = codeQuestion;
    }

    public Long getCodePerson() {
        return this.codePerson;
    }

    public void setCodePerson(Long codePerson) {
        this.codePerson = codePerson;
    }

    public Long getCodeItem() {
        return this.codeItem;
    }

    public void setCodeItem(Long codeItem) {
        this.codeItem = codeItem;
    }

    public Double getMinValue() {
        return this.minValue;
    }

    public void setMinValue(Double minValue) {
        this.minValue = minValue;
    }

    public Double getAveValue() {
        return this.aveValue;
    }

    public void setAveValue(Double aveValue) {
        this.aveValue = aveValue;
    }

    public Double getMaxValue() {
        return this.maxValue;
    }

    public void setMaxValue(Double maxValue) {
        this.maxValue = maxValue;
    }

    public Double getRangeG() {
        return this.rangeG;
    }

    public void setRangeG(Double rangeG) {
        this.rangeG = rangeG;
    }

    public int getStatusRangeG() {
        return this.statusRangeG;
    }

    public void setStatusRangeG(int statusRangeG) {
        this.statusRangeG = statusRangeG;
    }

    public Double getRangeC() {
        return this.rangeC;
    }

    public void setRangeC(Double rangeC) {
        this.rangeC = rangeC;
    }

    public Double getDistanceGtoC() {
        return this.distanceGtoC;
    }

    public void setDistanceGtoC(Double distanceGtoC) {
        this.distanceGtoC = distanceGtoC;
    }

    public int getValidate() {
        return this.validate;
    }

    public void setValidate(int validate) {
        this.validate = validate;
    }

    @Override
    public String toString() {
        return "{" + " numberRound='" + getNumberRound() + "'" + ", codeQuiz='" + getCodeQuiz() + "'"
                + ", codeQuestion='" + getCodeQuestion() + "'" + ", codePerson='" + getCodePerson() + "'"
                + ", codeItem='" + getCodeItem() + "'" + ", minValue='" + getMinValue() + "'" + ", aveValue='"
                + getAveValue() + "'" + ", maxValue='" + getMaxValue() + "'" + ", rangeG='" + getRangeG() + "'"
                + ", statusRangeG='" + getStatusRangeG() + "'" + ", rangeC='" + getRangeC() + "'" + ", distanceGtoC='"
                + getDistanceGtoC() + "'" + ", validate='" + getValidate() + "'" + "}";
    }

}