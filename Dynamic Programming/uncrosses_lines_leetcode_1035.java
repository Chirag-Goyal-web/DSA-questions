import java.util.*;
public class uncrosses_lines_leetcode_1035{

    //Memoization
    class Solution {
        public int maxUncrossedLines(int[] nums1, int[] nums2) {
            
            int[][] mem=new int[nums1.length][nums2.length];
            
            for(int i=0;i<nums1.length;i++){
                Arrays.fill(mem[i],-1);
            }
            
            return dp(nums1,nums2,0,0,mem);
            
        }
        
        public int dp(int[] nums1,int[] nums2,int idx1,int idx2,int[][] mem){
            
            if(idx1>=nums1.length || idx2>=nums2.length){
                return 0;
            }
            
            else if(mem[idx1][idx2]!=-1){
                return mem[idx1][idx2];
            }
            
            else{
                
                if(nums1[idx1]==nums2[idx2]){
                    int ans= 1+dp(nums1,nums2,idx1+1,idx2+1,mem);
                    mem[idx1][idx2]=ans;
                    return ans;
                }
                
                else{
                    int ans= Math.max(dp(nums1,nums2,idx1+1,idx2,mem),dp(nums1,nums2,idx1,idx2+1,mem));
                    mem[idx1][idx2]=ans;
                    return ans;
                }
                
            }
        }
        
    }
    
    //Tabulation
    class Solution_ {
        public int maxUncrossedLines(int[] nums1, int[] nums2) {
            
            int[][] mem=new int[nums1.length+1][nums2.length+1];
            
            for(int i=0;i<nums1.length;i++){
                Arrays.fill(mem[i],-1);
            }
            
            return dp(nums1,nums2,0,0,mem);
            
        }
        
        public int dp(int[] nums1,int[] nums2,int Idx1,int Idx2,int[][] mem){
            
            for(int idx1=nums1.length;idx1>=0;idx1--){
                for(int idx2=nums2.length;idx2>=0;idx2--){

                    if(idx1>=nums1.length || idx2>=nums2.length){
                        mem[idx1][idx2]=0;
                        continue;
                    }
                    
                    else{

                        if(nums1[idx1]==nums2[idx2]){
                            int ans= 1+mem[idx1+1][idx2+1];
                            mem[idx1][idx2]=ans;
                        }

                        else{
                            int ans= Math.max(mem[idx1+1][idx2],mem[idx1][idx2+1]);
                            mem[idx1][idx2]=ans;
                        }
                    }
                }
            }
            
            return mem[Idx1][Idx2];
        }
    
    }


}