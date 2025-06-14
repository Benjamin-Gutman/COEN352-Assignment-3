package Question4;

import java.io.*;
import java.util.*;

public class Question4{
	public static void sort(DailyInfo[] arr) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j >0; j--) {
				if (arr[j].compareTo(arr[j-1]) == -1) {
					DailyInfo temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		String file = "info.txt";
		
		
		int lineCount = 0;
		Scanner Linecounter= new Scanner(new File(file));
		while (Linecounter.hasNextLine()) {
			Linecounter.nextLine();
			lineCount++;
		}
		Linecounter.close();
		
		DailyInfo[] fileInfo = new DailyInfo[lineCount];
		Scanner scanner = new Scanner(new File(file));
		int index = 0;
		while (scanner.hasNext()) {
			String date = scanner.next();
			int data = scanner.nextInt();
			fileInfo[index++] = new DailyInfo(date, data);
		}
		scanner.close();
		
		sort(fileInfo);
		
		for (int i = 0; i < fileInfo.length; i++) {
			fileInfo[i].print();
		}
		
	}
}

class DailyInfo implements Comparable<DailyInfo>{
	String date;
	int amount;
	
	public DailyInfo(String DATE, int AMOUNT) {
		date = DATE;
		amount = AMOUNT;
	}
	
	public void print() {
		System.out.println(date + " " + amount);
	}
	
	public int compareTo(DailyInfo cmp) {
		if (this.amount > cmp.amount) {
			return 1;
		}
		else if (this.amount < cmp.amount) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
}