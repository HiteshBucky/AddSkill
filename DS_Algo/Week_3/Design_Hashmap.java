// Design_Hashmap.java

import java.util.*;

public class MyHash {

	List<LinkedList<Node>> bucket ;

	public MyHashMap() {
		bucket = new ArrayList<LinkedList<Node>>(16);

		for (int i = 0 ; i < 16 ; i++) bucket.add(new LinkedList<Node>());
	}

	/** value will always be non-negative. */
	public void put(int key, int value) {
		int hash = key % 16;
		LinkedList<Node> list = bucket.get(hash);
		boolean found = false;
		for (Node node : list) {
			if (node.key == key) {
				node.value = value;
				found = true;
				break;
			}
		}
		if (!found) {
			Node node = new Node(key, value);
			bucket.get(hash).add(node);
		}
	}


}





class Design_Hashmap {
	public static void main(String[] args) {
		int MAXIMUM_CAPACITY = 1 << 30;
		System.out.println(MAXIMUM_CAPACITY * 2);
	}
}
