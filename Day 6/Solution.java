class Solution {
      public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val;this.next = null; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
     
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = head;
        int count = 0;
        boolean shift = true;
        ListNode s = head;
        // last group node reference
        ListNode lgn = null;

        while (head != null) {
            count++;
            if (count == k) {
                ListNode temp = revList(s, head);
                
                if (shift) {
                    newHead = temp;
                    shift = false;
                    lgn = s;
                }
                // else{
                //     lgn.next = s;
                //     lgn = s;
                // }                
                s = head.next;
                System.out.println("Start = "+s.val+" End = "+head.val);
                count = 0;
            }
            head = head.next;
        }
        return newHead;
    }

    public static ListNode revList(ListNode s, ListNode e) {
        ListNode current = s;
        ListNode nll = s;
        ListNode prev = e.next;
        while (nll != e) {
            nll = current.next;
            current.next = prev;
            prev = current;
            current = nll;
        }
        current.next = prev;
        return current;
    }

    static void printlist(ListNode head){
        if(head==null){
            System.out.println();
            return;
        }
        System.out.print(head.val+" ");
        printlist(head.next);
    }
    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        ListNode B = new ListNode(2);
        A.next = B;
        ListNode C = new ListNode(3);
        B.next = C;
        ListNode D = new ListNode(4);
        C.next = D;
        ListNode E = new ListNode(5);
        D.next = E;
        E.next = null;


        printlist(reverseKGroup(A, 2));






    }
}