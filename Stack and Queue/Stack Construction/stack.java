import java.util.EmptyStackException;

public class stack{
    
    private int tos;
    private int MaxCapacity;
    private int NoOfElemenst;
    private int[] arr;

    stack(int size){
        initialize(size);
    }
    
    stack(){
        this(10);
    }
    
    protected void initialize(int size){
        this.NoOfElemenst=0;
        this.MaxCapacity=size;
        this.arr=new int[this.MaxCapacity];
        this.tos=-1;
    }

    public void push(){

    }

    public int peek(){
        if(this.NoOfElemenst==0){
            throw new EmptyStackException("Stack is empty");
        }
        else{
            
        }
    }

    public int pop(){
        return 0;
    }

}