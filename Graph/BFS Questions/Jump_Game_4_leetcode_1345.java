import java.util.*;
public class Jump_Game_4_leetcode_1345{

    public int minJumps(int[] arr) {
        
        int lastIdx=arr.length-1;
        HashMap<Integer,Set<Integer>> hm=new HashMap<>();
        
        for(int i=0;i<arr.length;i++){
            if(!hm.containsKey(arr[i])){
                hm.put(arr[i],new HashSet<>());    
            }
            hm.get(arr[i]).add(i);
        }
        
        Queue<Integer> que=new LinkedList<>();
        boolean[] visited=new boolean[arr.length];
        que.add(0);
        visited[0]=true;
        int ans=0;
        
        while(que.size()>0){
            int size=que.size();
            
            while(size-->0){
                
                int temp=que.remove();
                
                if(temp==lastIdx)
                    return ans;
                
                if(temp-1>=0 && visited[temp-1]==false){
                    que.add(temp-1);
                    visited[temp-1]=true;
                }
                
                if(temp+1<=lastIdx && visited[temp+1]==false){
                    que.add(temp+1);
                    visited[temp+1]=true;
                }
                
                if(hm.containsKey(arr[temp])){
                    for(int i:hm.get(arr[temp])){
                        if(visited[i]==false){
                            visited[i]=true;
                            que.add(i);
                        }
                    }
                    hm.remove(arr[temp]);
                }
            }
            ans++;
        }
        
        return ans;
    }

}