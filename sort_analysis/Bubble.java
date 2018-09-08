public class Bubble extends Sorter {
    public void sort (int[] arr) {
        initCounters();

        for (int i=0; i<arr.length-1; i++) {
            boolean no_swap = true;
            for (int j=0; j<arr.length-i-1; j++) {
                comparison_count++;
                if (arr[j+1] < arr[j]) {
                    no_swap = false;
                    move_count += 3;
                    Utils.swap(arr, j, j+1);
                }
            }
            if (no_swap)
                return;
        }

    }
}
