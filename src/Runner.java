import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Krukouski Andrei on 14.03.2016.
 */
public class Runner {

    public static void main(String[] arg){
        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(format.format(d));
        String data = format.format(d);
        System.out.println(data);
    }

}
