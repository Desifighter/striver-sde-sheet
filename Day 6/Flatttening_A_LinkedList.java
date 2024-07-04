
//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node bottom;

    Node(int d) {
        data = d;
        next = null;
        bottom = null;
    }
}

public class Flatttening_A_LinkedList {
    Node head;

    void printList(Node node) {
        // Node temp = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.bottom;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Flatttening_A_LinkedList list = new Flatttening_A_LinkedList();
        while (t > 0) {
            int N = sc.nextInt();
            int arr[] = new int[N];
            for (int i = 0; i < N; i++)
                arr[i] = sc.nextInt();

            Node temp = null;
            Node tempB = null;
            Node pre = null;
            Node preB = null;
            int flag = 1;
            int flag1 = 1;
            for (int i = 0; i < N; i++) {
                int m = arr[i];
                m--;
                int a1 = sc.nextInt();
                temp = new Node(a1);
                if (flag == 1) {
                    list.head = temp;
                    pre = temp;
                    flag = 0;
                    flag1 = 1;
                } else {
                    pre.next = temp;
                    pre = temp;
                    flag1 = 1;
                }

                for (int j = 0; j < m; j++) {
                    int a = sc.nextInt();
                    tempB = new Node(a);
                    if (flag1 == 1) {
                        temp.bottom = tempB;
                        preB = tempB;
                        flag1 = 0;
                    } else {
                        preB.bottom = tempB;
                        preB = tempB;
                    }
                }
            }
            // list.printList();
            GfG g = new GfG();
            Node root = g.flatten(list.head);
            list.printList(root);

            t--;
        }
    }
}
// } Driver Code Ends

/*
 * Node class used in the program
 * class Node
 * {
 * int data;
 * Node next;
 * Node bottom;
 * 
 * Node(int d)
 * {
 * data = d;
 * next = null;
 * bottom = null;
 * }
 * }
 */
/*
 * Function which returns the root of
 * the flattened linked list.
 */
class GfG {
    Node flatten(Node root) {
        // Your code here
        Node sortedList = null;
        Node lastNode = null;

        //for moving horizontal in linked list
        while (root != null) {
            Node temp = root;

            // for moving vertical
            while (temp != null) {
                if (sortedList == null) {
                    sortedList = new Node(temp.data);
                    lastNode = sortedList;
                } else {
                    // add new nodes in new at currrect point
                    Node last_node_ka_ref = lastNode;
                    while (lastNode != null) {
                        if (temp.data >= lastNode.data) {
                            break;
                        }
                        lastNode = lastNode.next;
                    }
                    Node newNode = new Node(temp.data);
                    if (last_node_ka_ref == lastNode) {
                        newNode.next = lastNode;
                        lastNode.bottom = newNode;
                        lastNode = newNode;
                    } else if (lastNode == null) {
                        newNode.next = sortedList;
                        sortedList = newNode;
                    } else {
                        
                        
                        lastNode.bottom.next = newNode;
                        newNode.bottom = lastNode.bottom;
                        newNode.next = lastNode;
                        lastNode.bottom = newNode;
                        lastNode = last_node_ka_ref;
                    }
                }

                temp = temp.bottom;
            }
            root = root.next;

        }
        return sortedList;
        
    }
}