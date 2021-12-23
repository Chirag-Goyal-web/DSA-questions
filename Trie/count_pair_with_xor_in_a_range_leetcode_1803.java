public class count_pair_with_xor_in_a_range_leetcode_1803{
    int MAX_BIT=30;
    
    public class Trie{
        Trie one;
        Trie zero;
        int count=0;
    }
    
    Trie root;
    
    public void addWord(int num){
        Trie cur=root;
        
        for(int i=MAX_BIT;i>=0;i--){
            int mask=(1<<i);
            boolean flag=(mask&num)>0?true:false;
            
            if(flag){
                if(cur.one==null){
                    cur.one=new Trie();
                }
                cur=cur.one;
            }
            else{
                if(cur.zero==null){
                    cur.zero=new Trie();
                }
                cur=cur.zero;
            }
            cur.count++;
        }
    }

    public int helper(int num,int high,Trie cur,int shiftBy){
        if(cur==null){
            return 0;
        }
        else if(shiftBy==-1){
            return cur.count;
        }
        else{
            int mask=(1<<shiftBy);
            int bitV=(num&mask)>0?1:0;
            int bitH=(high&mask)>0?1:0;
            
            if(bitV==0){
                if(bitH==0){
                    return helper(num,high,cur.zero,shiftBy-1);
                }
                else{
                    int ans=0;
                    ans+=(cur.zero!=null)?cur.zero.count:0;
                    ans+=helper(num,high,cur.one,shiftBy-1);
                    return ans;
                }
            }
            else{
                if(bitH==0){
                    return helper(num,high,cur.one,shiftBy-1);
                }
                else{
                    int ans=0;
                    ans+=(cur.one!=null)?cur.one.count:0;
                    ans+=helper(num,high,cur.zero,shiftBy-1);
                    return ans;
                }
            }
        }
    }
    
    public int countPairs(int[] nums, int low, int high) {
        root=new Trie();
        int ans=0;
        
        for(int i:nums){
            int temp1=helper(i,high,root,MAX_BIT);
            int temp2=helper(i,low-1,root,MAX_BIT);
            ans+=(temp1-temp2);
            
            System.out.println(temp1+" "+temp2);
            addWord(i);
        }
        
        return ans;
    }

}