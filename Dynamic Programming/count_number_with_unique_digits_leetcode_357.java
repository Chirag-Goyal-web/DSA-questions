public class count_number_with_unique_digits_leetcode_357{
    
    //Backtracking solution
    class Solution{
        public int countNumbersWithUniqueDigits(int n) {
            int ans=0;
            boolean[] visited=new boolean[10];
            
            n=(int)Math.pow(10,n);
            
            for(int i=1;i<=9;i++){
                visited[i]=true;
                ans+=helper(i,n,visited);
                visited[i]=false;
            }
            
            return ans+1;
        }
        
        public int helper(int cur,int n,boolean[] visited){
                
            if(cur>=n){
                return 0;
            }
            
            else{  
                int ans=0;
                
                for(int i=0;i<=9;i++){            
                    if(!visited[i]){
                        visited[i]=true;
                        ans+=helper(cur*10+i,n,visited);
                        visited[i]=false;
                    }
                }
            
                return ans+1;
            }        
        }
    }

    //Math solution
    class Solution_ {
    
        public int countNumbersWithUniqueDigits(int n) {    
            if(n==0){
                return 1;
            }    
            
            else{
                int ans=10;
                
                for(int i=2;i<=n;i++){
                    ans+=helper(i);
                }
                return ans;
            }
        }
        
        public int helper(int n){
            int ans=9;
            int no=9;
            
            for(int i=1;i<n;i++){
                ans*=no;
                no--;
            }
            
            return ans;
        }
        
    }

}