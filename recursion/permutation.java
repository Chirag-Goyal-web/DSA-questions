public class permutation
{
	
	public static void main(String[] args) {
	    
	}

    //Approach-1
    public static void permuta(String que,String ans,int[] visit){
        
        if(ans.length()==que.length()){
            System.out.println(ans);
        }
        
        else{
            
            for(int i=0;i<visit.length;i++){
                
                if(visit[i]==0){
                    visit[i]=1;
                    permuta(que,ans+que.charAt(i),visit);
                    visit[i]=0;
                }
                
            }
            
        }
        
    }
    
    //Approach-2
    public static void permut(String que,int idx,String ans,int[] visit){

        if(idx>=que.length()){
            return;
        }

        else if(ans.length()==que.length()){
            System.out.println(ans);
        }

        else{

            if(visit[idx]==0){
                visit[idx]=1;
                permut(que,0, ans+que.charAt(idx), visit);
                visit[idx]=0;
            }

            permut(que,idx+1,ans,visit);

        }

    }

}