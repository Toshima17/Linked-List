public class PracticeQue{
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public Node findMergedPoint(Node head1, Node head2,Node temp1,Node temp2){
        while(temp1 != temp2){
        
            if(temp1 ==null){
                temp1=head2;
            }
            if(temp2== null){
                temp2=head1;
            }
            temp1=temp1.next;
            temp2=temp2.next;
        }
        if (temp1 == temp2){
            return temp1;
        }
        return null;
    }
    

//Delete N Nodes After M Nodes of a Linked List
    public void getNewLinkedList(Node head, int M , int N){
        Node curr= head ;
        
        while(curr!= null){
            // Step 1: Skip M nodes
            for(int count=1; count< M; count++){
                if(curr== null){
                    return;
                }
                curr=curr.next;
            }
            // Step 2: Delete next N nodes
            Node temp=curr.next;
            for( int count=1;count<=N;count++){
                if(temp==null){
                    return;
                }
                temp=temp.next;
            }
            // Step3= Link M-th node to the (N)th node after it
            curr.next= temp;
            //  Move curr to next part of list
            curr=temp;
        }
    }
//Method 2 - for delete N Nodes after M nodes .
    public static void deleteMnodesAfterNnodes(Node head, int M, int N){
        Node curr= head; 
        Node prev=null;
        int countN=N;
        int countM=M;
        Node store=null;
        boolean flag= true;
        while(curr!=null && N>0){
            //3rd step
            if(countM == 0){
                //bcs, Sare M traverse kr liye hai
                flag=false;
                //now we have to store lastNode traversed of M so that
                //we can make its link after deleting the N node to next node
                store= prev; //prev points to the last Node traversed
                //again make countM=M for the next part
                countM=M;
            }
            if(countN==0){
                //ab aage ke elements traverse krna hai
                flag=true;
                //bcs, curr points to the next node after deleting N nodes
                store.next= curr;
                //again make countN=N for the next part
                countN=N;
            }
            //1st step
            if(flag){
                countM--;
            }
            else{
                countN--;
            }
            //2nd step
            prev=curr;
            curr=curr.next;

            if (countN !=N){
                //N elements bache hi nhi dlt krne ko then, 
                store.next=null;
            }
        }
    }

    public void PrintLl(Node head){
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

    //Swaping of 2 keys in the List (keys: x= , y= ,)
    public void swapKeys(int x , int y, Node head){
        if(x==y){
            return;
        }
        Node prevX=null, currX=head;
        while(currX!=null & currX.data!=x){
            prevX=currX;
            currX=currX.next;
        }
        //by doing this (after all iterations)
        //prevX points to the Node before key X
        //currX points to the Node having key X

        Node prevY=null, currY=head;
        while(currY!=null & currY.data!=y){
            prevY=currY;
            currY=currY.next;
        }
        //by doing this (after all iterations)
        //prevY points to the Node before key y
        //currY points to the Node having key y

        //now we have to make links so that keys can swap
        if(prevX!=null){
            //means key pahli node nhi hai(bcs prev->null rehta)
            prevX.next=currY;
        }   else{
            //means key pahli node hai
            //i.e. prev= null
            head=currY;
        } 

        if(prevY!=null){
        //means key pahli node nhi hai(bcs prev->null rehta)
        prevY.next=currX;
        }   else{
            //means key pahli node hai
            //i.e. prev= null
            head=currX;
        }

        //Now, to fix the next links of the two nodes being swapped.
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;

        //1->2->3->4->5 to
        //1->4->3->2->5

        // 4 is still pointing to 5 (instead of 3).
        // 2 is still pointing to 3 (instead of 5).

    }
    public void oddEvenLl(Node head){
        
        Node prev=null;
        Node curr=head;
        while(curr!=null){
            prev=curr;
            curr=curr.next;
            Node temp=curr;
            if(curr.data % 2 != 0){
                
                temp.data=curr.data;
            }
            else if(curr.data %2 == 0){
                prev.data=curr.data;
                
            }
            else{
                curr.data=temp.data;
            }
            
        }
    }

    public static void main(String[] args){
        PracticeQue list = new PracticeQue();
        // Node head1, head2;
        // head1 = new Node(1);
        // head2 = new Node(6);
        // Node temp1=head1;
        // Node temp2=head2;
        // Node newNode = new Node(7);
        // head2.next = newNode;
        // newNode = new Node(8);
        // head2.next.next = newNode;
        // newNode = new Node(3);
        // head1.next = newNode;
        // head2.next.next.next = newNode;
        // newNode = new Node(4);
        // head1.next.next = newNode;
        
        // newNode = new Node(5);
        // head1.next.next.next = newNode;
        // head1.next.next.next.next = null;

        // Node mergedPoint= list.findMergedPoint(head1, head2, temp1, temp2);
        // if(mergedPoint==null){
        //     System.out.println("list is empty");
        // }
        // else{
        //     System.out.println("merged point is: "+mergedPoint.data);
        // }

        Node head=new Node(1);
        Node newNode=new Node(2);
        head.next= newNode;
        newNode = new Node(3);
        head.next.next = newNode;
        newNode = new Node(4);
        head.next.next.next = newNode;
        newNode = new Node(5);
        head.next.next.next.next = newNode;
        newNode = new Node(6);
        head.next.next.next.next.next= newNode;
        newNode = new Node(7);
        head.next.next.next.next.next.next = newNode;
        newNode = new Node(8);
        head.next.next.next.next.next.next.next = newNode;

        // list.PrintLl(head);
        // int M=2, N=2;
        // list.getNewLinkedList(head, M, N);
        // list.PrintLl(head);


        // list.PrintLl(head);
        // int x=2, y=4;
        // list.swapKeys(x,y,head);
        // list.PrintLl(head);
        // list.swapKeys(3,7,head);
        // list.PrintLl(head);

        // list.oddEvenLl(head);
        // list.PrintLl(head);

        list.PrintLl(head);
        int M=2, N=3;
        deleteMnodesAfterNnodes(head,  M,  N);
        list.PrintLl(head);
    }   



}   
