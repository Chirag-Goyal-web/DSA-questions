import java.util.EmptyStackException;

public class stack{
    
    private int tos;
    private int MaxCapacity;
    private int NoOfElements;
    private int[] arr;

    stack(int size){
        initialize(size);
    }
    
    stack(){
        this(10);
    }
    
    public void display() {
        for (int i = this.tos; i >= 0; i--) {
            System.out.print(this.arr[i] + " ");
        }
    }

    public int capacity() {
        return this.MaxCapacity;
    }

    public int size() {
        return this.NoOfElements;
    }

    protected void initialize(int size){
        this.NoOfElements=0;
        this.MaxCapacity=size;
        this.arr=new int[this.MaxCapacity];
        this.tos=-1;
    }

    private void overflowException() throws Exception{
        if(this.NoOfElements==this.MaxCapacity){
            throw new Exception("StackIsOverflow");
        }
    }

    private void underflowException() throws Exception{
        if(this.NoOfElements==0){
            throw new Exception("StackIsUnderflow");
        }
    }

    public void push(int val) throws Exception{
        overflowException();
        this.NoOfElements++;
        this.arr[++this.tos]=val;
    }

    public int peek() throws Exception{
        underflowException();
        return this.arr[this.tos];
    }

    public int pop() throws Exception{
        underflowException();
        this.NoOfElements--;
        return this.arr[this.tos--];
    }

}