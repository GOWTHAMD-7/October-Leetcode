class BusBooking {

    int time=0;
    int booked=0;
    int[][] arr;
    

    public BusBooking(int n) {
        arr=new int[n+1][4];
    }
    
    public void toggle(String s) {
        int row=0;
        int col=0;
        char c=s.charAt(0);
        if(c=='A'){
            col=0;
        }
        else if(c=='B'){
            col=1;
        }
        else if(c=='C'){
            col=2;
        }
        else if(c=='D'){
            col=3;
        }
        row=Integer.valueOf(s.substring(1,s.length()));
        if(arr[row][col]!=0){
            booked--;
            time-=arr[row][col];
            arr[row][col]=0;
        }
        else if(col==0){
            booked++;
            if(arr[row][1]!=0){
                arr[row][col]=3;
                time+=3;
            }
            else{
                arr[row][col]=1;
                time+=1;
            }
        }
        else if(col==3){
            booked++;
            if(arr[row][2]!=0){
                arr[row][col]=3;
                time+=3;
            }
            else{
                arr[row][col]=1;
                time+=1;
            }
        }
        else if(col==2){
            arr[row][col]=1;
            booked++;
            time+=1;
        }
        else{
            arr[row][col]=1;
            booked++;
            time+=1;
        }
    }
    
    public int getTotalTime() {
        return time;
    }
    
    public int getMinTime() {
        return booked;
    }
}

/**
 * Your BusBooking object will be instantiated and called as such:
 * BusBooking obj = new BusBooking(n);
 * obj.toggle(seat);
 * int param_2 = obj.getTotalTime();
 * int param_3 = obj.getMinTime();
 */
