import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;

/**
 * Dancing要在water停止两秒后停止
 *
 * Dancing每两秒跳一次舞
 * water 每一秒加一次水
 */
public class MyExecutor {

    public static void main(String[] args) {
        Timer timer = new Timer();

        //获取当前时间
        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println("Main---Current time is: " + sdf.format(calendar.getTime()));

        DancingRobot dancingRobot = new DancingRobot();
        WaterRobot waterRobot = new WaterRobot(timer);


        timer.schedule(dancingRobot,calendar.getTime(),2000);
        timer.scheduleAtFixedRate(waterRobot,calendar.getTime(),1000);

    }
}
