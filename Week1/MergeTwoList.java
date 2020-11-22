public class MergeTwoList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();//局部变量指向堆内存指针
        ListNode head = dummy;


        while(l1 != null && l2 != null){
            if(l1.val > l2.val) {
                head.next = l2; // 赋值给堆内存中的next
                head = head.next; //局部变量变为 堆内存中的指针地址
                l2 = l2.next;
            }else {
                head.next = l1; // 赋值给堆内存中的next
                head = head.next; //局部变量变为 堆内存中的指针地址
                l1 = l1.next;
            }
        }

        if(l1 != null){
            while(l1 != null){
                head.next = l1;
                head = head.next;
                l1 = l1.next;
            }
        }

        if(l2 != null){
            while(l2 != null){
                head.next = l2;
                head = head.next;
                l2 = l2.next;
            }
        }

        return dummy.next;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
