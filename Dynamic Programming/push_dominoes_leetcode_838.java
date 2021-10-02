public class push_dominoes_leetcode_838{

    public String pushDominoes(String dominoes) {
        
        int len=dominoes.length()+2;
        char[] arr=new char[len];
        
        arr[0]='L';
        
        for(int i=0;i<dominoes.length();i++){
            arr[i+1]=dominoes.charAt(i);
        }
        
        arr[len-1]='R';
        
        int prev=0;
        
        for(int i=1;i<len;i++){
            if(arr[i]!='.'){
                
                if(arr[prev]=='L'){
                    if(arr[i]=='L'){
                        for(int j=prev+1;j<i;j++){
                            arr[j]='L';
                        }
                    }   
                }
                
                else{
                    if(arr[i]=='R'){
                        for(int j=prev+1;j<i;j++){
                            arr[j]='R';
                        }
                    }
                    
                    else{
                        int k=i-prev-1;
                        for(int j=1;j<=k/2;j++){
                            arr[prev+j]='R';
                            arr[i-j]='L';
                        }
                        
                    }
                }
                
                prev=i;
            } 
        }
        
        String ans=String.valueOf(arr);
        return ans.substring(1,ans.length()-1);
    }

}