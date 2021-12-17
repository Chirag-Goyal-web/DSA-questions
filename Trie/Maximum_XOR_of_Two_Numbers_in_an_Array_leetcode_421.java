public class Maximum_XOR_of_Two_Numbers_in_an_Array_leetcode_421{
    static class Trie{
        private class Node{
            Node left;
            Node right;
        }
        
        Node root;
        
        Trie(){
            root=new Node();
        }
        
        public void add(int n){
            Node cur=root;
            
            for(int i=30;i>=0;i--){
                int mask=(1<<i);
                int bit=(mask&n)>0?1:0;
                
                if(bit==0){
                    if(cur.left==null){
                        cur.left=new Node();
                    }
                    cur=cur.left;
                }
                else{
                    if(cur.right==null){
                        cur.right=new Node();
                    }
                    cur=cur.right;
                }
            }
            
        }
        
        public int query(int n){
            int ans=0;
            Node cur=root;
            
            for(int i=30;i>=0;i--){
                int mask=(1<<i);    
                int bit=(mask&n)>0?1:0;
                
                if(bit==0){
                    if(cur.left!=null){
                        cur=cur.left;
                    }
                    else{
                        ans=(ans|mask);
                        cur=cur.right;
                    }
                }
                else{
                    if(cur.right!=null){
                        cur=cur.right;
                        ans=(ans|mask);
                    }   
                    else{
                        cur=cur.left;
                    }
                }
            }
            
            return ans;
        }
    }
    
    public int findMaximumXOR(int[] nums) {
        Trie trie=new Trie();
    
        for(int i:nums){
            trie.add(i);        
        }
        
        int max=0;
        for(int i:nums){
            int required=(Integer.MAX_VALUE^i);
            int find=trie.query(required);
            max=Math.max(max,i^find);
        }
    
        return max;
    }

}