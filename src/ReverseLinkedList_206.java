
public class ReverseLinkedList_206 {
	 // Definition for singly-linked list.
	static
	class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	public ListNode reverseList(ListNode head) {
    	if (head == null) return null;
    	if (head.next == null) return head;
    	
    	ListNode left = null;
    	ListNode center = head;
    	ListNode right = head.next;
    	
    	while (true) {    		
    		center.next = left;
            if (right == null) break;
    		left = center;
    		center = right;
    		right = center.next;
    	}
    	return center;
    }
    
}
