class Node{
    int data;
    Node next;

    public Node(int new_data){
        data=new_data;
        next=null;
    }
}

public class ReversingALinkedList {
    public static void main(String[] args) {

        Node head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next=new Node(5);

        printList(head);
        System.out.println();
        head=reverseList(head);
        printList(head);
    }

    static void printList(Node node){
        while(node!=null){
            System.out.print(node.data+"->");
            node=node.next;
        }
        System.out.print("null");
    }

    static Node reverseList(Node head){
        Node temp=head,prev=null,next;
        while(temp!=null){
            next=temp.next;

            temp.next=prev;

            prev=temp;
            temp=next;
        }

        return prev;
    }
    
    
}
