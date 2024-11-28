public class DeleteTheMiddleNodeOfALinekdList_2095 {
	 // Definition for singly-linked list.
	static
	class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
    public ListNode deleteMiddle(ListNode head) {
    	if (head == null) return null;
    	if (head.next == null) return null;
    	
        int size = 0;
        for (ListNode n = head; n != null; n = n.next) size++;
        
        int middleIndex = size / 2;
        ListNode cur = head, last = null;
        for (int i = 0; i < middleIndex + 1; i++) {
        	 if (i == middleIndex) {
        		 last.next = cur.next;
        		 break;
        	 }
        	 last = cur;
        	 cur = cur.next;
        }
     
        return head;
    }
}
