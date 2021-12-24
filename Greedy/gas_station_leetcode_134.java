public class gas_station_leetcode_134{
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int shortage=0;
        int start=0;
        int fuel=0;
        
        for(int i=0;i<gas.length;i++){
            fuel+=gas[i];
            
            if(cost[i]>fuel){
                start=i+1;
                shortage+=(cost[i]-fuel);
                fuel=0;
            }
            else{
                fuel-=cost[i];
            }
        }
        
        if(start==gas.length || fuel<shortage){
            return -1;
        }
        else{
            return start;
        }
    }
}