package CA1;


public class Quiz {
    public static void main(String[] args) {

        Adder ad = new Adder();
        try{

            ad.add(10,100);
            int x = 20 / 0;
        System.out.println(ad.getSum() + x);
        }

        catch(ArithmeticException e){
            System.out.print(2);
        }catch(Exception e){
            System.out.print(1);
        }
        finally {
            System.out.print(3);
        }
    }
}
