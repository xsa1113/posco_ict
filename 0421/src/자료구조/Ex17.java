package 자료구조;

public class Ex17 {
	public static void main(String[] args) {
		LinkedList L = new LinkedList();
		System.out.println("(1) node 3 insert to empty list");
		L.insertLastNode("mon");
		L.insertLastNode("thu");
		L.insertLastNode("wed");
		L.printList();
		
		System.out.println("(2) fri node insert to wed node behind ");
		ListNode pre = L.searchNode("wed");
		if(pre == null)
			System.out.println("search fail >> looking for not data");
		else {
			L.insertMiddleNode(pre,"fri");
			L.printList();
		}
		
		System.out.println("(3) list node to reverse");
		L.reverseList();
		L.printList();
		
		System.out.println("(4) list node of last node delete");
		L.deleteLastNode();
		L.printList();
		
	}

}

class LinkedList{
	private ListNode head;
	public LinkedList() {
		head = null;
	}
	public void insertMiddleNode(ListNode pre, String data) {
		ListNode newNode = new ListNode(data);
		newNode.link = pre.link;
		pre.link = newNode;
	}
	public void insertLastNode(String data) {
		ListNode newNode = new ListNode(data);
		if(head == null) {
			this.head = newNode;
		}else {
			ListNode temp = head;
			while(temp.link != null) temp = temp.link;
			temp.link = newNode;
		}
	}
	public void deleteLastNode() {
		ListNode pre, temp;
		if(head == null) return;
		if(head.link == null) {
			head = null;
		}else {
			pre = head;
			temp = head.link;
			while(temp.link != null) {
				pre = temp;
				temp = temp.link;
			}
			pre.link = null;
		}
	}
	
	public ListNode searchNode(String data) {
		ListNode temp = this.head;
		while(temp != null) {
			if(data == temp.getData())
				return temp;
			else temp = temp.link;
		}
		return temp;
	}
	public void reverseList() {
		ListNode next = head;
		ListNode current = null;
		ListNode pre = null;
		while(next != null) {
			pre =current;
			current = next;
			next = next.link;
			current.link = pre;
		}
		head = current;
	}
	public void printList() {
		ListNode temp = this.head;
		System.out.printf("L = (");
		while(temp != null) {
			System.out.printf(temp.getData());
			temp = temp.link;
			if(temp !=null) {
				System.out.printf(",");
			}
		}
		System.out.println(")");
	}
}

class ListNode{
	private String data; // data는 변경 못하게
	public ListNode link; // link는 변경 가능하게 
	
	public ListNode() {
		this.data = null;
		this.link = null;
	}
	
	public ListNode(String data) {
		this.data = data;
		this.link = null;
	}
	public ListNode(String data, ListNode link) {
		this.data = data;
		this.link = link;
	}
	
	public String getData() {
		return this.data;
	}
}
