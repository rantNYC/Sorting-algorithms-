
public class CountingSort {

	int counter = 0;
	
	public int getMax(int[] a) {
		int max = a[0];
		for(int i = 1; i < a.length; i++) {
			if(a[i] > max){
				max = a[i];
			}
		}
		
		return max;
	}
	
	public void Sort(int[] a, int[] b){
		
		int k = getMax(a)+1;
		
		int c[] = new int[k];
		
		for(int i = 0; i < k; i++){
			c[i] = 0;
		}
		
		for(int j = 0; j < a.length; j++){
			c[a[j]] = c[a[j]] + 1;
		}
		
		for(int i = 1; i < k; i++){
			c[i] = c[i] + c[i-1];
		}
		
		for(int j = a.length-1; j >= 0; j--){
			counter = counter + 1;
			b[c[a[j]]-1] = a[j];
			c[a[j]] = c[a[j]] - 1; 
		}
	}
}
