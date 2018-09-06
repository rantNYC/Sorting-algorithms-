import java.util.Arrays;

public class BucketSort {

	int counter = 0;
	
	public void InsertionSort(float[] a){
		for(int j = 1; j < a.length; j++){
			float key = a[j];
			int i = j - 1;
			while (i >= 0 && a[i] > key){
				counter++;
				a[i+1] = a[i];
				i = i - 1;
			}
			a[i+1] = key;	
		}
	}
	
	public void Sort(int[] a){
		int n = a.length;
		float range[] = convert(a, n);
		float[][] b = new float[n][n+1];
		
		//for(int i = 0; i<b.length; i++){
		//	b[i] = 0;
		//}
		
		for(int i = 0; i < n; i++){
			int bi = (int) (n*range[i]);
			b[bi][i] = range[i];
		}
		
		for(int i = 0; i < n; i++){
			InsertionSort(b[i]);
		}
		
		int pos = 0;
		for (int i=0; i < n; i++) {
	         for (int j=0; j < n+1; j++) {
	        	 if(b[i][j] > 0	)
	        		 range[pos++] = b[i][j];
	         }
	    }
		
		a = reverse(range, a, n);
	}
	
	public float[] convert(int[] a, int n){
		
		float[] b = new float[n];
		for(int i = 0; i < n; i++){
			b[i] = (float) a[i];
		}
		
		float x = b[0];
        float y = b[0];
        for (int i = 1; i < n; i++) {
            if (b[i] < x) {
            	x = b[i];
            } else if (b[i] > y) {
                y = b[i];
            }
        }
        
        x = -x;
        for(int i = 0; i < n; i++){
        	b[i] = b[i] + x;
        }
        y = y + 1;
        for(int i = 0; i < n; i++){
        	if(b[i] == 0){
        		b[i] = Float.MIN_VALUE;
        	}
        	else{
        		b[i] = b[i]/y;
        	}
        }
        
        return b;
	}
	
	public int[] reverse(float[] a, int[] b, int n){
		
		int x = b[0];
        int y = b[0];
        for (int i = 1; i < n; i++) {
            if (b[i] < x) {
            	x = b[i];
            } else if (b[i] > y) {
                y = b[i];
            }
        }
        
        y = y + 1;
        for(int i = 0; i < n; i++){
        	b[i] = Math.round(a[i]*y);
        }
        
        for(int i = 0; i < n; i++){
        	b[i] = Math.round(b[i] + x);
        }
        
        return b;
	}
}
