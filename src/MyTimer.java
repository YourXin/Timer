import java.util.Timer;

public class MyTimer {


    public static void main(String[] args) {
        //1.创建一个Timer实例
        Timer timer = new Timer();

        //2.创建MyTimer实例
        MyTimerTask myTimerTask = new MyTimerTask("No.1");

        //3. 通过timer定时频率调用myTimerTask
        timer.schedule(myTimerTask,2000L,1000L);
    }

}
