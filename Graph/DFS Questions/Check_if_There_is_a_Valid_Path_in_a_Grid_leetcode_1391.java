import java.util.*;
public class Check_if_There_is_a_Valid_Path_in_a_Grid_leetcode_1391{
    
    public class Pair{
        int[] dir;
        Set<Integer> allowed;
        
        Pair(int[] dir,Set<Integer> allowed){
            this.dir=dir;
            this.allowed=allowed;
        }
    }
    
    public boolean hasValidPath(int[][] grid) {
        
        List<List<Pair>> mapping=new ArrayList<>();
        mapping.add(new ArrayList<>());
        
        List<Pair> one=new ArrayList<>();
        List<Pair> two=new ArrayList<>();
        List<Pair> three=new ArrayList<>();
        List<Pair> four=new ArrayList<>();
        List<Pair> five=new ArrayList<>();
        List<Pair> six=new ArrayList<>();
        
        one.add(new Pair(new int[]{0,1},new HashSet<>(Arrays.asList(1,3,5))));
        one.add(new Pair(new int[]{0,-1},new HashSet<>(Arrays.asList(1,4,6))));
        mapping.add(one);
        
        two.add(new Pair(new int[]{1,0},new HashSet<>(Arrays.asList(5,6,2))));
        two.add(new Pair(new int[]{-1,0},new HashSet<>(Arrays.asList(3,4,2))));
        mapping.add(two);
        
        three.add(new Pair(new int[]{0,-1},new HashSet<>(Arrays.asList(1,4,6))));
        three.add(new Pair(new int[]{1,0},new HashSet<>(Arrays.asList(5,6,2))));
        mapping.add(three);
        
        four.add(new Pair(new int[]{0,1},new HashSet<>(Arrays.asList(1,3,5))));
        four.add(new Pair(new int[]{1,0},new HashSet<>(Arrays.asList(5,6,2))));
        mapping.add(four);
        
        five.add(new Pair(new int[]{-1,0},new HashSet<>(Arrays.asList(3,4,2))));
        five.add(new Pair(new int[]{0,-1},new HashSet<>(Arrays.asList(4,6,1))));
        mapping.add(five);
        
        six.add(new Pair(new int[]{-1,0},new HashSet<>(Arrays.asList(3,4,2))));
        six.add(new Pair(new int[]{0,1},new HashSet<>(Arrays.asList(1,3,5))));
        mapping.add(six);

        return dfs(0,0,grid,mapping,grid.length,grid[0].length);
    }
    
    public boolean dfs(int row,int col,int[][] grid,List<List<Pair>> mapping,int n,int m){
        
        if(row==n-1 && col==m-1){
            return true;
        }
        
        List<Pair> temp=mapping.get(grid[row][col]);
        grid[row][col]=-1;
        
        for(Pair p:temp){
            int tempr=row+p.dir[0];
            int tempc=col+p.dir[1];
            if(tempr>=0 && tempr<n && tempc>=0 && tempc<m && p.allowed.contains(grid[tempr][tempc])){
                if(dfs(tempr,tempc,grid,mapping,n,m)==true){
                    return true;
                }
            }
        }
        
        return false;
    }

}