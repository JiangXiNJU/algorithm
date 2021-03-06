package collections.linkedList;

/**
 * Created by cshuo on 2017/8/11
 */
public class MergeSort {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        // 快慢指针找中间节点
        ListNode prev = null, slow = head, fast = head;
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        // 递归处理左右部分.
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        //归并
        return merge(l1, l2);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0), h = head;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                h.next = l1;
                l1 = l1.next;
            } else {
                h.next = l2;
                l2 = l2.next;
            }
            h = h.next;
        }
        if(l1 != null) h.next = l1;
        if(l2 != null) h.next = l2;
        return head.next;
    }
}
