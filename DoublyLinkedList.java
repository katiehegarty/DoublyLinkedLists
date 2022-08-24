package Lab;

// -------------------------------------------------------------------------
/**
 *  This class contains the methods of Doubly Linked List.
 *
 *  @author  
 *  @version 09/10/18 11:13:22
 */

/**
 * Class DoublyLinkedList: implements a *generic* Doubly Linked List.
 * 
 * @param <T> This is a type parameter. T is used as a class name in the
 *        definition of this class.
 *
 *        When creating a new DoublyLinkedList, T should be instantiated with an
 *        actual class name that extends the class Comparable. Such classes
 *        include String and Integer.
 *
 *        For example to create a new DoublyLinkedList class containing String
 *        data: DoublyLinkedList<String> myStringList = new
 *        DoublyLinkedList<String>();
 *
 *        The class offers a toString() method which returns a comma-separated
 *        sting of all elements in the data structure.
 * 
 *        This is a bare minimum class you would need to completely implement.
 *        You can add additional methods to support your code. Each method will
 *        need to be tested by your jUnit tests -- for simplicity in jUnit
 *        testing introduce only public methods.
 */
class DoublyLinkedList<T extends Comparable<T>> {

	/**
	 * private class DLLNode: implements a *generic* Doubly Linked List node.
	 */
	private class DLLNode {
		public final T data; // this field should never be updated. It gets its
								// value once from the constructor DLLNode.
		public DLLNode next;
		public DLLNode prev;

		/**
		 * Constructor
		 * 
		 * @param theData  : data of type T, to be stored in the node
		 * @param prevNode : the previous Node in the Doubly Linked List
		 * @param nextNode : the next Node in the Doubly Linked List
		 * @return DLLNode
		 */
		public DLLNode(T theData, DLLNode prevNode, DLLNode nextNode) {
			data = theData;
			prev = prevNode;
			next = nextNode;
		}
	}

	// Fields head and tail point to the first and last nodes of the list.
	private DLLNode head, tail;

	/**
	 * Constructor of an empty DLL
	 * 
	 * @return DoublyLinkedList
	 */
	public DoublyLinkedList() {
		head = null;
		tail = null;
	}

	/**
	 * Tests if the doubly linked list is empty
	 * 
	 * @return true if list is empty, and false otherwise
	 *
	 *         Worst-case asymptotic running time cost: TODO if statement constant
	 *         x2
	 *
	 *         Justification: TODO
	 */
	public boolean isEmpty() {
		if ((head == null) && (tail == null)) {
			return true;
		} else
			return false;
	}

	/**
	 * Inserts an element in the doubly linked list
	 * 
	 * @param pos  : The integer location at which the new data should be inserted
	 *             in the list. We assume that the first position in the list is 0
	 *             (zero). If pos is less than 0 then add to the head of the list.
	 *             If pos is greater or equal to the size of the list then add the
	 *             element at the end of the list.
	 * @param data : The new data of class T that needs to be added to the list
	 * @return none
	 *
	 *         Worst-case asymptotic running time cost: TODO
	 *
	 *         Justification: TODO
	 */
	public void insertBefore(int pos, T data) {
		if (isEmpty()) {
			DLLNode newNode = new DLLNode(data, null, null);
			head = newNode;
			tail = head;

		}

		else if (pos < 1) {
			// DLLNode to make new node to put at head of list

			DLLNode second = head;
			DLLNode first = new DLLNode(data, null, second);
			second.prev = first;
			head = first;

		} else {
			DLLNode current = head;
			int index = 0;
			while (current.next != null) {
				if (index == pos - 1) {
					DLLNode newNode = new DLLNode(data, null, null);
					newNode.prev = current;
					newNode.next = current.next;
					if (current.next != null) {
						current.next.prev = newNode;
					}
					current.next = newNode;
					return;
				}
				index++;
				current = current.next;

			}
			DLLNode secondLast = tail;
			DLLNode last = new DLLNode(data, secondLast, null);
			secondLast.next = last;
			tail = last;
		}
		return;
	}

	/**
	 * Returns the data stored at a particular position
	 * 
	 * @param pos : the position
	 * @return the data at pos, if pos is within the bounds of the list, and null
	 *         otherwise.
	 *
	 *         Worst-case asymptotic running time cost: TODO
	 *
	 *         Justification: TODO
	 *
	 */
	public T get(int pos) {
		if (isEmpty()) {
			return null;
		} else if (pos >= 0) {
			DLLNode current = head;
			int index = 0;
			if (current.next == null && index == pos) {
				return current.data;
			} else {
				while (current.next != null) {
					if (pos == index) {
						return current.data;
					}
					current = current.next;
					index++;
				}

			}
		}
		return null;
	}

	/**
	 * Deletes the element of the list at position pos. First element in the list
	 * has position 0. If pos points outside the elements of the list then no
	 * modification happens to the list.
	 * 
	 * @param pos : the position to delete in the list.
	 * @return true : on successful deletion, false : list has not been modified.
	 *
	 *         Worst-case asymptotic running time cost: TODO
	 *
	 *         Justification: TODO
	 */
	public boolean deleteAt(int pos) {
		DLLNode current = head;
		int index = 0;
		while (current != null) {
			if(pos==0 && current.next == null && current.prev==null) {
				head=null;
				tail=null;
				return true;
			}
			else if (pos==0) {
				head=head.next;
				head.prev=null;
				return true;
			}
			else if (pos == index) {
				if (current.next != null) {
					current.next.prev = current.prev;
					current.prev.next = current.next;
					return true;
				}
				else if(current.next==null) {
					tail.prev.next=null;
					tail=tail.prev;
					return true;
				}
			}
			current = current.next;
			index++;
		}
		return false;
	}

	/**
	 * Reverses the list. If the list contains "A", "B", "C", "D" before the method
	 * is called Then it should contain "D", "C", "B", "A" after it returns.
	 *
	 * Worst-case asymptotic running time cost: TODO
	 *
	 * Justification: TODO
	 */
	public void reverse() {
		if (isEmpty()) {
			return;
		} else {
			DLLNode current = head;
			DLLNode temp=null;
			while (current != null) {
			temp = current.prev;
			current.prev=current.next;
			current.next=temp;
			current = current.prev;
			}
			if(temp!=null) {
				head=temp.prev;
			}
		}

		// unsure about this
	}

	/*
	 * { // not sure about this DLLNode current = head; int index = 0;
	 * while(current.next!=null) { current.next=current.prev;
	 * current.prev=current.next; index++; current = current.next; // if
	 * current.next now = current.prev, how to go on to next node? } }
	 */

	/**
	 * Removes all duplicate elements from the list. The method should remove the
	 * _least_number_ of elements to make all elements unique. If the list contains
	 * "A", "B", "C", "B", "D", "A" before the method is called Then it should
	 * contain "A", "B", "C", "D" after it returns. The relative order of elements
	 * in the resulting list should be the same as the starting list.
	 *
	 * Worst-case asymptotic running time cost: TODO
	 *
	 * Justification: TODO
	 */
	public void makeUnique() {
		DLLNode uniqueNode = head;
		DLLNode pointer =null;
		int index = 0;
		int index2 = 0;
		while (uniqueNode != null) {
			pointer=uniqueNode.next;
			index2=index+1;
			while (pointer != null) {
				if (uniqueNode.data.compareTo(pointer.data) == 0) {
					deleteAt(index2);
					pointer=uniqueNode;
					index2=index;
				}
				index2++;
				pointer = pointer.next;
			}
			index++;
			uniqueNode = uniqueNode.next;
		}
	}

	/*----------------------- STACK API 
	 * If only the push and pop methods are called the data structure should behave like a stack.
	 */

	/**
	 * This method adds an element to the data structure. How exactly this will be
	 * represented in the Doubly Linked List is up to the programmer.
	 * 
	 * @param item : the item to push on the stack
	 *
	 *             Worst-case asymptotic running time cost: TODO
	 *
	 *             Justification: TODO
	 */
	public void push(T item) {
		if (isEmpty()) {
			head = new DLLNode(item, null, null);
			tail=head;
		} else {
			DLLNode second = head;
			DLLNode first = new DLLNode(item, null, second);
			second.prev = first;
			head = first;
		}
	}

	/**
	 * This method returns and removes the element that was most recently added by
	 * the push method.
	 * 
	 * @return the last item inserted with a push; or null when the list is empty.
	 *
	 *         Worst-case asymptotic running time cost: TODO
	 *
	 *         Justification: TODO
	 */
	public T pop() {
		if (isEmpty()) {
			return null;
		} else {

			T item = get(0);
			deleteAt(0);
			return item;
			
		}
	}

	/*----------------------- QUEUE API
	 * If only the enqueue and dequeue methods are called the data structure should behave like a FIFO queue.
	 */

	/**
	 * This method adds an element to the data structure. How exactly this will be
	 * represented in the Doubly Linked List is up to the programmer.
	 * 
	 * @param item : the item to be enqueued to the stack
	 *
	 *             Worst-case asymptotic running time cost: TODO
	 *
	 *             Justification: TODO
	 */
	public void enqueue(T item) {
		push(item);
		// unsure
	}

	/**
	 * This method returns and removes the element that was least recently added by
	 * the enqueue method.
	 * 
	 * @return the earliest item inserted with an equeue; or null when the list is
	 *         empty.
	 *
	 *         Worst-case asymptotic running time cost: TODO
	 *
	 *         Justification: TODO
	 */
	public T dequeue() {
		if (isEmpty()) {
			return null;
		} else if(head==tail) {
			T item = tail.data;
			head = null;
			tail = null;
			return item;
		}
		else {
			T item = tail.data;
			tail.prev.next=null;
			tail=tail.prev;
			return item;
		}

	}

	/**
	 * @return a string with the elements of the list as a comma-separated list,
	 *         from beginning to end
	 *
	 *         Worst-case asymptotic running time cost: Theta(n)
	 *
	 *         Justification: We know from the Java documentation that
	 *         StringBuilder's append() method runs in Theta(1) asymptotic time. We
	 *         assume all other method calls here (e.g., the iterator methods above,
	 *         and the toString method) will execute in Theta(1) time. Thus, every
	 *         one iteration of the for-loop will have cost Theta(1). Suppose the
	 *         doubly-linked list has 'n' elements. The for-loop will always iterate
	 *         over all n elements of the list, and therefore the total cost of this
	 *         method will be n*Theta(1) = Theta(n).
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		boolean isFirst = true;

		// iterate over the list, starting from the head
		for (DLLNode iter = head; iter != null; iter = iter.next) {
			if (!isFirst) {
				s.append(",");
			} else {
				isFirst = false;
			}
			s.append(iter.data.toString());
		}

		return s.toString();
	}

	public static void main(String[] args) {
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(0, 1);
//	      testDLL.insertBefore(1,2);
//	      testDLL.insertBefore(2,3);
		System.out.println("list:" + testDLL.toString());
	}

}
