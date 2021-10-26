public class stack{
    
    private class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
        }
    }

    private Node head,tail;
    private int size;

    public void push(int data){
        if(this.head==null){
            Node nw=new Node(data);
            head=tail=nw;

        }
        else{
            Node nw=new Node(data);
            nw.next=head;
            head=nw;
        }
        this.size++;
    }

    public void pop(){
        if(this.size==1){
            tail=null;
        }
        head=head.next;
        this.size--;
    }

}