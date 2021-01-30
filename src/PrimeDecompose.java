import java.util.*;

public class PrimeDecompose {
    public static String factors(int n){
        return toString(toMultipliers(n));
    }

    public static Map<Integer, Integer> toMultipliers(int n){
        Map<Integer, Integer> map = new TreeMap<>();
        int max = (int) Math.sqrt(n);
        for(int i = 2; i <= max; i++){
            while(n % i == 0){
                if(!map.containsKey(i))
                    map.put(i, 1);
                else
                    map.put(i, map.get(i) + 1);
                n /= i;
            }
        }
        if(n > 1)
            map.put(n, 1);
        return map;
    }

    private static String toString(Map<Integer, Integer> map) throws NullPointerException {
        if(map == null)
            throw new NullPointerException();
        StringBuilder result = new StringBuilder();
        map.forEach((key, value) -> result.append("(").append(key).append((value > 1) ? "**" + value : "").append(")"));
        return result.toString();
    }
}