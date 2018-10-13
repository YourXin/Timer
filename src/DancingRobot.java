import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;

/**
 * 跳舞机器人
 * Dancing要在water停止两秒后停止
 *
 */
public class DancingRobot extends TimerTask {
    @Override
    public void run() {

        //获取最近的一次任务执行的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println("Scheduled exec time is: " + sdf.format(scheduledExecutionTime()));

        System.out.println("Dancing happily");

    }
}
