public class Minimum_Cost_Homecoming_of_a_Robot_in_a_Grid_leetcode_2087{
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int ans=0;
        int srow=startPos[0];
        int scol=startPos[1];
        int erow=homePos[0];
        int ecol=homePos[1];
        
        int temp=srow>erow?-1:1;
        while(srow!=erow){
            srow+=temp;
            ans+=rowCosts[srow];
        }
        
        temp=scol>ecol?-1:1;
        while(scol!=ecol){
            scol+=temp;
            ans+=colCosts[scol];
        }
        
        return ans;
    }
}