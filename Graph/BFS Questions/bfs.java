import java.util.*;
public class bfs{

    public static class Edge{
        int v;
        int w;

        Edge(int v,int w){
            this.v=v;
            this.w=w;
        }
    }

    //Used to detect cycle, visited is marked while removing, have a space complexity of O(E), E-> Edges
    public static void bfs_1(ArrayList<Edge>[] graph, int src, boolean[] vis) {
        LinkedList<Integer> que=new LinkedList<>();
        que.add(src);

        int level=0;
        while(que.size()>0){
           
            int size=que.size();
            System.out.print("Level "+level+": ");
            
            while(size-->0){
                
                int temp=que.remove(0);
                
                if(vis[temp]==true){
                    System.out.println("Cycle");
                    continue;
                }

                System.out.print(temp+" ");
                
                for(Edge i:graph[temp]){
                    if(vis[i.v]==false){
                        que.add(i.v);
                    }
                }

                vis[temp]=true;
            }

            level++;
            System.out.println();
        }

    }

    //Can't detect a cycle, visited is marked while adding in queue, have a space complexity of O(V), V-> Vertex
    public static void bfs_2(ArrayList<Edge>[] graph,int src,boolean[] vis){
        
        LinkedList<Integer> que=new LinkedList<>();
        que.add(src);
        vis[src]=true;
        int level=0;
        
        while(que.size()>0){
           
            int size=que.size();
            System.out.print("Level "+level+": ");
            
            while(size-->0){
                
                int temp=que.remove(0);
            
                System.out.print(temp+" ");
                
                for(Edge i:graph[temp]){
                    if(vis[i.v]==false){
                        que.add(i.v);
                        vis[i.v]=true;
                    }
                }

               
            }

            level++;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        
    }

}