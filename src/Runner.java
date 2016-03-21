import by.krukouski.testscreator.resource.MessageManager;
import by.krukouski.testscreator.subject.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Krukouski Andrei on 14.03.2016.
 */
public class Runner {

    public static void main(String[] arg){
        List<String> list = new ArrayList<>();
        list.add("AAA");
        list.add("BBB");
        list.add("CCC");
        System.out.println(list);
        System.out.println(list.size());
        list.remove("AAA");
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.indexOf("BBB"));
    }

}
