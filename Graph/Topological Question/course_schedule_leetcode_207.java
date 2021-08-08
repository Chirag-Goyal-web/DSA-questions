import java.util.*;

public class course_schedule_leetcode_207{
    //DFS method
    class Solution_1 {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            
            int n=numCourses;
            ArrayList<Integer>[] graph=new ArrayList[n];
            
            for(int i=0;i<n;i++){
                graph[i]=new ArrayList<>();
            }
            
            for(int i=0;i<prerequisites.length;i++){
                graph[prerequisites[i][0]].add(prerequisites[i][1]);
            }
            
            int[] visited=new int[n];
            Arrays.fill(visited,-1);
            for(int i=0;i<n;i++){
                if(visited[i]==-1){
                    if(dfs(graph,visited,i)==false){
                        return false;
                    }   
                }    
            }
             
            return true;
            
        }
        
        public boolean dfs(ArrayList<Integer>[] graph,int[] visited,int src){
            
            visited[src]=1;
            
            for(int i:graph[src]){
                
                if(visited[i]==-1){
                    boolean temp=dfs(graph,visited,i);
                    if(temp==false){
                        return false;
                    }
                }
                
                else{
                    if(visited[i]==1){
                        return false;
                    }
                }
                
            }
            
            visited[src]=2;
            return true;
        }
        
    }

    //Kahn's algorithm
    class Solution_2 {
    
        public boolean canFinish(int num, int[][] prerequisites) {
            
            ArrayList<Integer>[] graph=new ArrayList[num];
            
            for(int i=0;i<num;i++){
                graph[i]=new ArrayList<>();
            }
            
            for(int i=0;i<prerequisites.length;i++){
                graph[prerequisites[i][0]].add(prerequisites[i][1]);
            }
            
            int[] indegree=new int[num];
            
            for(ArrayList<Integer> temp:graph){
                for(int v:temp){
                    indegree[v]++;
                }
            }
            
            LinkedList<Integer> que=new LinkedList<>();
            
            for(int i=0;i<num;i++){
                if(indegree[i]==0)
                    que.add(i);
            }
            
            List<Integer> ans=new ArrayList<>();
            
            while(que.size()>0){
                int temp=que.remove(0);
                ans.add(temp);
                
                for(int v:graph[temp]){
                    indegree[v]--;
                    if(indegree[v]==0){
                        que.add(v);
                    }
                }
            }
            
            if(ans.size()!=num){
                return false;
            }else{
                return true;
            }
            
        }
        
    }

}