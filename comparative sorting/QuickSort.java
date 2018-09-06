
public class QuickSort {

	int counter = 0;

	public void Sort(int[] a, int p, int r){
		if(p < r){
			int q = partition(a, p, r);
			Sort(a, p, q-1);
			Sort(a, q+1, r);
		}
	}
	
	public int partition(int[] a, int p, int r){
		int x = a[r];
		int i = p - 1;
		for(int j = p; j < r; j++){
			counter = counter + 1;
			if(a[j] <= x){
				i = i + 1;
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		
		int swap = a[i+1];
		a[i+1] = a[r];
		a[r] = swap;
		
		return i+1;
	}
}
