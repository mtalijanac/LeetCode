import java.util.LinkedList;
import java.util.List;

public class OddEvenLinkedList_328 {
	 // Definition for singly-linked list.
	static
	class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	
    public ListNode oddEvenList(ListNode head) {
    	if (head == null) return null;
    	if (head.next == null) return head;
    	
    	ListNode oddHead = head, oddTail = oddHead;
    	ListNode evenHead = head.next, evenTail = evenHead;
        ListNode tail = head.next.next;
        
        while (true) {
        	if (tail == null) break;
        	
        	// take odd, even pair, add them to lists
        	ListNode nextOddTail = tail;
        	ListNode nextEveTail = tail != null ? tail.next : null;
        	
        	if (nextOddTail != null) {
        		oddTail.next = nextOddTail;
        		oddTail = nextOddTail;
        	}
        	
        	if (nextEveTail != null) {
        		evenTail.next = nextEveTail;
        		evenTail = nextEveTail;
        	}
        	
        	// move tail for next iteration
        	tail = nextEveTail != null ? nextEveTail.next : null;
        }
        
        // join lists
        oddTail.next = evenHead;
        evenTail.next = null;
        return oddHead;
    }
    
    public static void main(String[] args) {
		ListNode n = new ListNode(5);
		n = new ListNode(4, n);
		n = new ListNode(3, n);
		n = new ListNode(2, n);
		n = new ListNode(1, n);
		
		OddEvenLinkedList_328 prog = new OddEvenLinkedList_328();
		prog.oddEvenList(n);
	}
}
