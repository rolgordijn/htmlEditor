package algoritmen;

import java.util.Iterator;

/**
 * 
 * @author P. Cordemans
 *
 * Singly linked list
 *
 * @param <T> type of the parameter
 */
public class LinkedList<T> implements Iterable<T> {
	private Node head;
	private int size;
	
	/**
	 * Constructor of an empty list
	 */
	public LinkedList(){
		head = null;
		size = 0;
	}
	
	/**
	 * Constructor for a linked list with one element
	 * 
	 * @param element
	 */
	public LinkedList(T element){
		head = new Node(element);
		size = 1;
	}
	
	private LinkedList(Node node){
		head = node;
		size = count(node, 0);
	}
	
	/**
	 * Prepends the element to the linked list
	 * 
	 * @param element
	 */
	public void prepend(T element){
		Node newNode = new Node(element, head);
		head = newNode;
		size++;
	}
	
	/**
	 *  
	 * @return the head of the list
	 */
	public T first(){
		if(head == null) return null;
		return head.get();
	}
	
	/**
	 * 
	 * @return the last element of the list
	 */
	public T last(){
		return lastRecursive(head).get();
	}
	
	private Node lastRecursive(Node current){
		if(current.next() == null) return current;
		return lastRecursive(current.next());
	}
	
	/**
	 * 
	 * @return the number of elements in the linked list
	 */
	public int size(){
		return size;
	}
	
	/**
	 * 
	 * @return the linked list without the head element
	 */
	public LinkedList<T> tail(){
		return new LinkedList<T>(head.next());
	}
	
	/**
	 * 
	 * @return true if empty, false if the linked list contains elements
	 */
	public boolean isEmpty(){
		return size == 0;
	}
	
	/**
	 * Finds the element in the list
	 * @param element to find
	 * @return true if present in the list otherwise false
	 */
	public boolean find(T element){
		Node cursor = head;
		do{
			if(cursor.get().equals(element)) return true;
		}
		while(cursor.next() != null);
		return false;
	}
	
	private int count(Node current, int total){
		if(current == null) return total;
		return count(current.next(), ++total);
	}
	
	public Iterator<T> iterator(){
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements Iterator<T>{
		private Node index = head;
		@Override
		public boolean hasNext() {
			return index != null;
		}

		@Override
		public T next() {
			T element = index.get();
			index = index.next();
			return element;
		}
		
	}
	
	private class Node{
		private T element;
		private Node next;
		
		public Node(T element){
			this(element, null);
		}
		
		public Node(T element, Node next){
			this.element = element;
			this.next = next;
		}
		
		public T get(){
			return element;
		}
		
		public Node next(){
			return next;
		}
	}
}
