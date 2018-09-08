import java.util.Arrays;

public class MergeSort extends Sorter{

    private int[] merge(int[] a, int[]b, int[]result){
        int index_a = 0;
        int index_b = 0;
        int index_r = 0;

        while(true) {
            comparison_count++;

            if (index_a == a.length) {
                while(index_b < b.length)
                    result[index_r++] = b[index_b++];
                break;
            }

            if (index_b == b.length) {
                while(index_a < a.length)
                    result[index_r++] = a[index_a++];
                break;
            }

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
}
