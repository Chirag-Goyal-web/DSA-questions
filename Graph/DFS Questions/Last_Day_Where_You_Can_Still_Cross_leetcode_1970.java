public class Last_Day_Where_You_Can_Still_Cross_leetcode_1970{

    public int latestDayToCross(int row, int col, int[][] cells) {
            
        int l=0,h=cells.length-1;
        int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        
        while(l<=h){
            
            int mid=(l+h)/2;
            int[][] temp=new int[row][col];
            
            for(int i=0;i<=mid;i++){
                temp[cells[i][0]-1][cells[i][1]-1]=1;
            }
            
            boolean ans=false;
            
            for(int i=0;i<col;i++){
                if(temp[0][i]==0){
                    ans=ans||helper(0,i,dir,temp,row-1,col-1);
                }
            }
            
            System.out.println(l+" "+h);
            
            if(ans==true){
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }
        
        return h+1;
    }
    
    public boolean helper(int row,int col,int[][] dir,int[][] temp,int n,int m){
        
        temp[row][col]=1;
        
        if(row==n){
            return true;
        }
        
        else{
            
            for(int[] arr:dir){
                int tempr=row+arr[0];
                int tempc=col+arr[1];
                
                if(tempr>=0 && tempr<=n && tempc>=0 && tempc<=m && temp[tempr][tempc]==0){
                    if(helper(tempr,tempc,dir,temp,n,m)==true){
                        return true;
                    }
                }
            }
            
            return false;
        }
        
    }


}