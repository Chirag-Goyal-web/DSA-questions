import java.util.*;
public class course_schedule_2_leetcode_210{
    
    //DFS solution
    class Solution_1{
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            
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
            ArrayList<Integer> ans=new ArrayList<>();
            
            for(int i=0;i<n;i++){
                if(visited[i]==-1){
                    if(dfs(graph,visited,i,ans)==false){
                        return new int[0];
                    }   
                }    
            }
             
            int[] arr=new int[ans.size()];
            for(int i=0;i<ans.size();i++)
                arr[i]=ans.get(i);
            return arr;
        }
        
        public boolean dfs(ArrayList<Integer>[] graph,int[] visited,int src,ArrayList<Integer> ans){
            
            visited[src]=1;
            
            for(int i:graph[src]){ 
                if(visited[i]==-1){
                    boolean temp=dfs(graph,visited,i,ans);
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
            ans.add(src);
            return true;
        }

    }

    //Kahn's algorithm
    class Solution_2 {
        public int[] findOrder(int num, int[][] prerequisites) {
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
                return new int[0];
            }else{
                int idx=0;
                int[] arr=new int[ans.size()];
                for(int i=ans.size()-1;i>=0;i--){
                    arr[idx++]=ans.get(i);
                }
                return arr;
            }
        }
    }

}