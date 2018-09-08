public class Selection extends Sorter {
    public void sort(int[] arr) {
        initCounters();

        for (int i = 0; i < arr.length-1; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                comparison_count++;
                if (arr[min] > arr[j])
                    min = j;
            }

            if (min != i) {
                move_count += 3;
                Utils.swap(arr, i, min);
            }
        }
    }
}
