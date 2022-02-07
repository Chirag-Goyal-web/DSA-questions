import java.util.*;
public class closest_room_leetcode_1847{
    public int[] closestRoom(int[][] rooms, int[][] query) {
        int len=query.length;
        int[][] queries=new int[len][3];
        
        for(int i=0;i<len;i++){
            queries[i][0]=query[i][0];
            queries[i][1]=query[i][1];
            queries[i][2]=i;
        }
        
        Arrays.sort(queries,(a,b)->{
            return b[1]-a[1];
        });
        
        Arrays.sort(rooms,(a,b)->{
            return b[1]-a[1];
        });
        
        TreeSet<Integer> tm=new TreeSet<>();
        
        int itr=0;
        int[] ans=new int[len];
        
        for(int i=0;i<len;i++){
            int temp=queries[i][1];
            
            while(itr<rooms.length && rooms[itr][1]>=temp){
                tm.add(rooms[itr][0]);
                itr++;
            }
            
            Integer t1=tm.floor(queries[i][0]);
            Integer t2=tm.ceiling(queries[i][0]);
            
            if(t1!=null && t2!=null){
                if(t2-queries[i][0]<queries[i][0]-t1){
                    ans[queries[i][2]]=t2;
                }
                else{
                    ans[queries[i][2]]=t1;
                }
            }
            else{
                if(t1==null && t2==null){
                     ans[queries[i][2]]=-1;
                }
                else if(t1==null){
                    ans[queries[i][2]]=t2;
                }
                else{
                    ans[queries[i][2]]=t1;
                }
            }
        }
        
        return ans;
    }
}