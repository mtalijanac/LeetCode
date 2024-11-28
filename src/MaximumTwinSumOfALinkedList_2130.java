public class MaximumTwinSumOfALinkedList_2130 {
	 // Definition for singly-linked list.
	static
	class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
    public int pairSum(ListNode head) {
    	if (head == null) return 0;
    	
    	int size = 0;
        for (ListNode n = head; n != null; n = n.next) size++;
        
        int half = size / 2;
        int[] sums = new int[half];
        
        ListNode iterator = head;
        for (int idx = 0; idx < half; idx++) {
        	sums[idx] = iterator.val;
        	iterator = iterator.next;
        }
        
        int max = head.val;
        for(int ridx = 0; ridx < half; ridx++) {
        	int rVal = iterator.val;
        	iterator = iterator.next;
        	int lVal = sums[sums.length - ridx - 1];
        	max = Math.max(max, rVal + lVal);
        }
        
        return max;
    }
    
    public static void main(String[] args) {
    	ListNode n = new ListNode(1);
    	n = new ListNode(2, n);
    	n = new ListNode(4, n);
    	n = new ListNode(5, n);
		
		int res = new MaximumTwinSumOfALinkedList_2130().pairSum(n);
		System.out.println(res);
	}
}
