import java.util.*;

public class ShortestDistance {
//                    0    1    2    3    4    5    6    7    8    9   10
//                0    0   13    0   26    0    0    0    0    0    0    0
//                1   13    0   22    0    8    0    0    0    0    0   15
//                2    0   22    0   20    0   31    0    0    0    0    0
//                3   26    0   20    0   32    0    7    0    0    0    0
//                4    0    8    0   32    0    0   16    0    0    0    0
//                5    0    0   31    0    0    0    0    9    0    0    0
//                6    0    0    0    7   16    0    0   14   18    0   10
//                7    0    0    0    0    0    9   14    0    0    0   11
//                8    0    0    0    0    0    0   18    0    0   23    0
//                9    0    0    0    0    0    0    0    0   23    0   19
//                10   0   15    0    0    0    0   10   11    0   19    0
    private List<List<int[]>> al;
    private int[][] distMat;
    private final int far=Integer.MAX_VALUE;

    private int[] dist;
    public ShortestDistance(){
        al=new ArrayList<>();
        distMat=new int[][]{
                {0   ,13,    0,   26 ,   0 ,   0 ,   0 ,   0 ,   0 ,   0 ,   0},
                {13 ,   0,   22,    0,    8,    0 ,   0,    0,    0  ,  0,   15},
                {0   ,22,    0 ,  20  ,  0  , 31 ,   0 ,   0 ,   0 ,   0 ,   0},
                {26  ,  0 ,  20 ,   0 ,  32  ,  0 ,   7 ,   0 ,   0 ,   0 ,   0},
                {0 ,   8,    0 ,  32 ,   0 ,   0,   16 ,   0 ,   0 ,   0  ,  0},
                {0   , 0,   31 ,   0  ,  0 ,   0 ,   0 ,   9 ,   0 ,   0 ,   0},
                {0  ,  0  ,  0,    7,   16,    0 ,   0 ,  14,   18 ,   0 ,  10},
                { 0,    0 ,   0 ,   0  ,  0 ,   9 ,  14,    0,    0 ,   0 ,  11},
                { 0   , 0 ,   0  ,  0 ,   0 ,   0  , 18 ,   0  ,  0  , 23  ,  0},
                { 0  ,  0   , 0  ,  0   , 0  ,  0  ,  0   , 0  , 23    ,0   ,19},
                { 0  , 15 ,   0  ,  0 ,   0 ,   0  , 10  , 11 ,   0 , 19  ,  0}
        };
        for(int i=0;i<11;i++){
            al.add(new ArrayList<>());
        }
        for(int i=0;i<11;i++) {
            for (int j=0;j<11;j++) {
                if (distMat[i][j] != 0) {
                    al.get(i).add(new int[]{j, distMat[i][j]});
                    al.get(j).add(new int[]{i, distMat[i][j]});
                }
            }
            PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
            dist=new int[11];
            Arrays.fill(dist,far);
            pq.add(new int[]{0,0});
            dist[0]=0;
            while(!pq.isEmpty()){
                int[] temp=pq.poll();
                int node=temp[0];
                int dis=temp[1];
                for(int[] ar:al.get(node)){
                    int d=ar[1];
                    int adjnode=ar[0];
                    if(dist[adjnode]>=dis+d){
                        dist[adjnode]=dis+d;
                        pq.add(new int[]{adjnode,dist[adjnode]});
                    }
                }
            }
        }
    }
    public int ClosePath(int dest){
      return dist[dest];
    }


}
