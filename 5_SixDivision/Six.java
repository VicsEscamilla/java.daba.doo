import java.util.ArrayList;

class Six {
    public static void main(String[] args) {
        int number = Integer.parseInt(args[0]);

        ArrayList<Integer> list = new ArrayList<Integer>();

        int ret = number/6;
        list.add(ret);

        while(ret > 0) {
            ret /= 6;
            list.add(ret);
        }

        for (Integer item : list) {
            if (item != 0)
                System.out.println(item);
        }
    }
}
