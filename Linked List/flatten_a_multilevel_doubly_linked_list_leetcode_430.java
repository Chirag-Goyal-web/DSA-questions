public class flatten_a_multilevel_doubly_linked_list_leetcode_430{

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node flatten(Node head) {
        merge(head);
        return head;
    }
    
    public Node merge(Node head){
        
        Node prev=null;
        
        while(head!=null){
            if(head.child!=null){
                
                Node forw=head.next;
                
                Node lastNode=merge(head.child);
                
                head.next=head.child;
                head.child.prev=head;
                head.child=null;
                lastNode.next=forw;
                
                if(forw!=null){
                    forw.prev=lastNode;
                }
                
                prev=lastNode;
                head=forw;
            }
            
            else{
                prev=head;
                head=head.next;
            }
        }
        
        return prev;
    }

}