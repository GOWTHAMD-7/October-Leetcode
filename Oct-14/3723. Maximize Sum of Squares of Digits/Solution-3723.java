class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder sb=new StringBuilder();
        int cnt=0;
        for(int i=1;i<=num;i++){
            if(sum>9){
                sb.append("9");
                sum-=9;
            }
            else{
                sb.append(String.valueOf(sum));
                for(int j=i+1;j<=num;j++){
                    sb.append("0");
                }
                sum=0;
                break;
            }
        }
        if(sum!=0){
            return "";
        }
        return sb.toString();
    }
}
