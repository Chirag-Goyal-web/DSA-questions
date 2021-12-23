import java.util.*;
public class Remove_Sub_Folders_from_the_Filesystem_leetcode_1233{
    private class Node{
        HashMap<String,Node> hm;
        boolean isEnd;
        
        Node(){
            hm=new HashMap<>();
        }
    }
    
    Node root;
    
    public List<String> removeSubfolders(String[] folder) {
        int[] count=new int[folder.length];
        root=new Node();
        
        for(int i=0;i<folder.length;i++){
            String str=folder[i];
            int temp=0;
            
            for(char c:str.toCharArray()){
                if(c=='/')
                    temp++;
            }
            
            count[i]=temp;
        }
        
        Integer[] arr=new Integer[folder.length];
        for(int i=0;i<arr.length;i++)
            arr[i]=i;
        
        Arrays.sort(arr,(a,b)->{
            return count[a]-count[b];
        });
        
        List<String> ans=new ArrayList<>();
        for(int i:arr){
            Node cur=root;
            String[] s=folder[i].split("/");
            boolean flag=true;
            
            for(int j=1;j<s.length;j++){
                String g=s[j];
                
                if(cur.hm.containsKey(g)==false){
                    cur.hm.put(g,new Node()); 
                }
                cur=cur.hm.get(g);
                if(cur.isEnd==true){
                    flag=false;
                    break;
                }
            }
            
            if(flag==true){
                ans.add(folder[i]);
                cur.isEnd=true;
            }
            
        }
        
        return ans;
    }

}