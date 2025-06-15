package Question6;


public class Question6{
	
	public static void main(String[] args) {
		OrderedSequentialSearchST<String, Integer> test = new OrderedSequentialSearchST<>();
		test.put("G", 7);
		test.put("D", 4);
		test.put("A", 1);
		test.put("B", 2);
		test.put("V", 23);
		test.put("M", 13);
		test.printList();
		
		System.out.println(test.get("G"));
		System.out.println(test.get("A"));
		
		test.put("G", 28);
		System.out.println(test.get("G"));
		test.printList();
		
		System.out.println(test.contains("R"));
		System.out.println(test.contains("B"));

		test.delete("G");
		test.printList();
		
		System.out.println(test.isEmpty());
		System.out.println(test.size());
		
	}
	
	
}

class OrderedSequentialSearchST<Key extends Comparable<Key>, Value>{
	Node Head;
	int size = 0;
	class Node{
		Node next;
		Key key;
		Value data;
		
		public Node(Key KEY, Value DATA) {
			key = KEY;
			data = DATA;
		}
	}
	
	
	public void put(Key newKey, Value newData){
		if (size == 0) {
			Head = new Node(newKey, newData);
			size++;
			return;
		}
		Node temp = Head;
		if (Head.key.compareTo(newKey) >= 0) {
			if (Head.key.equals(newKey)) {
			    Head.data = newData;
			    return;
			}
			Node newHead = new Node(newKey, newData);
			newHead.next = Head;
			Head = newHead;
			size++;
			return;
		}
		while (temp.next != null) {
			if (temp.next.key.compareTo(newKey) <= 0) {
				if (temp.next.key.equals(newKey)){
					temp.next.data = newData;
					return;
				}
				temp = temp.next;
			}
			else {
				break;
			}
		}
		Node newNode = new Node(newKey, newData);
		newNode.next = temp.next;
		temp.next = newNode;
		size++;
	}
	
	public Value get(Key keySearch) {
		Node temp = Head;
		while (temp.next != null) {
			if (temp.key.compareTo(keySearch) <= 0) {
				if (temp.key.equals(keySearch)){
					return temp.data;
				}
				temp = temp.next;
			}
			else {
				return null;
			}
		}
		if (temp.key.equals(keySearch)){
			return temp.data;
		}
		return null;
	}
	
	public boolean contains(Key key) {
		return (get(key) != null);
	}
	
	public void delete(Key key) {
		Node temp = Head;
		if(isEmpty()) {
			return;
		}
		if(temp.key.compareTo(key)== 0) {
			Head = Head.next;
			size--;
			return;
		}
		while (temp.next != null) {
			if (temp.next.key.equals(key)) {
				temp.next = temp.next.next;
				size--;
				return;
			}
			temp = temp.next;
		}
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return (size == 0);
	}
	
	
	public void printList() {
		Node temp = Head;
		while (temp != null) {
			System.out.println(temp.key + " " + temp.data);
			temp = temp.next;
		}
		
	}
	
}