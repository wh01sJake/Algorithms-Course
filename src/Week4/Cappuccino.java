package Week4;

public class Cappuccino extends Coffee{
    private int milkML;
    private int foamHeight;



    public Cappuccino(int espressoShoutCount, int waterML, String cupSize, int milkML, int foamHeight) {
        super(espressoShoutCount, waterML, cupSize);
        this.milkML = milkML;
        this.foamHeight = foamHeight;
    }

    public Cappuccino(){
        super();
        milkML = 100;
        foamHeight = 2;
    }

    @Override
    void order() {
        System.out.println("Making order!");
    }

    @Override
    public String toString() {
        return super.toString() +
                " milkML=" + milkML +
                ", foamHeight=" + foamHeight
                ;
    }
}
