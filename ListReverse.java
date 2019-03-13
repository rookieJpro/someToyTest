package test;



public class ListReverse {
	public static class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	 }
	
	public ListNode reverse(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		ListNode ph = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return ph;
	}
	public static void main(String[] args){
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode forth = new ListNode(4);
		first.next = second;
		second.next = third;
		third.next = forth;
		ListNode p = first;
		while(p!=null){
		    System.out.println(p.val);
		    p = p.next;
		}
		ListReverse test = new ListReverse();
		ListNode result = test.reverse(first);
		System.out.println("result is : ");
		while(result!=null){
		    System.out.println(result.val);
		    result = result.next;
		}
	}
}
