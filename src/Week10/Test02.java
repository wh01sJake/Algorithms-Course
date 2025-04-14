package Week10;

/**
 * ClassName: Test02
 * Description:
 * <p>
 * Datetime: 2025/4/8 11:38
 * Author: @Likun.Fang
 * Version: 1.0
 */
public class Test02 {
    public static void main(String[] args) {
        MessagePrinter mp = new MessagePrinter("Hello",100);

        mp.start();

    }
}


class MessagePrinter extends Thread{

    String msg;
    int times;

    public MessagePrinter(String msg, int times){
        this.msg = msg;
        this.times = times;
    }

    @Override
    public void run(){
        for(int i = 0; i < times; i++){
            System.out.println(msg);
        }
    }

}
