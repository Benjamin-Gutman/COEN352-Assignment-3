package Question1;

public class Question1{
	
	public static void main(String[] args) {
		char[] arr = {'B','A','B','A','B','A','B','A','C','A','D','A','B','R','A'};
		quickSortPartition(arr, 0 , arr.length-1);
	}
	
	public static void quickSortPartition(char[] arr, int low, int high) {
		int less = low;
		int more = high;
		char key = arr[low];
		int i = low;
		while (i<=more) {
			if (arr[i] > key) {
				char temp = arr[i];
				arr[i] = arr[more];
				arr[more--] = temp;
			}
			else if (arr[i] < key) {
				char temp = arr[i];
				arr[i] = arr[less];
				arr[less++] = temp;
			}
			else {
				i++;
			}
			printTrace(arr);
		}
	}
	
	public static void printTrace(char[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
		System.out.println("");
	}
}