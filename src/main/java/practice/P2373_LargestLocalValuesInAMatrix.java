package practice;

public class P2373_LargestLocalValuesInAMatrix {
    /*
    给你一个大小为 n x n 的整数矩阵 grid 。
    生成一个大小为(n - 2) x (n - 2) 的整数矩阵 maxLocal ，并满足：
    maxLocal[i][j] 等于 grid 中以 i + 1 行和 j + 1 列为中心的 3 x 3 矩阵中的 最大值 。
    换句话说，我们希望找出 grid 中每个3 x 3 矩阵中的最大值。
    返回生成的矩阵。
    示例 1：
    输入：grid = [[9,9,8,1],[5,6,2,6],[8,2,6,4],[6,2,2,2]]
    输出：[[9,9],[8,6]]
    解释：原矩阵和生成的矩阵如上图所示。
    注意，生成的矩阵中，每个值都对应 grid 中一个相接的 3 x 3 矩阵的最大值。
    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/largest-local-values-in-a-matrix
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    ///////////////////
    //思路：
    //1.建立目标矩阵
    //2.set i,j 遍历 i->n-2, j->n-2 的3x3矩阵，
    //3.记录最大值进目标矩阵
    ///////////////////

    public int[][] largestLocalA(int[][] grid){
        int n = grid.length;
        int[][] result = new int[n-2][n-2];
        for(int j=0;j<n-2;j++){
            for(int i=0;i<n-2;i++){
                // grid[i][j]为小矩阵起点
                for(int k=j;k<j+3;k++){
                    for(int l=i;l<i+3;l++){
                        result[i][j] = Math.max(result[i][j],grid[l][k]);
                    }
                }

            }
        }
        return  result;
    }
}
