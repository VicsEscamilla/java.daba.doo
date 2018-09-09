import java.util.Arrays;

public class MergeSort extends Sorter{

    private int[] merge(int[] a, int[]b, int[]result){
        int index_a = 0;
        int index_b = 0;
        int index_r = 0;

        while(true) {
            comparison_count++;

            if (index_a == a.length) {
                while(index_b < b.length) {
                    move_count++;
                    result[index_r++] = b[index_b++];
                }
                break;
            }

            if (index_b == b.length) {
                while(index_a < a.length) {
                    move_count++;
                    result[index_r++] = a[index_a++];
                }
                break;
            }

            move_count++;
            if (a[index_a] < b[index_b])
                result[index_r++] = a[index_a++];
            else
                result[index_r++] = b[index_b++];
        }

        return result;
    }

    private void mergesort(int[] array) {
        if (array.length <= 1)
            return;

        int[] left = Arrays.copyOfRange(array, 0, array.length/2);
        mergesort(left);

        int[] right = Arrays.copyOfRange(array, array.length/2, array.length);
        mergesort(right);

        merge(left, right, array);
    }

    public void sort(int[] array) {
        initCounters();
        mergesort(array);
    }


    // For a posteriori analysis
    public static void main(String[] args) {
        MergeSort merge = new MergeSort();

        for (int n=1; n<=200; n++) {

            long sum_comparisons=0;

            for (int i=0; i<50; i++) {

                merge.sort(Utils.createIntArray(n, -1000000, 1000000));

                sum_comparisons += comparison_count;
            }

            System.out.println(sum_comparisons/100);
        }
    }
}
