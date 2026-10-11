class Solution {
    public boolean threeFibonacciSum(int n) {
        int a=0;
        int b=1;
        int c=1;
        while(true){
            int t=a+b+c;
            if(t==n){
                return true;
            }
            else if(t<n){
                a=b;
                b=c;
                c=a+b;
            }
            else{
                break;
            }
        }
        return false;
    }
}
