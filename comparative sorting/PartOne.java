import java.util.*;
import java.io.*;
/**
 * @author Rafael Ninalaya
 *
 */
public class PartOne {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		for(int i = 0; i < args.length; i++){
			FileInputStream fstream = new FileInputStream(args[i]);
			BufferedReader reader = new BufferedReader(new InputStreamReader(fstream));
			int arrayGrowth = 1;
			int numbers[] = new int[0];
			int n = 0;
			int j = 0;
			String line = reader.readLine();
			while (!line.isEmpty()){
				if (numbers.length == j) {
		              // expand list
		              numbers = Arrays.copyOf(numbers, numbers.length + arrayGrowth);
		         }
				n = Integer.parseInt(line);
				numbers[j] = n;
				line = reader.readLine();
				if(line == null)
					break;
				j++;	
			}
			int[] sorted = Arrays.copyOf(numbers, numbers.length);
			InsertionSort IS = new InsertionSort();
			IS.Sort(sorted);
			System.out.println("InsertionSort:	" + Arrays.toString(sorted));
			System.out.println(IS.counter);
			
			sorted = Arrays.copyOf(numbers, numbers.length);;
			MergeSort MS = new MergeSort();
			MS.Sort(sorted, 0, sorted.length-1);
			System.out.println("MergeSort: 	" + Arrays.toString(sorted));
			System.out.println(MS.counter);
			
			sorted = Arrays.copyOf(numbers, numbers.length);;
			HeapSort HS = new HeapSort();
			HS.Sort(sorted);
			System.out.println("HeapSort: 	" + Arrays.toString(sorted));
			System.out.println(HS.counter);
			
			sorted = Arrays.copyOf(numbers, numbers.length);;
			QuickSort QS = new QuickSort();
			QS.Sort(sorted, 0, sorted.length-1);
			System.out.println("QuickSort: 	" + Arrays.toString(sorted));
			System.out.println(QS.counter);
			
		}
	}

}
