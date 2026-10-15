class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int len=rooms.size();
        int[] vis=new int[len];
        vis[0]=1;
        HashSet<Integer> set=new HashSet<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i:rooms.get(0)){
            q.offer(i);
        }
        while(!q.isEmpty()){
            int t=q.poll();
            vis[t]=1;
            for(int i:rooms.get(t)){
                if(vis[i]==0){
                    q.offer(i);
                }
            }
        }
        for(int i=0;i<len;i++){
            if(vis[i]==0){
                return false;
            }
        }
        return true;
    }
}
