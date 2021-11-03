import java.util.*;
public class sum_of_subarray_minimums_leetcode_907{
    public int sumSubarrayMins(int[] arr) {
        int len=arr.length;
        long mod=((long)1e9)+7;
        int[] left=new int[len];
        int[] right=new int[len];
        Stack<Integer> stk=new Stack<>();
    
        for(int i=len-1;i>=0;i--){
            while(stk.size()>0 && arr[stk.peek()]>=arr[i]){
                stk.pop();
            }
    
            right[i]=stk.size()>0?stk.peek():len;
            stk.push(i);
        }
        
        stk=new Stack<>();
        
        for(int i=0;i<len;i++){
            while(stk.size()>0 && arr[stk.peek()]>arr[i]){
                stk.pop();
            }
            
            left[i]=stk.size()>0?stk.peek():-1;
            stk.push(i);
        }
        
        long ans=0;
        
        for(int i=0;i<len;i++){
            long temp1=(i-left[i]);
            long temp2=(right[i]-i);
            long temp3=arr[i];
            ans=(ans+(temp1*temp2*temp3)%mod)%mod;
        }

        return (int)ans;
    }
}