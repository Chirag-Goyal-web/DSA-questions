import java.util.*;
public class Most_Stones_Removed_with_Same_Row_or_Column_leetcode_947{

    public int removeStones(int[][] stones) {
        
        HashMap<Integer,ArrayList<Integer>> rowWiseSep=new HashMap<>();
        HashMap<Integer,ArrayList<Integer>> colWiseSep=new HashMap<>();
        HashMap<Integer,Boolean> visited=new HashMap<>();
        
        for(int []temp:stones){
            int idx=temp[0]*10001+temp[1];    
            rowWiseSep.putIfAbsent(temp[0],new ArrayList<>());
            colWiseSep.putIfAbsent(temp[1],new ArrayList<>());
            rowWiseSep.get(temp[0]).add(idx);
            colWiseSep.get(temp[1]).add(idx);
        }
        
        int ans=0;
        
        for(int[] arr:stones){
            int idx=arr[0]*10001+arr[1];
            if(!visited.containsKey(idx)){
                ans+=dfs(idx,rowWiseSep,colWiseSep,visited);
                ans--;
            }
        }
        
        return ans;
    }
    
    public int dfs(int src,HashMap<Integer,ArrayList<Integer>> rowWiseSep,HashMap<Integer,ArrayList<Integer>> colWiseSep,HashMap<Integer,Boolean> visited){
        
        int row=src/10001;
        int col=src%10001;
        int count=0;
        visited.put(src,true);
        
        for(int i:rowWiseSep.get(row)){
            if(!visited.containsKey(i)){
                count+=dfs(i,rowWiseSep,colWiseSep,visited);
            }
        }
        
        for(int i:colWiseSep.get(col)){
            if(!visited.containsKey(i)){
                count+=dfs(i,rowWiseSep,colWiseSep,visited);
            }
        }
        
        return count+1;
    }

}