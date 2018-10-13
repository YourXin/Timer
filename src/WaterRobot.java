import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 每1秒加一次水
 */
public class WaterRobot extends TimerTask {

    //最大容量为5
    private Integer bucketCapacity = 0;

    private Timer timer;

    public WaterRobot(Timer timer){
        this.timer = timer;
    }

    @Override
    public void run() {
        //灌水直到桶满
        if (bucketCapacity < 5) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //加水
            System.out.println("Add 1 water into the bucket，now time is:" + sdf.format(new Date()));
            bucketCapacity++;
        }else{
            //水满了->停止执行
            System.out.println("The timer purge num is: " + timer.purge());
            cancel();
            System.out.println("The waterRobot has been aborted");
            System.out.println("The timer purge num is: " + timer.purge());
            System.out.println("Current water is: " + bucketCapacity);
            try {
                Thread.sleep(2000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //等待两秒钟,终止timer的所有内容
            timer.cancel();
//            System.out.println("The timer purge num is: " + timer.purge());
        }
    }
}
