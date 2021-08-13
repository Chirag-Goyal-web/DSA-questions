import java.util.*;
public class number_of_island_2_leetcode_305{
    
    //Using grid
    List<Integer> numIslands2_1(int n, int m, int[][] positions)
    {
        int[][] grid=new int[n][m];
        int[] par=new int[n*m];
        
        int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        for (int i = 0; i < n * m; i++)
            par[i]=i;

        List<Integer> ans=new ArrayList<>();
        int count = 0;

        for (int[] pos:positions)
        {
            int i = pos[0];
            int j = pos[1];

            if (grid[i][j] == 1)
            {
                ans.add(count);
                continue;
            }

            grid[i][j] = 1;
            count++;
            int p1 = findPar(i * m + j,par);
            for (int[] d : dir)
            {
                int r = i + d[0];
                int c = j + d[1];

                if (r >= 0 && r < n && c >= 0 && c < m && grid[r][c] == 1)
                {
                    int p2 = findPar(r * m + c,par);
                    if (p1 != p2)
                    {
                        count--;
                        par[p2] = p1;//Can't merge p1 into p2. If we want to merge p1 into p2, then calculate p1 everytime in loop
                    }
                }
            }

            ans.add(count);
        }
        return ans;
    }

    //Without using grid
    List<Integer> numIslands2_2(int n, int m, int[][] positions)
    {
    
        int[] par=new int[n*m];
        
        Arrays.fill(par,-1);

        int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        for (int i = 0; i < n * m; i++)
            par[i]=i;

        List<Integer> ans=new ArrayList<>();
        int count = 0;

        for (int[] pos:positions)
        {
            int i = pos[0];
            int j = pos[1];

            if (par[i*m+j] != 1)
            {
                ans.add(count);
                continue;
            }
            
            count++;
            par[i*m+j]=i*m+j;
            int p1 = findPar(i * m + j,par);// We can directly assign i*m+j as well

            for (int[] d : dir)
            {
                int r = i + d[0];
                int c = j + d[1];

                if (r >= 0 && r < n && c >= 0 && c < m && par[r*m+c] != -1)
                {
                    int p2 = findPar(r * m + c,par);
                    if (p1 != p2)
                    {
                        count--;
                        par[p2] = p1;//Can't merge p1 into p2. If we want to merge p1 into p2, then calculate p1 everytime in loop
                    }
                }
            }

            ans.add(count);
        }
        return ans;
    }

    public int findPar(int u,int[] par){
        if(par[u]==u){
            return u;
        }
        else{
            int getPar=findPar(par[u],par);
            par[u]=getPar;
            return getPar;
        }
    }

    public static void main(String[] args) {
        
    }
}