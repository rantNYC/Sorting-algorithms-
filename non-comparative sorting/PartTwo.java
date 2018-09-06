import java.util.*;
import java.io.*;
/**
 * @author Rafael Ninalaya
 *
 */
public class PartTwo {

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
			int CSoutput[] = new int[numbers.length];
			int RSoutput[] = new int[numbers.length];
			
			BufferedWriter writerCS = new BufferedWriter(new FileWriter("OutputCS" + args[i] + ".txt"));
			CountingSort CS = new CountingSort();
			CS.Sort(sorted, CSoutput);
			writerCS.write("Count Sort:	" + Arrays.toString(CSoutput));
			writerCS.newLine();
			writerCS.write(String.valueOf(CS.counter));
			
			BufferedWriter writerRS = new BufferedWriter(new FileWriter("OutputRS" + args[i] + ".txt"));
			sorted = Arrays.copyOf(numbers, numbers.length);
			RadixSort RS = new RadixSort();
			RS.Sort(sorted, RSoutput);
			writerRS.write("Radix Sort:	" + Arrays.toString(RSoutput));
			writerRS.newLine();
			writerRS.write(String.valueOf(RS.counter));
			
			BufferedWriter writerBS = new BufferedWriter(new FileWriter("OutputBS" + args[i] + ".txt"));
			sorted = Arrays.copyOf(numbers, numbers.length);
			BucketSort BS = new BucketSort();
			BS.Sort(sorted);
			writerBS.write("Bucket Sort:	" + Arrays.toString(sorted));
			writerBS.newLine();
			writerBS.write(String.valueOf(BS.counter));
			
			writerCS.close();
			writerRS.close();
			writerBS.close();
			}
		
	}
}
