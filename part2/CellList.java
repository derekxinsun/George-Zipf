/*
 * Program introduction: linked list for cellphone.
 */
import java.util.NoSuchElementException;

public class CellList {
	
	public class CellNode{
		
		private CellPhone c;
		private CellNode next;	
		/**
		 * inner class CellNode
		 */
		public CellNode()
		{
			c = null;
			next = null;
		}
		/**
		 * parameterized constructor
		 * @param c
		 * @param next
		 */
		public CellNode(CellPhone c, CellNode next)
		{
			this.c = c;
			this.next = next;
		}
		/**
		 * copy constructor
		 * @param cn
		 */
		public CellNode(CellNode cn)
		{
			this.c = new CellPhone(cn.c.getSerialNum(),cn.c.getBrand(),cn.c.getYear(),cn.c.getPrice());
			this.next = cn.next;
		}
		/**
		 * clone method
		 */
		public CellNode clone() {
			return new CellNode(this);
		}
		/**
		 * getters and setters
		 * @return
		 */
		public CellPhone getC() {
			return c;
		}

		public void setC(CellPhone c) {
			this.c = c;
		}

		public CellNode getNext() {
			return next;
		}

		public void setNext(CellNode next) {
			this.next = next;
		}
		
	}
	
	private CellNode head;
	private int size;
	
	public CellNode getHead() {
		return head;
	}

	public void setHead(CellNode head) {
		this.head = head;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	/**
	 * default constructor
	 */
	public CellList() {
		head = null;
		size = 0;
	}
	/**
	 * copy constructor
	 * @param cl
	 */
	public CellList(CellList cl) {
		size = 0;
		if(cl.head == null) {
			head = null;
		}
		else{
			head = null;	
			CellNode t1, t2, t3;	
			t1 = cl.head;
			t2 = t3 = null;
			while(t1 != null) {
				if (head == null) {
					t2 = t1.clone();
					t2.next=null;
					head = t2;
					size++;
				}else {
						t3 = t1.clone();
						t3.next=null;
						t2.next = t3;
						t2 = t3;
						size++;
					}
				t1 = t1.next;
			}
			t2 = t3 = null; 
		}
	}
	
	public void addToStart(CellPhone cp) {
		head = new CellNode(cp, head);
		size++;
	}
	
	public void insertAtIndex(CellPhone cp, int i) throws NoSuchElementException {
		if(this.size==0) {
			throw new NoSuchElementException();
		}
		if(i>(size-1)||i<0) {
			throw new NoSuchElementException();
		}else if(i==0){
			addToStart(cp);
		}else{
			CellNode tB = findIndexBefore(i);
			tB.next = new CellNode(cp,tB.next);	
			size++;
		}
		
	}
	
	public void deleteFromIndex(int i) throws NoSuchElementException {
		if(this.size==0) {
			throw new NoSuchElementException();
		}
		if(i>(size-1)||i<0) {
			throw new NoSuchElementException();
		}else if(i==0){
			deleteFromStart();
		}else {
			CellNode tB = findIndexBefore(i);	
			tB.next = tB.next.next;
			size--;
		}
	}
	
	public void deleteFromStart() {
		if(head == null)
			throw new NoSuchElementException();
		else {
			head=head.next;
			size--;
		}
	}
	
	public void replaceAtIndex(CellPhone cp, int i) throws NoSuchElementException {
		if(this.size==0) {
			throw new NoSuchElementException();
		}
		if(i>(size-1)||i<0) {
			throw new NoSuchElementException();
		}else if(i==0){
			addToStart(cp);
			deleteFromIndex(1);
		}else {
			insertAtIndex(cp,i);	
			deleteFromIndex(i+1);
		}
	}
	/**
	 * this method will return a node of the list and has privacy leak, 
	 * the cellphone can be modified in that node, and the rest of the list can be wiped
	 * one way to improve this method is that return a copy of that node and next point to null.
	 * then nothing can be done to the list.
	 * @param sn
	 * @return
	 */
	public CellNode find(long sn){
		int ctr=0;
		CellNode t = head;
		while(t!= null){	
			ctr++;
			if (t.c.getSerialNum() == sn) {
				System.out.println("Interated " + ctr +" times.");
				return t;
			}
			t = t.next;
		}
		System.out.println("Interated " + ctr +" times.");
		return null;
	}

	public boolean contains(long sn) throws NoSuchElementException{
		if(this.size==0) {
			throw new NoSuchElementException();
		}
		if(find(sn)==null) {
			return false;
		}else {
			return true;
		}
	}
	
	public void showContents(){
		CellNode t = head;
		if(t==null)
			System.out.println("\nThere is nothing to display; list is empty." );
		else
			while(t!= null)
			{
				System.out.println(t.c + " ---> ");
				t = t.next;		
			}
		System.out.println("X");	
	}
	
	public boolean equals(CellList cl) {
		
		CellNode t=head;
		CellNode tcl=cl.head;
		if(t==null||tcl==null) {
			System.out.println("\nAt least one of the lists is empty." );
			return false;
		}
		
		if(size!=cl.size) {
			System.out.println("\nSize are different." );
			return false;
		}
		while(t.next!=null) {
			if(t.c.equals(tcl.c)) {
				t=t.next;
				tcl=tcl.next;
			}else {
				System.out.println("\nThe lists have different elements." );
				return false;
			}
		}
		System.out.println("\nTwo lists are the same." );
		return true;
	}
	
	
	
//	private void addAtEnd(CellPhone cp)
//	{
//		if(head == null)
//			head = new CellNode(cp, null);
//		else{
//			CellNode t = head;
//			while(t.next != null)
//				t = t.next;
//			t.next = new CellNode(cp, null);
//		}
//		size++;
//	}
//	
//	private void deleteFromEnd() throws NoSuchElementException{
//		if(head == null)
//			throw new NoSuchElementException();
//		else{
//			CellNode t = head;
//			while(t.next != null)
//				t = t.next;
//			t=null;
//			size--;
//		}
//	}
	
	private CellNode findIndexBefore(int i) throws NoSuchElementException{
		int currentIndex=0;
		CellNode t = head;
		if(head == null)
			throw new NoSuchElementException();
		else {
			while(currentIndex<i-1) {
			t=t.next;
			currentIndex++;
			}
		return t;
		}
		
	}
}
