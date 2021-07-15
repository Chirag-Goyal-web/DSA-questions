public class Verify_Preorder_Serialization_of_a_Binary_Tree{

    class Solution {
    
        static int ptr=0;
        
        public boolean isValidSerialization(String preorder) {
            
            ptr=0;
            
            String[] arr=preorder.split(",");
            
            boolean ans=helper(arr);
            
            if(ptr<arr.length){
                return false;
            }
            else{
                return ans;
            }
            
        }
        
        public boolean helper(String[] arr){
            
            if(ptr>=arr.length){
                return false;
            }
            
            else if(arr[ptr].equals("#")){
                ptr++;
                return true;
            }
            
            else{
                
                ptr++;
      
                return helper(arr)&&helper(arr);
                
            }
            
        }
        
        
    }
    
    public static void main(String[] args) {
        
    }
}