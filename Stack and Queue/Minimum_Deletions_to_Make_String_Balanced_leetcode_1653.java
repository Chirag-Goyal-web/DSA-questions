public class Minimum_Deletions_to_Make_String_Balanced_leetcode_1653.java{
    public int minimumDeletions(String s) {
        int len=s.length()-1;
        int countA=0;
        int min=0;
        
        for(int i=len;i>=0;i--){
            if(s.charAt(i)=='a'){
                countA++;
            }
            else{
                min++;
            }
            
            min=Math.min(countA,min);
        }
        
        return min;
    }
}