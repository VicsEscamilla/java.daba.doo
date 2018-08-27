public class Sorts {
    private static int comparison_count=0;
    private static int moves_count=0;

    private interface Sorter {
        void sort(int[] arr);
    }

    public static void initCounters() {
        comparison_count = 0;
        moves_count = 0;
    }

    public static void selection(int[] arr) {
        initCounters();

        for (int i = 0; i < arr.length-1; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                comparison_count++;
                if (arr[min] > arr[j])
                    min = j;
            }

            if (min != i) {
                moves_count += 3;
                Utils.swap(arr, i, min);
            }
        }
    }

    public static void insertion(int[] arr) {
        initCounters();

        for (int i=1; i<arr.length; i++) {
            int j, tmp=arr[i];
            for(j=i-1; j>=0; j--) {
                comparison_count++;
                if (tmp >= arr[j])
                    break;

                moves_count++;
                arr[j+1] = arr[j];
            }
            moves_count++;
            arr[j+1] = tmp;
        }
    }

    public static void shell(int[] arr) {
        initCounters();

        int[] sequence = {29524, 9841, 3280, 1093, 364, 121, 40, 13, 4, 1};

        for (int k=0; k<sequence.length; k++) {
            int gap = sequence[k];
            for (int i=gap+1; i<arr.length-gap; i+=1) {
                int j, tmp=arr[i];
                for(j=i-gap; j>=0 && tmp < arr[j]; j-=gap) {
                    comparison_count++;
                    moves_count++;
                    arr[j+gap] = arr[j];
                }
                moves_count++;
                arr[j+gap] = tmp;
            }
        }
    }

    public static void bubble(int[] arr) {
        initCounters();

        for (int i=0; i<arr.length-1; i++) {
            boolean no_swap = true;
            for (int j=0; j<arr.length-i-1; j++) {
                comparison_count++;
                if (arr[j+1] < arr[j]) {
                    no_swap = false;
                    moves_count += 3;
                    Utils.swap(arr, j, j+1);
                }
            }
            if (no_swap)
                return;
        }

    }

    public static void printCounters() {
        System.out.println("Comparison count: " + comparison_count);
        System.out.println("Moves count: " + moves_count);
    }

    public static void test(String name, Sorter s) {
        System.out.println(name);
        int[] arr = Utils.createIntArray(100, -1000, 1000, Utils.SORTED|Utils.DESC|Utils.USE_SEED, 1234);
        Utils.printArray(arr);

        s.sort(arr);
        Utils.printArray(arr);

        System.out.println(Utils.isSorted(arr));
        printCounters();
        System.out.println();
    }

    public static void testSelection() {
        test("Selection!!", (arr)->{selection(arr);});
    }

    public static void testInsertion() {
        test("Insertion!!", (arr)->{insertion(arr);});
    }

    public static void testBubble() {
        test("Bubble!!", (arr)->{bubble(arr);});
    }

    public static void testShell() {
        test("Shell!!", (arr)->{shell(arr);});
    }

    public static void main(String[] args) {
        testSelection();

        testInsertion();

        testShell();

        testBubble();
    }
}
