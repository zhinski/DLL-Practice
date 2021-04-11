//Michael Dobrzanski
import java.util.Iterator;

//import DLList.Node;

public class DLList<T> implements Iterable<T> {
	int size = 0;
	private static class Node<T> {
		// prev is reference to adjacent node closer to head (or null if this node is the head)
		// next is reference to adjacent node closer to tail (or null if this node is the tail)
		public Node<T> prev, next;
		// data is the information stored in the node of type T (T could be String, Integer, etc.)
		public T data;

		public Node(Node<T> prev, T data, Node<T> next) {
			this.prev = prev;
			this.next = next;
			this.data = data;
		}
	}

	// head is first node (no prev), tail is last node (no next)
	// They can both reference the same node if the list is one element long
	// The can both reference null if the list is empty
	private Node<T> head, tail;

	/**
	 * Forward iterator class (conductor).
	 */
	private static class Conductor<T> implements Iterator<T> {
		private Node<T> current; // Next node to visit

		public Conductor(Node<T> n) {
			current = n; // Begin at head
		}

		public boolean hasNext() {
			return current != null; // No more to visit
		}

		public T next() {
			T data = current.data; // Remember current
			current = current.next; // Advance to next
			return data; // Return old data
		}
	}

	private static class BackwardConductor<T> implements Iterator<T> {
		private Node<T> current; // Next node to visit

		public BackwardConductor(Node<T> n) {
			current = n; // Begin at tail
		}

		public boolean hasNext() {
			return current != null; // No more to visit
		}

		public T next() {
			T data = current.data; // Remember current
			current = current.prev; // Advance to next car
			return data; // Return old car data
		}
	}

	public DLList() {
		head = tail = null; // Empty list
	}

	/**
	 * Add data to the end (tail) of the list.
	 */
	public void add(T data) {
		if (tail == null) {
			// Empty list: one node is head and tail
			head = new Node<>(null, data, null);
			tail = head;
		} 
		else {
			tail.next = new Node<>(tail, data, null);
			tail = tail.next;
		}
		size++;
	}

	/**
	 * Retrieve an element from middle of list.
	 * 
	 * @param i
	 *            Zero-based index of element
	 * @return The element, or null if invalid i
	 */
	public T get(int i) {
		if (i < 0)
			throw new IndexOutOfBoundsException();
		Node<T> current = head;
		if (i > size / 2) { //speed up
			for (int caboose = size; caboose >= 0; caboose--) {
				current = current.next;
			}
		}
		else 
			for (int j = 0; current != null && j < i; j++) {
				// Count our way up to desired element
				current = current.next;
			}
		if (current == null)
			throw new IndexOutOfBoundsException();
		return current.data;
	}

	/**
	 * Get and remove element i from the list.
	 * 
	 * @param i
	 * @return element i or null if invalid i
	 */
	public T remove(int i) {		
		if (i < 0)
			throw new IndexOutOfBoundsException();
		Node<T> current = head;
		for (int j = 0; current != null && j < i; j++) {
			// Count our way up to desired element
			current = current.next;
		}
		if (current == null)
			throw new IndexOutOfBoundsException();
		if (current.prev != null)
			// Link prev's next to new next
			current.prev.next = current.next;
		else
			head = head.next;
		if (current.next != null)
			// Link next's prev to new prev
			current.next.prev = current.prev;
		else
			tail = tail.prev;
		size--;
		return current.data;
	}

	/**
	 * Create a forward iterator for this list.
	 */
	public Iterator<T> iterator() {
		// The Conductor object can walk this list
		// forward, front to back. Each time
		// .next() is called, the Conductor
		// produces one more piece of data,
		// starting with head and ending with tail
		return new Conductor<T>(head);
	}
	public Iterator<T> descendingIterator() {
		// Walk the list backward, back to front. Each time .next() is called, the Conductor
		// produces one more piece of data, starting with tail and ending at the head
		return new BackwardConductor<T>(tail);
	}
	public int size () {
		return size;
	}

	public void reverse () {
//		// use temp variable to hold last value while resetting; can also be recursive (base case: while n > middle)
//		int placeholder = 0;
//		int n = size - 1;
//		int middle = size / 2;
//		int swap = 0;
//		while (n >= middle) { 
//			placeholder = i[n]; 
//			tail = i[swap];
//			head = placeholder;
//			n--;
//			swap++;
//		}
		//return;
	}

	public boolean add (int i, T p) {
//		if (i < 0)
//			return false;
//		if (i > size / 2) {
//			//same, but use speedup }
//			else {
//				p = current;
//				current.next = current.prev.next;
//				current.prev.next = current; 
//				current.prev = current.next.prev;
//				next.prev = current;	
//			}
//			size++;
//		}
		return true;
	}
}
