public class DynamicStack extends stack{

    DynamicStack(int size){
        super(size);
    }
    DynamicStack(){
        super();
    }

    @Override
    public void push(int val) throws Exception{
        if(super.capacity()==super.size()){
            int[] temp=new int[super.size()];
            int idx=super.size()-1;
            
            for(int i=idx;i>=0;i--){
                temp[i]=super.pop();
            }
            
            super.initialize(temp.length*2);
            
            for(int i=0;i<temp.length;i++){
                super.push(temp[i]);
            }
            
        }
        super.push(val);
    }
}