import java.util.Scanner;

public class ListStack implements IStack {
	
	private Node head;
	private Node top;
	private int stackSize;
	
	//스택 생성자
	public ListStack(int size) {
		head = null;
		top = null;
		this.stackSize = size;
	}
	

	@Override
	public boolean isEmpty() {
		//비어있는지 확인
		return (top == null);
	}

	@Override
	public boolean isFull() {
		//찬상태
		if(isEmpty()) {
			return false;
		}else {
			int nodeCount = 0;
			Node tempNode = head;
			
			while(tempNode.link != null) {
				++nodeCount;
				tempNode = tempNode.link;
			}
			return (this.stackSize-1 == nodeCount);
		}
	}

	@Override
	public void push(String data) {
		
		Node newNode = new Node(data);
		if(isFull()) {
			System.out.println("Stack is full");
			return;
		}
		else if(isEmpty()) {
			this.head = newNode;
			this.top = this.head;
		}else {
			Node tempNode = top;
			
			while(tempNode.link != null) {
				tempNode = tempNode.link;
			}
			tempNode.link = newNode;
		}
		
	}

	@Override
	public void delete() {
		Node preNode;
		Node tempNode;
		
		if(isEmpty()) {
			System.out.println("Stack is Empty!");
			return;
		}
		
		if(top.link == null) {
			head = null;
			top = null;
		}else {
			preNode = top;
			tempNode = top.link;
			while(tempNode.link != null) {
				preNode = tempNode;
				tempNode = tempNode.link;
			}
			preNode.link = null;
		}
	}
	
	public void invert() {
		Node prev = null;
		Node current = top;
		
		while(current != null) {
			Node next = current.link;
			current.link = prev;
			prev = current;
			current = next;
		}
		top = prev;
	}
	
	public void printListStack() {
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return;
		}else {
			Node tempNode = this.top;
			while(tempNode != null) {
				System.out.print(tempNode.getData() + " ");
				tempNode = tempNode.link;
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int stackSize = 10;
		String str = "";
		ListStack listStack = new ListStack(stackSize);
		
		boolean flag = true;
		while(flag) {
			System.out.println("number insert :");
			int a = sc.nextInt();
			
			if(a == 1) {
				//insert
				System.out.println("stack insert : ");
				String temp = sc.next();
				listStack.push(temp);
			}
			else if(a == 2){
				//delete
				System.out.println("stack delete ");
				listStack.delete();
			
			}
			else if(a == 3){
				//output
				System.out.println("stack print ");
				listStack.printListStack();
			}
			else if(a == 4){
				//invert
				System.out.println("stack invert ");
				listStack.invert();
			}
			else if(a == 5){
				//exit
				System.out.println("exit");
				flag = false;
			}else if(!Character.isDigit(a)) {
				System.out.println(" number insert!!!!");
			}
		}
	}

	
}
class Node{
	private String data;
	public Node link;
	
	public Node() {
		this.data = null;
		this.link = null;
	}
	
	public Node(String data) {
		this.data = data;
		this.link = null;
	}
	
	public Node(String data, Node link) {
		this.data = data;
		this.link = link;
	}
	
	public String getData() {
		return this.data;
	}
}

interface IStack{
	boolean isEmpty();
	boolean isFull();
	void push(String data);
	void delete();
	
	
}

