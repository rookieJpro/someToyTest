package test;

import test.ListReverse.ListNode;

/*
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
 */

public class reverseKGroup {
	class Solution {
	    public ListNode reverseKGroup(ListNode head, int k) {
	        ListNode p = head;
	        ListNode p1 = head;
	        int i;
	        for(i=0;i<k;i++){
	            p = p1.next;
	            p1 = p1.next;
	        }
	        ListNode q = reverse(head,p);
	        return q;
	        
	    }
	    public ListNode reverse(ListNode head,ListNode end){
	        if(head==end || head.next==end){
	            return head;
	        }
	        ListNode ph = reverse(head.next,end);
	        head.next.next = head;
	        head.next = end;
	        return ph;
	    }
	}
}
