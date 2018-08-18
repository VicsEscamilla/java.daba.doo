import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class MatchTest {
    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(1,5,6,3,4,8,2,7,11);
        List<Integer> b = Arrays.asList(11,23,43,44,1,3,5,99,8,10);

        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();

        for (Integer item : a) {
            Integer count = m.get(item);
            m.put(item, (count==null) ? 1 : count+1);
        }

        for (Integer item : b) {
            Integer count = m.get(item);
            m.put(item, (count==null) ? 1 : count+1);
        }

        for (Map.Entry<Integer, Integer> item : m.entrySet()) {
            if (item.getValue() > 1)
                System.out.println(item.getKey());
        }
    }
}
