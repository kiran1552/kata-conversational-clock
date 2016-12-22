package serenitylabs.tutorials.transformers;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kimahale on 12/22/2016.
 */
public class PastTransformer implements serenitylabs.tutorials.interfaces.ConversationalTimeFormater {
    @Override
    public String transform(Integer hour, Integer minutes) {
        return "it's "+ HOUR_O_CLOCKS_AND_MINUTE.get(minutes)+" past "+ HOUR_O_CLOCKS_AND_MINUTE.get((hour%12));
    }

    private static Map<Integer,String> HOUR_O_CLOCKS_AND_MINUTE =new HashMap<>();
    static{
        HOUR_O_CLOCKS_AND_MINUTE.put(0,"midnight");
        HOUR_O_CLOCKS_AND_MINUTE.put(1,"one");
        HOUR_O_CLOCKS_AND_MINUTE.put(2,"two");
        HOUR_O_CLOCKS_AND_MINUTE.put(3,"three");
        HOUR_O_CLOCKS_AND_MINUTE.put(4,"four");
        HOUR_O_CLOCKS_AND_MINUTE.put(5,"five");
        HOUR_O_CLOCKS_AND_MINUTE.put(6,"six");
        HOUR_O_CLOCKS_AND_MINUTE.put(7,"seven");
        HOUR_O_CLOCKS_AND_MINUTE.put(8,"eight");
        HOUR_O_CLOCKS_AND_MINUTE.put(9,"nine");
        HOUR_O_CLOCKS_AND_MINUTE.put(10,"ten");
        HOUR_O_CLOCKS_AND_MINUTE.put(11,"eleven");
        HOUR_O_CLOCKS_AND_MINUTE.put(12,"noon");
    }
}
