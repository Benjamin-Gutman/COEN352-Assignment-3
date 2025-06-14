package Question5;

import java.util.*;

public class Question5{
	static class SymbolTable{
		String[] key;
		double[] data;
		int currentSize;
		
		public SymbolTable(int size) {
			key = new String[size];
			data = new double[size];
		}
		
		public void put(String symbol, double info) {
			for (int i = 0; i < currentSize; i++) {
				if (key[i].equals(symbol)) {
					data[i] = info;
					return;
				}
			}
			key[currentSize] = symbol;
			data[currentSize] = info;
			currentSize++;
		}
		
		public double get(String symbol) {
			for (int i = 0; i < currentSize; i++) {
				if (key[i].equals(symbol)) {
					return data[i];
				}
			}
			return -1;
		}
	}
	
	public static void main(String[] args) {
		SymbolTable grades = new SymbolTable(11);
		grades.put("A+", 4.33);
		grades.put("A", 4.0);
		grades.put("A-", 3.67);
		grades.put("B+", 3.33);
		grades.put("B", 3.0);
		grades.put("B-", 2.67);
		grades.put("C+", 2.33);
		grades.put("C", 2.0);
		grades.put("C-", 1.67);
		grades.put("D", 1.0);
		grades.put("F", 0);
		
		Scanner scanner = new Scanner(System.in);
		
		String input = "";
		double iterations=0;
		double sum = 0;
		System.out.print("Enter Student Grade (-1 to stop)");
		input = scanner.nextLine();
		while (!(input.equals("-1"))) {
			sum += grades.get(input);
			iterations++;
			System.out.print("Enter Student Grade (-1 to stop)");
			input = scanner.nextLine();
		}
		System.out.println("Students GPA is: " + sum/iterations);
		scanner.close();
	}
	
}