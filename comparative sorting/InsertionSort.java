
public class InsertionSort {
	int counter = 0;
	
	public void Sort(int[] a){
		for(int j = 1; j < a.length; j++){
			int key = a[j];
			int i = j - 1;
			while (i >= 0 && a[i] > key){
				counter++;
				a[i+1] = a[i];
				i = i - 1;
			}
			a[i+1] = key;	
		}
	}

}
