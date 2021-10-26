public class user{
    public static void main(String[] args) throws Exception{
        stack stk=new stack(10);

        for(int i=0;i<10;i++){
            stk.push(i);
        }   

        stk.display();
    }

}