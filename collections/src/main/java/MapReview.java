import java.util.HashMap;
import java.util.Map;

public class MapReview {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Cassie");
        map.put(2, "Katy");
        System.out.println(map.get(2));
        System.out.println(findFirstNonRepeating("deo ava deveoe"));
    }

    //key is char, value is count in hashmap
    // find first count = 1
    public static Character findFirstNonRepeating(String str) {
        Map<Character, Integer> map = new HashMap<>();
        // for counting the chars
        int count;
        // counting chars and putting values in the hash map
        for (Character ch : str.toCharArray()) {
            if (map.containsKey(ch)) {
                count = map.get(ch); //assign new value to count
                map.put(ch, count + 1); // put new count into map
            } else map.put(ch, 1);
        }
        // starting from string, check if the char count equals 1
        for (Character ch : str.toCharArray()) {
            if (map.get(ch) == 1) return ch;
        }
        return null;
    }
}