import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Mode {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(33,1,2,3,1,4,5,6,7,8,9,1,4);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(Integer item : list) {
            Integer count = map.get(item);
            map.put(item, (count == null) ? 1 : count+1);
        }

        Integer maxCount = 0;
        List<Integer> multiMode = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            Integer count = item.getValue();
            if (count == maxCount)
                multiMode.add(item.getKey());
            if (count > maxCount) {
                maxCount = count;
                multiMode = new ArrayList<Integer>();
                multiMode.add(item.getKey());
            }
        }

        System.out.println(multiMode);
    }
}
