public class RadixSort {
	
	int counter = 0;
	
	public int maxDigit(int[] a) {
		
		int max = a[0];
		for(int i = 1; i < a.length; i++) {
			if(a[i] > max){
				max = a[i];
			}
		}
		
		int digits = 0;
		for(int i = 1; max/i > 0; i*= 10) {
			digits++;
		}
		
		return digits;
	}
	
	public void CountingSort(int[] a, int[] b, int k){
		
		int div = (int) Math.pow(10, (k-1));
		int mod = (int) Math.pow(10, k);
		int c[] = new int[10];
		
		for(int i = 0; i < 10; i++){
			c[i] = 0;
		}
		
		for(int j = 0; j < a.length; j++){
			c[(a[j]%mod)/div] = c[(a[j]%mod)/div] + 1;
		}
		
		for(int i = 1; i < 10; i++){
			c[i] = c[i] + c[i-1];
		}
		
		for(int j = a.length-1; j >= 0; j--){
			counter = counter + 1;
			b[c[(a[j]%mod)/div]-1] = a[j];
			c[(a[j]%mod)/div] = c[(a[j]%mod)/div] - 1; 
		}
		
		for (int i=0; i<a.length; i++) {
			a[i] = b[i];
		}
	}
	
	public void Sort(int[] a, int[] b){
		
		int d = maxDigit(a);
		for(int i = 1; i <= d; i++){
			CountingSort(a, b, i);
		}
	}
	
}
