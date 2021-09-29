public class student_attendance_record_2_leetcode_552{

    //A- Ending with A
    //P0- Ending wth P with 0 A
    //P-1 Ending with P with 1 A
    public int checkRecord(int n) {
        
        long A=1,P0=1,P1=0,L0=1,L1=0,LL0=0,LL1=0;
        long tA=0,tP0=0,tP1=0,tL0=0,tL1=0,tLL0=0,tLL1=0;
        int mod=((int)1e9)+7;
        
        for(int i=2;i<=n;i++){
            tA=(P0+L0+LL0)%mod;
            tP0=(P0+L0+LL0)%mod;
            tP1=(P1+A+L1+LL1)%mod;
            tL0=P0;
            tL1=(A+P1)%mod;
            tLL0=L0;
            tLL1=L1;
            
            A=tA;
            P0=tP0;
            P1=tP1;
            L0=tL0;
            L1=tL1;
            LL0=tLL0;
            LL1=tLL1;
        }
        
        return  (int)((A+P0+P1+L0+L1+LL0+LL1)%mod);
    }

}