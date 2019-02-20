package leetcode;

import leetcode.extra.ListNode;

/**
 * @author haogre
 * @description /10 进位
 * @date 2016年10月26日
 */
public class Problem002Solution {

    /**
     * my Solution 
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return null;
        }
            
        ListNode head = new ListNode(0);
        ListNode point = head;
        int carry = 0;
        while(l1 != null && l2!=null){
            int sum = carry + l1.val + l2.val;
            point.next = new ListNode(sum % 10);
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            point = point.next;
        }
        
        while(l1 != null) {
            int sum =  carry + l1.val;
            point.next = new ListNode(sum % 10);
            carry = sum /10;
            l1 = l1.next;
            point = point.next;
        }
        
        while(l2 != null) {
            int sum =  carry + l2.val;
            point.next = new ListNode(sum % 10);
            carry = sum /10;
            l2 = l2.next;
            point = point.next;
        }
        
        if (carry != 0) {
            point.next = new ListNode(carry);
        }
        return head.next;
    }
    
    /**
     * official Solution
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbersOffical(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
    
    public static void main(String[] args) {
    	Problem002Solution solution = new Problem002Solution();
    	ListNode l1 = new ListNode(3);
    	l1.next = new ListNode(4);
		l1.next = new ListNode(2);
    	
    	ListNode l2 = new ListNode(4);
    	l2 = new ListNode(6);
    	l2 = new ListNode(5);
    	ListNode result = solution.addTwoNumbers(l1, l2);
    	ListNode result2 = solution.addTwoNumbersOffical(l1, l2);
	}

}