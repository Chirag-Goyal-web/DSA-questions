import java.util.*;
public class lexicographical_numbers_leetcode_386{
    public List<Integer> lexicalOrder(int n) {
        
        List<Integer> ans=new ArrayList<>();
        
        for(int i=1;i<=9;i++){
            int f1=i;
            
            if(f1<=n)
                ans.add(f1);
            else
                break;
            
            for(int j=0;j<=9;j++){
                int f2=f1*10+j;
                
                if(f2<=n)
                    ans.add(f2);
                else
                    break;
                
                for(int k=0;k<=9;k++){
                    int f3=f2*10+k;
                    
                    if(f3<=n)
                        ans.add(f3);
                    else
                        break;
                    
                    for(int l=0;l<=9;l++){
                        int f4=f3*10+l;
                        
                        if(f4<=n)
                            ans.add(f4);
                        else
                            break;
                        
                        for(int m=0;m<=9;m++){
                            int f5=f4*10+m;
                            
                            if(f5<=n)
                                ans.add(f5);
                            else
                                break;
                        }
                    }
                }
            }
        }
        
        return ans;
    }
}