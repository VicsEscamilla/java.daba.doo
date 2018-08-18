import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

class Partitions {
    public static List<List<Integer>> getPermutations(List<Integer> array) {
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        generatePermutations(array, permutations);
        return permutations;
    }

    private static void generatePermutations(List<Integer> array, List<List<Integer>> permutations) {
        if (array.size() == 1) {
            permutations.add(Arrays.asList(array.get(0)));
            return;
        }

        generatePermutations(array.subList(1, array.size()), permutations);
        for (List<Integer> p : new ArrayList<List<Integer>>(permutations)) {
            for (int i=0; i<p.size()+1; i++) {
                List<Integer> tmp = new ArrayList<Integer>(p);
                tmp.add(i, array.get(0));
                permutations.add(tmp);
            }
        }

        permutations.add(Arrays.asList(array.get(0)));

        return;
    }

    public static void main(String[] args){
        List<List<Integer>> perms = getPermutations(Arrays.asList(1,2,3));
        System.out.println(perms.size());
        System.out.println(perms);

        int MAX = 4; // max sum
        for (List<Integer> itemlist : perms) {
            int sum = 0;
            String result = "";
            for (Integer item : itemlist) {
                result += item.toString() + " ";
                sum += item;
            }
            if (sum <= MAX)
                System.out.println(result);
        }
    }
}
