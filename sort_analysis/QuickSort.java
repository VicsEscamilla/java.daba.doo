public class QuickSort extends Sorter{

    private int partition(int[] array, int left, int right){
        int pivot = array[right];
        int p1= left-1; 
        int p2=right; 
        while(p1<p2){
            p1++;
            p2--;
            while(p1<=right && array[p1]<pivot){
                p1++;
                comparison_count++;
            }

            while(p2>left && array[p2]>pivot){
                p2--;
                comparison_count++;
            }

            if(p1<p2) {
                Utils.swap(array, p1, p2);
                move_count++;
            }
        }

        move_count++;
        Utils.swap(array, p1, right);
        
        return p1;
    }


	private void quickSort(int[] array, int left, int right) {
		if(left >= right) return;
		int p = partition(array, left, right);
		quickSort(array, left, p - 1);
		quickSort(array, p + 1, right);
	}


	public void sort(int[] array) {
        initCounters();
		quickSort(array, 0, array.length - 1);
	}

    // For a posteriori analysis
    public static void main(String[] args) {
        QuickSort quick = new QuickSort();

        for (int n=1; n<=200; n++) {

            long sum_comparisons=0;

            for (int i=0; i<50; i++) {

                quick.sort(Utils.createIntArray(n, -1000000, 1000000));

                sum_comparisons += comparison_count;
            }

            System.out.println(sum_comparisons/100);
        }
    }

}
