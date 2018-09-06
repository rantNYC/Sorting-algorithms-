
public class HeapSort {
	int counter = 0;
	
	public void Sort(int[] a){
		int heap_size = a.length;
		Build_Max_Heap(a);
		for(int i = a.length-1; i >= 0; i--){
			int temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			heap_size = heap_size - 1;
			Max_Heapify(a, heap_size, 0);
		}
	}
	
	public void Max_Heapify(int[] a, int heap_size, int i){
		int l = 2*i + 1;
		int r = 2*i +2;
		int largest = i;
		
		if (l < heap_size && a[l] > a[i]){
			largest = l;
		}
		else{
			largest = i;
		}
		if (r < heap_size && a[r] > a[largest]){
			largest = r;
		}
		if (largest != i){
			int temp = a[i];
			a[i] = a[largest];
			a[largest] = temp;
			counter = counter + 1;
			Max_Heapify(a, heap_size, largest);
		}
	}
	
	public void Build_Max_Heap(int[] a){
		int heap_size = a.length;
		for(int i = heap_size/2 - 1; i >= 0; i--){
			Max_Heapify(a, heap_size, i);
		}
	}
}
