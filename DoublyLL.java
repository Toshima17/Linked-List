public class DoublyLL {
    public static class Node{
        int data; 
        Node next;
        Node prev;
        Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    //add
    public static void addFirst(int data){
        Node newNode= new Node(data);
        size++;
        if(head==null){
            head = tail = newNode;
            return;
        }
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
        
    }
    //remove
    public static int removeFirst(){
        if(head==null){
            System.out.println("List is empty");
            return Integer.MIN_VALUE;
        }
        if(head.next==null){
            int val=head.data;
            head=tail= null;
            size=0;
            return val;
        }
        int val=head.data;
        size--;
        head=head.next;
        return val;
    }
    public static void reverse(){
        Node prev=null;
        Node curr=head;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            curr.prev=next;
            
            prev=curr;
            curr=next;
            
        }
        head=prev;
    }
    public static void printDl(){
        Node temp=head;
        System.out.print("null"+ "<->");
        while(temp!= null){
            System.out.print(temp.data+"<->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static void main(String args[]) {
        DoublyLL dl = new DoublyLL();
        dl.addFirst(2);
        dl.addFirst(3);
        dl.addFirst(4);
        dl.printDl();
        // System.out.println("removed value="+dl.removeFirst());
        dl.reverse();
        dl.printDl();

    } 
}
