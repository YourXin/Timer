import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyTimerTask(String inputName){
        this.name = inputName;
    }

    @Override
    public void run() {
        Calendar calendar = Calendar.getInstance();
        //以yyyy-MM-dd HH:mm:ss的格式打印时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current exec time is " + simpleDateFormat.format(calendar.getTime()));

        System.out.println("Current exec name is:" + name);
    }
}
