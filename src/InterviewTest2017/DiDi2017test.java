package InterviewTest2017;

/**
 * Created by parallel on 9/18/16.
 */
public class DiDi2017test {
    public static void main(String[] args){
//        System.out.println(func(254));
//        System.out.println(countZero(1000));
//        migong();
    }
    public static int func(int x){
        int countx = 0;
        while(x!=0){
            countx ++;
            x = x&(x-1);
        }
        return countx;
    }
    public static int countZero(int N)
    {
        int ret = 0;
        while(N!=0)
        {
            ret += N/5;
            N /= 5;
        }
        return ret;
    }

    public static int [][] next = {
            {0, 1}, // right
            {1, 0}, // down
            {0, -1}, // left
            {-1, 0} // up
    };


    public static void migong(){
        int[] minstep = new int[1];
        minstep[0]= Integer.MAX_VALUE;
        int startx=0, starty=0;
        int n = 4;
        int m = 4;
        int p = 10;
        int[][] road = {
                {1, 0, 0, 1},
                {1, 1, 0, 1},
                {0, 1, 1, 1},
                {0, 0, 1, 1}
        };
         int[][] visited = new int[n][m];
        visited[0][0] = 1;
        int dstx = 0, dsty = m-1;
        dfs(startx,starty,0,visited,road,dstx,dsty,n,m,minstep);
        System.out.println(minstep);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                System.out.print(visited[i][j]+" ");
            System.out.println();
        }
    }

    public static void dfs(int x, int y, int step,
                           int[][] visited,
                           int [][] road,
                           int dstx, int dsty,
                           int n, int m, int[] minstep){
        // how current step are going to.
        int nextx, nexty;
        if(x == dstx && y == dsty){
            if(step<minstep[0])
                minstep[0] = step;
            return;
        }
        // hasn't arrive at dst. keep going and select a direction.
        for(int i=0;i<3;i++){
            nextx = x + next[i][0];
            nexty = y + next[i][1];
            // if out of range try next direction.
            if(nextx < 0 || nextx > n-1 || nexty<0 || nexty>m-1){
                continue;
            }
            // if a barria or has visited.
            if(road[nextx][nexty] == 1 && visited[nextx][nexty] == 0){
                visited[nextx][nexty] = 1; // mark.
                dfs(nextx,nexty,step+1,visited,road,dstx,dsty,n,m,minstep); // attemp next.
                visited[nextx][nexty] = 0; // attemp end, cancle mark.
            }
        }
    }
}
