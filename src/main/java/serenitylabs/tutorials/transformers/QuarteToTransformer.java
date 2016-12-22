package serenitylabs.tutorials.transformers;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kimahale on 12/22/2016.
 */
public class QuarteToTransformer implements serenitylabs.tutorials.interfaces.ConversationalTimeFormater {
    @Override
    public String transform(Integer hour, Integer minutes) {
        return "it's quarter to "+ HOUR.get((hour%12) + 1);

    }
    private static Map<Integer,String> HOUR=new HashMap<>();
    static{
        HOUR.put(0,"midnight");
        HOUR.put(1,"one");
        HOUR.put(2,"two");
        HOUR.put(3,"three");
        HOUR.put(4,"four");
        HOUR.put(5,"five");
        HOUR.put(6,"six");
        HOUR.put(7,"seven");
        HOUR.put(8,"eight");
        HOUR.put(9,"nine");
        HOUR.put(10,"ten");
        HOUR.put(11,"eleven");
        HOUR.put(12,"twelve");
    }
}
