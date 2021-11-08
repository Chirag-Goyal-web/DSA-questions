import java.util.*;
public class The_Number_of_Weak_Characters_in_the_Game_leetcode_1996{
    public int numberOfWeakCharacters(int[][] arr) {
        
        Arrays.sort(arr,(a,b)->{
            if(a[0]!=b[0]){
                return a[0]-b[0];
            } 
            else{
                return b[1]-a[1];    
            }
        });
        
     
        int count=0;
        int len=arr.length;
        int max=arr[len-1][1];
        
        for(int i=len-1;i>=0;i--){
            if(max>arr[i][1]){
                count++;
            }
            else{
                max=arr[i][1];
            }
        }
        
        return count;
    }
}