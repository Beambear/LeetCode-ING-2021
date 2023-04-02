package interview;
/*
节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。

示例1:

 输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
 输出：true
示例2:

 输入：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [1, 3], [2, 3], [3, 4]], start = 0, target = 4
 输出 true

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/route-between-nodes-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.lang.reflect.Array;
import java.util.*;

////////////////////
    //思路:   递归
    //  0.起点加进hash表visited里
    //  1.从起点开始遍历该点的所有点
    //  2.每经历过一个点，便在hash表里加visited
    //  3.当hash被遍历完时，找到终点 return true
    ///////////////////
public class I0401_RouteBetweenNodes {
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        if (start == target) {
            return true;
        }
        Set<Integer> visited = new HashSet<>();
        ArrayList<Integer> reached = new ArrayList<>(n);
        visited.add(start);
        reached.add(start);
        int curIndex = 0;
        return reachDes(n, graph, curIndex, target, visited, reached);
    }

    private boolean reachDes(int n, int[][] graph, int curIndex, int target, Set visited, ArrayList<Integer> reached) {
        for (int i = 0; i < graph.length; i++) {    //遍历路径
            if (graph[i][0] == reached.get(curIndex)) {   //找到当前起点
                int next = graph[i][1];
                if (next == target) {
                    return true;    //找到目标点
                } else {
                    if (visited.add(next)) {//判断是否已经加过
                        reached.add(next);  //加入下个点
                    }
                }
            }
        }

        if (curIndex + 1 == reached.size()) {   //no more new node to search
            return false;
        }
        return reachDes(n, graph, curIndex++, target, visited, reached);
    }

    //////////////////////////////
    //思路:
    //  递归太消耗空间，用queue来储存，一个while循环即可
    //////////////////////
    public boolean findWhetherExistsPathS(int n, int[][] graph, int start, int target) {
        if (start == target) {
            return true;
        }

        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        Deque<Integer> queue = new LinkedList<>() {
        };
        queue.offerLast(start);

        while (!queue.isEmpty()) {
            int cur = queue.pollFirst();
            for (int[] edge : graph) {
                if (edge[0] == cur && edge[0] != edge[1] && edge[1] == target) {
                    return true; // 找到了目标点
                }
                if (edge[0] == cur && visited.add(edge[1])) {
                    queue.offerLast(edge[1]); // 添加未访问的相邻节点
                }
            }
        }

        return false;
    }

    /**
     * 上面两个内存都爆炸了
     */
    /**
     * 逆向寻找超快，Leetcode No.1
     * public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
     * if(start == target) return true;
     * for(int[] entry: graph) {
     * if(entry[1] == target)
     * return findWhetherExistsPath(n, graph, start, entry[0]);
     * }
     * return false;
     * }
     */

    ////////////////
    //列表不整理太耗时间，需要整理列表为邻接链表， 用空间换时间
    //  0 -> 1,2
    //  1 -> 2
    //  2 -> 0
    ///////////////
    public boolean findWhetherExistsPathC(int n, int[][] graph, int start, int target) {
        ArrayList< ArrayList<Integer>> adj = new ArrayList<>(n); //为每个节点创建 邻接链

        for(int i=0;i<n;i++){   //初始化每个节点的邻接链
            adj.add(new ArrayList<>());
        }

        for(int i=0; i< graph.length;i++){  //遍历graph所有边edge
            ArrayList cur = adj.get(graph[i][0]);   //获得该edge起点的邻接链
            cur.add(graph[i][1]);   //把终点加进去
            //也可写成
            //adj.get(graph[i][0]).add(graph[i][1])
        }

        //创建数组记录visited的点
        boolean[] visited = new boolean[n]; //每个点作为标记，也可用hashmap
        Deque<Integer> queue = new LinkedList<>();  //queue 广度优先
        queue.offer(start); //放入start节点
        visited[start] = true;
        //遍历邻接表
        while(!queue.isEmpty()){
            int curNode = queue.pollFirst();
            for(int i=0;i<adj.get(curNode).size();i++){ //遍历该点的邻接链
                int next = adj.get(curNode).get(i);
                if(next == target){
                    return true;
                }

                if(visited[next] == false){
                    queue.offerLast(next);
                    visited[next] = true;
                }
            }
        }

        return false;
    }
}