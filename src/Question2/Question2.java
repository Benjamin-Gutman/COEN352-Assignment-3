package Question2;

// This code uses the Bently-McIntyre version of the 3 way partition for quick sort to put the values
// from less, equal and more than the key in their respective positions. In this case the key is 5
public class Question2{
	
	public static void main(String[] args) {
		int[] array = {5, 3, 5, 5, 2, 5, 8, 5, 1, 5, 5, 9, 5, 6, 0, 10, 5, 11, 4, 5};
		partition(array, 0, array.length-1);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	public static void partition(int[] arr, int low, int high) {
		int left, right, eqLeft, eqRight, key;
		eqLeft = low+1;
		eqRight = high;
		key = arr[low];
		left = low+1;
		right = high;
		while (left <=right) {
			while (left <= right && arr[left] < key) {
				left++;
			}
			while (left <= right && arr[right] > key) {
				right--;
			}
			if (left > right) {
				break;
			}
			if (arr[left] == key) {
				int temp = arr[left];
				arr[left] = arr[eqLeft];
				arr[eqLeft++] = temp;
				left++;
			}
			else if (arr[right] == key) {
				int temp = arr[right];
				arr[right] = arr[eqRight];
				arr[eqRight--] = temp;
				right--;
			}
			else if( arr[left] > key && arr[right] < key) {
				int temp = arr[right];
				arr[right] = arr[left];
				arr[left] = temp;
				right--;
				left++;
			}
		}
		for (int i = low; i < eqLeft; i++) {
			int temp = arr[i];
			arr[i] = arr[right];
			arr[right] = temp;
			right--;
		}
		for (int i = high; i > eqRight; i--) {
			int temp = arr[i];
			arr[i] = arr[left];
			arr[left] = temp;
			left++;
		}
	}
}