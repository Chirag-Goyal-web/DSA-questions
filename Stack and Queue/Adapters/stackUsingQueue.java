import java.util.Queue;

public class stackUsingQueue{

    Queue<Integer> que=new LinkedList<>();
    
    public MyStack(){
        
    }
    
    public void push(int x){
        que.add(x);
    }
    
    public int pop(){
        int size=que.size();
        for(int i=0;i<size-1;i++){
            que.add(que.remove());
        }
        return que.remove();
    }
    
    public int top(){
        int size=que.size();
        int val=0;
        for(int i=0;i<size;i++){
            val=que.remove();
            que.add(val);
        }
        return val;
    }
    
    public boolean empty(){
        return que.size()==0;
    }

    public static void main(String[] args) {
        
    }
}