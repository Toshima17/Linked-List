

public  class LinkedList {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    //in a LL there's single head and tail
    public static Node head;
    public static Node tail;
    public static  int size; //java byDefault size = 0;

    public void addFirst(int data){
       //step1= create NewNode
       Node newNode = new Node(data);
        size++;
        if(head==null){ // if, ll Khali 
            head = tail = newNode;
            return ;
        }
       //step2= NewNode's next= Head 
       newNode.next = head; //link

       //step3= Head= NewNode 
       head = newNode;
       
    }

    public void addLast(int data){
       //step1= create NewNode
       Node newNode = new Node(data);
        size++;
        if(head==null){ // if, ll Khali 
            head = tail = newNode;
            return ;
        }
        //step2= tail's next= newnode
        tail.next = newNode ;

       //step3= tail<= NewNode 
        tail = newNode;
        
    }
    public void PrintLl(){
        if( head == null){
            System.out.println(" ll is empty");
            return;
        }
        Node temp=head;
        System.out.print("linked list is= ");
        while(temp!=null){
            System.out.print(temp.data +" -> ");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public void addMiddle(int index, int data)  {
        Node newNode= new Node(data);
        Node temp= head;
        int i=0;
        if(index==0){
            addFirst(data);
            return;
        }
        size++;
        while(i<index-1){
            temp=temp.next;
            i++;
        }
        newNode.next=temp.next;
        temp.next=newNode;
        
    }
    public static int removeFirst(){
        if(size==0){
            System.out.println("List is empty");
            return Integer.MIN_VALUE;
        }
        if(size==1){
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
    public static int removeLast(){
        if(size==0){
            System.out.println("List is empty");
            return Integer.MIN_VALUE;
        }
        if(size==1){
            int val=head.data;
            head=tail= null;
            size=0;
            return val;
        }
        Node prev=head; //or temp
        //we have to go to second last => so loop
        for(int i=0;i<size-2;i++){
            prev=prev.next;
        }
        int val=prev.next.data; //tail
        prev.next= null;
        tail=prev;
        size--;
        return val;
    }

    public int itearativeSearch(int key){
        Node temp=head;
        int i=0;
        while(temp!= null){
            if(temp.data==key){
                return i ;
            }
            temp=temp.next;
            i++;
            
        }
    //key Not found Case
    return -1;
    }

    public int RecursiveSearch(int key, int i, Node head ){
        
        //base Case
        if(head==null){
            return -1;

        }
        if(head.data==key){
            return i;
        }
        return RecursiveSearch(key, i+1, head.next);
    }

    public static void reversLl(){
        Node prev= null;
        Node curr= tail = head;
        Node next;

        while(curr!= null){
            next=curr.next;
            curr.next=prev;
            prev= curr; // jo pahle curr the wo ab prev bn jaega
            curr= next;
        }
        head= prev;
    }
     
    public static void deleteNthNodeFromEnd(int N){
        //1st calculate size
        int sz=0;
        Node temp=head;
        while(temp!= null){
            temp=temp.next;
            sz++;
        }

        //if head hi delete krna ho (last se n=size= head)
        if(N==sz){
            head=head.next;
            return;
        }

        //size-n tk jana hai which point to prev
        // i=1 bcs i=0 = head ke liye already done and prev=head=(i=0);
        int i=1; 
        int indexToFind=sz-N;
        Node prev=head ; //initially
        while(i< indexToFind){
            prev= prev.next;
            i++;
        }
        //now we got our prev node which is before deleted node
        prev.next=prev.next.next;
        return;
    }

    // public static void isPalindrome(){
    //     Node start=head;
    //     int i=0;
    //     reversLl();
    //     Node end=head;
    //     int sz=0;
    //     Node temp=head;
    //     while(temp!= null){
    //         temp=temp.next;
    //         sz++;
    //     }
    //     while(i<=sz/2){
            
            
    //         if(start.data!=end.data){
    //             System.out.println("linked list is not palindrome");
    //         }
    //         else{
    //             System.out.println("linked list is palindrome");
    //         }
    //         start=start.next;
    //         i++;
            
    //         end=end.next;

    //     }
    // } 

    // md-2
    // 1st calculate mid using ( SLOW-FAST Approach.)
    public Node findMid(Node head){
        Node slow= head;
        Node fast=head;
        while(fast != null && fast.next != null){
             slow=slow.next; //+1;
             fast= fast.next.next; //+2;
        }
        return slow; //slow is my midNode;
    }

    public boolean checkPalindrome(){
        //is ll is empty or having 1 node .
        if(head== null || head.next==null){
            return true;
        }
        //step1= find mid
        Node midNode= findMid(head);

        //step2=reverse second half
        Node prev=null;
        Node curr=midNode=tail;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
     
         Node right= prev;// 2nd half ka head(prev denotes)
         Node left= head; // 1st half ka head   
        //step3= check first half and second half
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            //always
            left= left.next;
            right= right.next;
        }
        //if there is not any misMatching value
        return true;
    }
    
    public static boolean IsCycle(){
        Node slow=head;
        Node fast= head;
        while(fast!=null && fast.next!= null){
            slow=slow.next;
            fast= fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    public static void removeCycle(){
        //detect cycle
        Node slow=head;
        Node fast= head;
        boolean cycle=false;
        while(fast!=null && fast.next!= null){
            slow=slow.next;
            fast= fast.next.next;
            if(slow==fast){
                cycle=true;
                break;
            }
        }
        if(cycle=false){
            return;
        }
        //find meeting point
        slow=head;
        Node prev=null; //last node of cycle
        while(slow!= fast){
            prev=fast;
            slow=slow.next;
            fast=fast.next;
        }
        //remove cycle -> last.next= null krna hai
        prev.next=null;
    }
    private static Node getMid(Node head){
        Node slow=head;
        Node fast=head.next;
        while(fast!= null && fast.next!= null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;//mid node
    }  
    private static Node merge(Node head1,Node head2){
        Node mergedLl=new Node(-1);
        Node temp=mergedLl;
        while(head1 != null && head2 != null ){
            if(head1.data <= head2.data){
                //inserting into new ll
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }
            else{
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
        }
        //loop to insert remaining elements into newll
        while(head1 != null){
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;
        }
        while(head2 != null){
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;
        }
        return mergedLl.next;
        // mergedLL.next → Node(1)
        // Node(1).next → Node(2)
        // Node(2).next → Node(3)
        // Node(3).next → Node(4)
        // in linked lists, the entire list is connected through .next references
        // Dummy node is just a helper to simplify code. We skip it by returning mergedLL.next.
        //so that's why mergedLl.next returns the whole linked list
        //  we do not need to write mergedLl.next; mergedLl.next.next; ..... (in Ll)
    } 
    public static Node mergeSort(Node head){
        //base case when list is empty or having only 1 node
        if(head==null || head.next == null){
            return head;
        }
        //mean list is already sorted

        //find mid
        Node mid=getMid(head);
        //left and right=> Merge sort
        Node rightHead=mid.next;
        mid.next=null;
        Node newLeft=mergeSort(head);
        Node newRight=mergeSort(rightHead);

        //mrge
        return merge(newLeft, newRight);

    }

    public static void zigZag(){
        //find mid
            Node mid= getMid(head);
        //reverse 2nd half
            Node curr= mid.next;
            mid.next=null;
            Node prev=null;
            Node next;
            while(curr!=null){
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
            Node head2= prev;
        // alternate merging (1->5->2->4->3)
        Node leftHead= head;
        Node rightHead= head2;
        Node nextL, nextR;
        while(leftHead != null && rightHead !=null){
            nextL=leftHead.next;
            leftHead.next=rightHead;
            nextR = rightHead.next;
            rightHead.next=nextL;

            rightHead=nextR;
            leftHead=nextL;
        }
        
    }
    public static void main(String[] args) {
        // LinkedList li= new LinkedList();
        //Using methods above not this
        //initializing head data and next
        // li.head= new Node(1);
        // li.head.next=new Node(2); //next <-node-> data=2 ka address hai 
        // li.addFirst(2);
        // li.addFirst(1);
        // li.addLast(2);
        // li.addLast(2);
        // // li.addLast(3);
        // // li.addLast(4);
        // // li.addLast(5);
        // // li.addLast(6);
        // // li.PrintLl();
        // // li.addMiddle(2, 10);
        // li.PrintLl();
        // // System.out.println("Size of linked list = "+ li.size);
        // // int a =li.removeFirst();
        // // System.out.println("removed element="+a);
        // // li.PrintLl();

        // // int b =li.removeLast();
        // // System.out.println("removed element="+b);
        // // li.PrintLl();
        // // System.out.println("Size of linked list = "+ li.size);
        
        // // int key=1;
        // // int num = li.itearativeSearch(key);
        // // System.out.println(key+" is found at index= " + num);
         
        // // int key1=2 ;
        // // int num2 = li.RecursiveSearch(key1,0,head);
        // // System.out.println(key1+" is found at index= " + num2);
        
        // li.reversLl();
        // li.PrintLl();
        // li.deleteNthNodeFromEnd(6);
        // li.PrintLl();
        // System.out.println("is the list palindrome? "+"-"+li.checkPalindrome());
        // head=new Node(1);
        // Node temp=new Node(2);
        // head.next=temp;
        // head.next.next=new Node(3);
        // head.next.next.next=temp;
        // //1->2->3->1

        // System.out.println(IsCycle());
        // removeCycle();
        // System.out.println(IsCycle());
        LinkedList ll= new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
         ll.addLast(6);
        //1->2->3->4->5->6
        ll.PrintLl();
        // ll.head=mergeSort(ll.head);
        ll.zigZag();
        ll.PrintLl();
    }
}

