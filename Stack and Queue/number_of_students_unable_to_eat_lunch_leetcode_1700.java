public class number_of_students_unable_to_eat_lunch_leetcode_1700{
    public int countStudents(int[] students, int[] sandwiches) {
            
        int count1=0,count2=0;
        for(int i:students){
            if(i==0){
                count1++;
            }
            else{
                count2++;
            }
        }
        
        int ptr=0;
        
        while(ptr<students.length){
            
            if(sandwiches[ptr]==0 && count1==0){
                return sandwiches.length-ptr;
            }
            else if(sandwiches[ptr]==1 && count2==0){
                return sandwiches.length-ptr;
            }
            else if(sandwiches[ptr]==1){
                ptr++;
                count2--;
            }
            else{
                ptr++;
                count1--;
            }
        }
        
        return 0;
    }
}