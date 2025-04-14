package Week4;

abstract class Coffee  {
    private int espressoShoutCount;
    private int  waterML;
    private String cupSize; // small,medium,large


    public Coffee() {
        this.espressoShoutCount = 1;
        this.waterML = 400;
        this.cupSize = "small";
    }

    public Coffee(int espressoShoutCount, int waterML, String cupSize) {
        this.espressoShoutCount = espressoShoutCount;
        this.waterML = waterML;
        this.cupSize = cupSize;
    }

    public int getEspressoShoutCount() {
        return espressoShoutCount;
    }

    public void setEspressoShoutCount(int espressoShoutCount) {
        this.espressoShoutCount = espressoShoutCount;
    }

    public int getWaterML() {
        return waterML;
    }

    public void setWaterML(int waterML) {
        this.waterML = waterML;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    abstract void order();

    @Override
    public String toString() {
        return "Coffee{" +
                "espressoShoutCount=" + espressoShoutCount +
                ", waterML=" + waterML +
                ", cupSize='" + cupSize + '\'' +
                '}';
    }
}
