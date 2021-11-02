package comp352_ass1_OddonacciCalculator;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Scanner;

public class myMain {

	public static void main(String[] args) throws IOException {

		String out1 = "C:\\Users\\simon\\eclipse-workspace\\comp352_ass1_OddonacciCalculator\\src\\comp352_ass1_OddonacciCalculator\\out1.txt";
		String out2 = "C:\\Users\\simon\\eclipse-workspace\\comp352_ass1_OddonacciCalculator\\src\\comp352_ass1_OddonacciCalculator\\out2.txt";

		// prompt user for number of Oddonacci numbers
		int count = 0;
		Scanner s = new Scanner(System.in);
		while (count <= 0) {
			System.out.println("Enter number of Oddonacci numbers you want to print (>0): ");
			count = s.nextInt();
		}
		s.close();

		// --------------------------OddonacciBinaryRecursion----------------------------------

		// execute Oddonacci fx & track time elapsed & create String
		// concatenation of sequence to write to file
		System.out.println("\nUsing Binary Recursion, the first " + count + " Oddonacci numbers are:");
		String sequence1 = "";
		long startTime1 = System.nanoTime();
		for (int i = 0; i < count; i++) {
			sequence1 = sequence1.concat(oddBinaryRecursion(i) + "\r\n");
		}
		long endTime1 = System.nanoTime();
		double totalTime1 = (endTime1 - startTime1) / 1000000000.00;
		
		// print sequence to screen
		System.out.println(sequence1);

		// print time elapsed
		DecimalFormat df = new DecimalFormat(".000000");
		System.out.printf("This took " + df.format(totalTime1) + " seconds to complete.\n");

		// write Oddonacci numbers to text file
		writeFile(out1, sequence1);

		// --------------------------OddonacciLinearRecursion----------------------------------
		
		// execute Oddonacci fx & track time elapsed & create String
		// concatenation of sequence to write to file
		System.out.println("\nUsing Linear Recursion, the first " + count + " Oddonacci numbers are:");
		String sequence2 = "";
		long startTime2 = System.nanoTime();
		for (int i = 0; i < count; i++) {
			sequence2 = sequence2.concat(oddLinearRecursion(i, 1, 1, 1) + "\r\n");
		}
		
		long endTime2 = System.nanoTime();
		double totalTime2 = (endTime2 - startTime2) / 1000000000.00;
		
		// print sequence to screen
		System.out.println(sequence2);

		// print time elapsed
		System.out.printf("This took " + df.format(totalTime2) + " seconds to complete.\n");

		// write Oddonacci numbers to text file
		writeFile(out2, sequence2);
		
		
		
		
		
		
		
	}
	
	// takes count of fib numbers to print & returns fib number
	public static long oddBinaryRecursion(int n) {
		if (n <= 2) return 1;
		else {
			long term = oddBinaryRecursion(n - 1) + oddBinaryRecursion(n - 2) + oddBinaryRecursion(n - 3);
			return term;
		}
	}

	// takes n = count of fib numbers to print
	//       a = 1
	//       b = 1
	//       c = 1
	// returns fib number
	public static long oddLinearRecursion(int n, int a, int b, int c) {
		if (n <= 1) return b;
		return oddLinearRecursion(n-1, b, c, a+b+c);
	}


	// takes file path and string and writes string to file @path
	public static void writeFile(String path, String contents) throws IOException {
		FileWriter w = new FileWriter(path);
		w.write(contents);
		w.close();
	}

	


}
