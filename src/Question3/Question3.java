package Question3;

public class Question3{
	public static void main(String[] args) {
		MinMaxQueue test = new MinMaxQueue();
		test.insert(2);
		test.insert(13);
		test.insert(2);
		test.insert(8);
		test.insert(67);
		test.insert(54);
		test.insert(1);
		test.insert(8);
		test.insert(3);
		
		int max = test.findMax();
		int min = test.findMin();
		System.out.println(max);
		System.out.println(min);
		
		test.deleteMax();
		max = test.findMax();
		System.out.println(max);
		System.out.println(min);
		
		test.deleteMin();
		min = test.findMin();
		System.out.println(max);
		System.out.println(min);
		}
	
}

class MinMaxQueue{
	static node[] minHeap = new node[101];
	static node[] maxHeap = new node[101];
	static int size = 0;
	
	class node{
		int data;
		int indexMin;
		int indexMax;
	}

	public void insert(int newVal) {
		size++;
		node newNode = new node();
		newNode.data = newVal;
		minHeap[size] = newNode;
		maxHeap[size] = newNode;
		newNode.indexMin = size;
		newNode.indexMax = size;
		sortNewMin(size);
		sortNewMax(size);
	}
	static void sortNewMin(int index) {
		if(index == 1) {
			return;
		}
		if (index%2 ==0) {
			if(minHeap[index/2].data <= minHeap[index].data) {
				return;
			}
			else {
				node temp = minHeap[index/2];
				minHeap[index/2] = minHeap[index];
				minHeap[index] = temp;
				minHeap[index].indexMin = index;
				minHeap[index/2].indexMin = index/2;
			}
			sortNewMin(index/2);
		}
		else {
			if(minHeap[(index-1)/2].data <= minHeap[index].data) {
				return;
			}
			else {
				node temp = minHeap[(index-1)/2];
				minHeap[(index-1)/2] = minHeap[index];
				minHeap[index] = temp;
				minHeap[index].indexMin = index;
				minHeap[(index-1)/2].indexMin = (index-1)/2;
			}
			sortNewMin((index-1)/2);
		}
	}
	
	static void sortNewMax(int index) {
		if (index == 1) {
			return;
		}
		if (index%2 ==0) {
			if(maxHeap[index/2].data >= maxHeap[index].data) {
				return;
			}
			else {
				node temp = maxHeap[index/2];
				maxHeap[index/2] = maxHeap[index];
				maxHeap[index] = temp;
				maxHeap[index].indexMax = index;
				maxHeap[index/2].indexMax = index/2;
			}
			sortNewMax(index/2);
		}
		else {
			if(maxHeap[(index-1)/2].data >= maxHeap[index].data) {
				return;
			}
			else {
				node temp = maxHeap[(index-1)/2];
				maxHeap[(index-1)/2] = maxHeap[index];
				maxHeap[index] = temp;
				maxHeap[index].indexMax = index;
				maxHeap[(index-1)/2].indexMax = (index-1)/2;
			}
			sortNewMax((index-1)/2);
		}
	}
	
	public void deleteMax() {
		int minIndex = maxHeap[1].indexMin;
	    maxHeap[1] = maxHeap[size];
	    minHeap[minIndex] = minHeap[size];
	    minHeap[minIndex].indexMin = minIndex;
	    maxHeap[1].indexMax = 1;
		size--;
	    bubbleMax(1);
	    bubbleMin(minIndex);
	}
	
	public void deleteMin() {
		int maxIndex = minHeap[1].indexMax;
	    minHeap[1] = minHeap[size];
	    maxHeap[maxIndex] = maxHeap[size];
	    maxHeap[maxIndex].indexMax = maxIndex;
	    minHeap[1].indexMin = 1;
		size--;
	    bubbleMin(1);
	    bubbleMax(maxIndex);
	}
	
	public int findMax() {
		return maxHeap[1].data;
	}
	
	public int findMin() {
		return minHeap[1].data;
	}

	static void bubbleMin(int index) {
		if (index*2+1 > size) {
			if (index*2 > size) {
				return;
			}
			else {
				node temp = minHeap[2*index];
				minHeap[2*index] = minHeap[index];
				minHeap[index] = temp;
				minHeap[index].indexMin = index;
				minHeap[2*index].indexMin = 2*index;
			}
		}
		else if(minHeap[index].data > minHeap[2*index].data  && minHeap[2*index].data < minHeap[2*index+1].data) {
			node temp = minHeap[2*index];
			minHeap[2*index] = minHeap[index];
			minHeap[index] = temp;
			minHeap[index].indexMin = index;
			minHeap[2*index].indexMin = 2*index;
			bubbleMin(2*index);
		}
		else if(minHeap[index].data > minHeap[2*index+1].data && minHeap[2*index].data > minHeap[2*index+1].data) {
			node temp = minHeap[2*index+1];
			minHeap[2*index+1] = minHeap[index];
			minHeap[index] = temp;
			minHeap[index].indexMin = index;
			minHeap[2*index+1].indexMin = 2*index+1;
			bubbleMin(2*index+1);
		}
		return;
	}
	
	static void bubbleMax(int index) {
		if (index*2+1 > size) {
			if (index*2 > size) {
				return;
			}
			else if (maxHeap[index].data < maxHeap[2*index].data ){
				node temp = maxHeap[2*index];
				maxHeap[2*index] = maxHeap[index];
				maxHeap[index] = temp;
				maxHeap[index].indexMax = index;
				maxHeap[2*index].indexMax = 2*index;
				return;
			}
		}
		else if(maxHeap[index].data < maxHeap[2*index].data && maxHeap[2*index].data > maxHeap[2*index+1].data) {
			node temp = maxHeap[2*index];
			maxHeap[2*index] = maxHeap[index];
			maxHeap[index] = temp;
			maxHeap[index].indexMax = index;
			maxHeap[2*index].indexMax = 2*index;
			bubbleMax(2*index);
		}	
		else if(maxHeap[index].data < maxHeap[2*index+1].data && maxHeap[2*index].data < maxHeap[2*index+1].data) {
			node temp = maxHeap[2*index+1];
			maxHeap[2*index+1] = maxHeap[index];
			maxHeap[index] = temp;
			maxHeap[index].indexMax = index;
			maxHeap[2*index+1].indexMax = 2*index+1;
			bubbleMax(2*index+1);
		}
		return;
	}
}
	


