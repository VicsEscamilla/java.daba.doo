public class Shell extends Sorter {
    public void sort(int[] arr) {
        initCounters();

        int[] sequence = {29524, 9841, 3280, 1093, 364, 121, 40, 13, 4, 1};

        for (int k=0; k<sequence.length; k++) {
            int gap = sequence[k];
            for (int i=gap+1; i<arr.length-gap; i+=1) {
                int j, tmp=arr[i];
                for(j=i-gap; j>=0 && tmp < arr[j]; j-=gap) {
                    comparison_count++;
                    move_count++;
                    arr[j+gap] = arr[j];
                }
                move_count++;
                arr[j+gap] = tmp;
            }
        }
    }
}
