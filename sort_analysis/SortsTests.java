abstract class Sorter {

    protected static int comparison_count=0;
    protected static int move_count=0;


    public abstract void sort(int[] arr);


    protected void initCounters() {
        comparison_count = 0;
        move_count = 0;
    }


    public int comparisonCount() {
        return comparison_count;
    }


    public int moveCount() {
        return move_count;
    }

}



public class SortsTests{

    public static void printCounters(Sorter s) {
        System.out.println("Comparison count: " + s.comparisonCount());
        System.out.println("Moves count: " + s.moveCount());
    }


    public static void test(String name, Sorter s) {
        System.out.println(name);
        int[] arr = Utils.createIntArray(100, -1000, 1000, Utils.SORTED|Utils.DESC|Utils.USE_SEED, 1234);
        Utils.printArray(arr);

        s.sort(arr);
        Utils.printArray(arr);

        System.out.println(Utils.isSorted(arr));
        printCounters(s);
        System.out.println();
    }


    public static void testSelection() {
        test("Selection!!", new Selection());
    }


    public static void testInsertion() {
        test("Insertion!!", new Insertion());
    }


    public static void testBubble() {
        test("Bubble!!", new Bubble());
    }


    public static void testShell() {
        test("Shell!!", new Shell());
    }


    public static void testQuickSort() {
        test("QuickSort!!", new QuickSort());
    }


    public static void main(String[] args) {
        testSelection();
        testInsertion();
        testBubble();
        testShell();
        testQuickSort();
    }

}
