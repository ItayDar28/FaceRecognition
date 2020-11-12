package hw5;

import java.util.LinkedList;
import java.util.List;

public class HashTable {

		private List<ObjectPoint>[] table;
		private int capacity;
		private int size;

		public HashTable(int capacity){
			this.capacity = capacity;
			init();
		}

		private void init(){
			table = new LinkedList[capacity];
			size = 0;
		}

		public void insert(ObjectPoint object){
			if (table[hashFunction(object)] == null){
				table[hashFunction(object)] = new LinkedList<>(); //checking if the place in empty put there a new link list
			}

			table[hashFunction(object)].add(object);
			size++;

			return;
		}

		private int hashFunction(ObjectPoint object){
			return (object.getX()+object.getY()) % capacity;
		}

		public ObjectWithCoordinates search(int x, int y){
			int temp = (x + y) % (capacity); //the hash table condition for less memory get in to link list in the same number
			if (table[temp] == null){
				return null;
			} else {
				for (ObjectPoint object : table[temp]){
				    if (object.getX() == x && object.getY()== y){ //get in  to the hash if the condition its true
				        return object;
                    }
                }
			}
			return null;
	}
}

