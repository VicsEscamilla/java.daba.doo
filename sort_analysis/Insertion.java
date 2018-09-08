public class Insertion extends Sorter {
    public void sort(int[] arr) {
        initCounters();

        for (int i=1; i<arr.length; i++) {
            int j, tmp=arr[i];
            for(j=i-1; j>=0; j--) {
                comparison_count++;
                if (tmp >= arr[j])
                    break;

                move_count++;
                arr[j+1] = arr[j];
            }
            move_count++;
            arr[j+1] = tmp;
        }
    }
}
