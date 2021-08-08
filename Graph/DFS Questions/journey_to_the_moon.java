import java.io.*;
import java.util.*;
public class journey_to_the_moon {

    public static long journeyToMoon(int n, List<List<Integer>> astronaut) {
        
        int size=n;
        
        ArrayList<Integer>[] graph=new ArrayList[size];
        
        for(int i=0;i<size;i++){
            graph[i]=new ArrayList<>();
        }
        
        for(List<Integer> temp:astronaut){
            graph[temp.get(0)].add(temp.get(1));
            graph[temp.get(1)].add(temp.get(0));
        }
        
        boolean[] visited=new boolean[size];
        
        long ans=0;
        long sum=0;
        for(int i=0;i<n;i++){
            if(visited[i]==false){
                int len=gcc(graph,visited,i);
                ans+=sum*len;
                sum+=len;
            }
        }

        
        return ans;
    }

    public static int gcc(ArrayList<Integer>[] graph,boolean[] visited,int src){
        
        visited[src]=true;
        int count=0;
        
        int size=graph[src].size();
        for(int i=0;i<size;i++){
            if(visited[graph[src].get(i)]==false){
                count+=gcc(graph,visited,graph[src].get(i));
            }
        }
        
        return count+1;
        
    }
    
    public static void main(String[] args) throws IOException {
        
    }
}
