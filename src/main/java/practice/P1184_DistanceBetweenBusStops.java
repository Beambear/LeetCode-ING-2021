package practice;
/*
环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。我们已知每一对相邻公交站之间的距离，distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。

环线上的公交车都可以按顺时针和逆时针的方向行驶。

返回乘客从出发点 start 到目的地 destination 之间的最短距离。

 

示例 1：



输入：distance = [1,2,3,4], start = 0, destination = 1
输出：1
解释：公交站 0 和 1 之间的距离是 1 或 9，最小值是 1。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/distance-between-bus-stops
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P1184_DistanceBetweenBusStops {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int distanceClock = 0;
        int distanceCountClock=0;
        int i=start;
        int j=start;
        while (i!=destination){ //向左寻找
            distanceClock += distance[i];
            i++;
            if(i>distance.length-1)
            {
                i=0;
            }
        }
        while(j!=destination){  //向右寻找
            j--;
            if(j<0)
            {
                j=distance.length-1;
            }
            distanceCountClock += distance[j];
        }
        return Math.min(distanceClock,distanceCountClock);
    }
}
