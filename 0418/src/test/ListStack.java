package test;

import java.util.Scanner;
import java.util.Stack;

import org.w3c.dom.Node;

public class ListStack {
	public static void main(String[] args) {
		// 1.insert, 2.delete, 3.output, 4.invert, 5.exit
		System.out.print("number select : ");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		boolean flag = true;
		
		
		while(flag) {
			if(a == 1) {
				//insert
				String temp = sc.next();
				
				
			}
			else if(a == 2){
				//delete
			
			}
			else if(a == 3){
				//output
			}
			else if(a == 4){
				//invert
			}
			else if(a == 5){
				//exit
				System.out.println("exit");
				flag = false;
			}
		}
		
		
		
	}
	
	class Liststack<T> implements IList<T>{
		
		public class Node{
			T data;
			Node next;
			
			Node(T data){
				this.data = data;
			}
			
			Node(T data, Node next){
				this.data = data;
				this.next = next;
			}
		}
		
		private int size;
		private Node head;
		
		public Liststack() {
			this.size = 0;
			this.head = new Node(null);
		}

		@Override
		public void add(T t) {
			Node curr = this.head;
			while(curr.next != null) { // curr의 next가 null이면 뒤가 없다는것
				curr = curr.next;
			}
			
			Node node = new Node(t);
			curr.next = node;
			this.size++;
		}

		@Override
		public void insert(int index, T t) {
			if(index > this.size || index < 0) {
				// index와 size가 같으면 add랑 같음
				throw new IndexOutOfBoundsException();
			}
			Node prev = this.head;
			Node curr = prev.next;
			
			int i =0; 
			while(i++ < index) {
				prev = prev.next;
				curr = curr.next;
			}
			
			Node node = new Node(t, curr);
			prev.next = node;
			this.size++;
		}

		@Override
		public boolean delete(T t) {
			
			return false;
		}

		@Override
		public T get(int index) {
			
			return null;
		}

		@Override
		public boolean isEmpty() {
			
			return false;
		}

		@Override
		public void invert(int index, T t) {
			
			
		}

		@Override
		public int size() {
			
			return 0;
		}
		
	}

	interface IList<T> {
		// 1.insert, 2.delete, 3.output, 4.invert, 5.exit
		void add(T t);
		
		void insert(int index, T t);
		
		boolean delete(T t);
		
		T get(int index);
		
		boolean isEmpty();
		
		void invert(int index, T t); // invert
		
		int size();
		

	}

}





