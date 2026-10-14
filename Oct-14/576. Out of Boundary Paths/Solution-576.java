class Solution {

    int ret=0;

    public long backTrack(int i,int j,int m,int n,int move,int max,int[][][] arr){
        if(i>=m || i<0 || j>=n || j<0){
            return 1L;
        }
        if(move<max){
            if(arr[i][j][move]!=-1){
                return arr[i][j][move];
            }
            else{
                long d=backTrack(i+1,j,m,n,move+1,max,arr)%1000000007;
                long u=backTrack(i-1,j,m,n,move+1,max,arr)%1000000007;
                long r=backTrack(i,j+1,m,n,move+1,max,arr)%1000000007;
                long l=backTrack(i,j-1,m,n,move+1,max,arr)%1000000007;
                long t=d+u+r+l;
                long ff=t%1000000007;
                arr[i][j][move]=(int)ff;
                return arr[i][j][move];
            }
        }
        else{
            return 0;
        }
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if(maxMove==0){
            return 0;
        }
        int[][][] arr=new int[m+1][n+1][maxMove+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(arr[i][j],-1);
            }
        }
        backTrack(startRow,startColumn,m,n,0,maxMove,arr);
        return arr[startRow][startColumn][0];
    }
}
