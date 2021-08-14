import java.util.*;
public class optimize_water_distribution_in_a_village_leetcode_1168{

    public static int minCostToSupplyWater(int n, int[] wells, int[][] pipes)
    {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        
        for(int i=0;i<wells.length;i++){
            ArrayList<Integer> temp=new ArrayList<>();
            temp.add(0);
            temp.add(i+1);
            temp.add(wells[i]);
            graph.add(temp);
        }

        for(int i=0;i<pipes.length;i++){
            ArrayList<Integer> temp=new ArrayList<>();
            temp.add(pipes[i][0]);
            temp.add(pipes[i][1]);
            temp.add(pipes[i][2]);
            graph.add(temp);
        }

        Collections.sort(graph,(a,b)->{
            return a.get(2)-b.get(2);
        });

        int[] par=new int[n+1];
        for(int i=0;i<=n;i++){
            par[i]=i;
        }

        int cost=0;
        for(ArrayList<Integer> temp:graph){

            int p1=findPar(temp.get(0),par);
            int p2=findPar(temp.get(1),par);

            if(p1!=p2){
                par[p1]=p2;
                cost+=temp.get(2);
            }

        }

        return cost;
    }

    public static int findPar(int u,int[] par){
        if(par[u]==u)
            return u;
        else{
            int temp=findPar(par[u],par);
            par[u]=temp;
            return temp;
        }
    }

}