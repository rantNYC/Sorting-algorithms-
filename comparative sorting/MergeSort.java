public class MergeSort {
	
	int counter = 0;
	
	public void Sort(int[] a, int p, int r){
		int q;
		if(p < r){
			q = (int)(p+r)/2;
			Sort(a, p, q);
			Sort(a, q+1, r);
			Merge(a, p, q, r);
		}
	}
	
	public void Merge(int[] a, int p, int q, int r){
		int n1 = (q-p) + 1;
		int n2 = (r-q);
		int[] L = new int[n1+1];
		int[] R = new int[n2+1];
		for(int i = 0; i < n1; i++){
			L[i] = a[(p+i)];
		}
		for(int j = 0; j < n2; j++){
			R[j] = a[(q+j) + 1];
		}
		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;
		int i = 0;
		int j = 0;
		for(int k = p; k <= r; k++){
			counter = counter + 1;
			if (L[i] <= R[j]){
				a[k] = L[i];
				i++;
			}
			else{
				a[k] = R[j];
				j++;
			}
		}
		
	}

}
