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

    // For a posteriori analysis
    public static void main(String[] args) {
        Shell shell = new Shell();

        for (int n=1000; n<=60000; n+=1000) {

            long sum_comparisons=0;

            for (int i=0; i<100; i++) {

                shell.sort(Utils.createIntArray(n, -1000000, 1000000));

                sum_comparisons += comparison_count;
            }

            System.out.println(sum_comparisons/100);
        }
    }
}
