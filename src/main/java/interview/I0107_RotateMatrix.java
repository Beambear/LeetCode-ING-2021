package interview;
/*
给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。

不占用额外内存空间能否做到？
示例 1:
给定 matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

原地旋转输入矩阵，使其变为:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
本题与主站 48 题相同：https://leetcode-cn.com/problems/rotate-image/
 */
public class I0107_RotateMatrix {
    ///////////////////////////////
    //思路：
    //旋转90°，方形矩阵尺寸为n， 每个数字位置为[i][j]
    //[i][ ]->[ ][n-i]
    //[ ][j]->[j][ ]
    //最终:[i][j]->[j][n-i]
    //
    //创建个新的等大矩阵，把新元素一对一放进去
    ////////////////////////////////
    public void rotateA(int[][] matrix) {
        int n = matrix.length;

        int[][] temp = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                temp[j][n-1-i]=matrix[i][j];
            }
        }

        //放回原矩阵
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=temp[i][j];
            }
        }
    }

    //////////////////////
    //思路：
    //原地旋转法， 需要顺时针旋转90°。
    //可以[i][j]->[j][i]做到旋转180°
    //再反转每一行的元素，逆时针倒转90°
    ///////////////////////

    public void rotateB(int[][] matrix) {
        int n = matrix.length;

        // 转置矩阵
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 翻转每一行的元素
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}
