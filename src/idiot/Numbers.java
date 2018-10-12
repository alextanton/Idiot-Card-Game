package idiot;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Numbers {
    static final Map<Integer, String> m;
    static {
        Map<Integer, String> aMap = new HashMap<>();
        aMap.put(0, "TWO");
        aMap.put(1, "THREE");
        aMap.put(2, "FOUR");
        aMap.put(3, "FIVE");
        aMap.put(4, "SIX");
        aMap.put(5, "SEVEN");
        aMap.put(6, "EIGHT");
        aMap.put(7, "NINE");
        aMap.put(8, "TEN");
        aMap.put(9, "JACK");
        aMap.put(10, "QUEEN");
        aMap.put(11, "KING");
        aMap.put(12, "ACE");
        m = Collections.unmodifiableMap(aMap);
    }
}
