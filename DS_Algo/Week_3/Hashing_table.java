import java.util.*;

/*
		Just for fun
*/


class HashEntry {
	private int key;
	private String value;

	HashEntry(int key, String value) {
		this.key = key;
		this.value = value;
	}

	public int getKey() {
		return this.key;
	}

	public String getValue() {
		return this.value;
	}

	public String toString() {
		return this.key + " " + this.value;
	}
}

class HashTable {
	private final static int size = 40;

	HashEntry[] table;

	HashTable () {
		table = new HashEntry[size];
		for (int i = 0; i < size ; i++)
			table[i] = null;

	}

	public String get (int key) {
		int hash = key % size;

		while (table[hash] != null && table[hash].getKey() != key)
			hash = (hash + 1) % size;

		if (table[hash] == null)  return "-1";
		else  return table[hash].getValue();
	}

	public void put (int key, String value) {
		int hash = key % size;
		while (table[hash] != null && table[hash].getKey() != key)
			hash = (hash + 1) % size;

		table[hash] = new HashEntry(key, value);
	}
	public void showData() {
		System.out.println(Arrays.toString(table));
	}

}

public class Hashing_table {
	public static void main(String[] args) {
		HashTable table = new HashTable();
		table.put(1, "A");
		table.put(2, "B");
		table.put(3, "C");
		table.put(2, "D");
		table.put(3, "E");
		table.put(39, "F");
		table.put(40, "G");

		table.showData();
	}
}
