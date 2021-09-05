public class Count_the_number_of_ways_to_divide_N_in_k_groups_incrementally{
    //Incomplete
    public static int helper(int sum,int k,int min){

        if(k==1){
            return 1;
        }

        else{
            int count=0;
            for(int i=min;i<=(sum-i)/(k-1);i++){
                count+=helper(sum-i,k-1,i);
            }
            return count;
        }
    }

    public static void main(String[] args) {
        System.out.println(helper(24,5,1));
    }

}