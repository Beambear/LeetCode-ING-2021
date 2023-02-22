package interview;
/*
编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 */
public class I0108_ZeroMatrix {
    ///////////////////////
    //思路：
    //遍历整个矩阵，若遇到[i][j]=0.则把[i][0]=0,[0][j]=0
    //重新遍历矩阵的[i][0]，若为0，则整个[i][0]~[i][j]都重设为0
    //重新遍历矩阵的[0][j]，若为0，则整个[0][j]~[i][j]都重设为0
    //
    //边际排除， 若[0][0]=0,会在填0的时候让整个矩阵为0，
    //所以填0遍历的时候应该从[i][1]和[1][j]开始
    //最后检查[0][0]//纠错，先检查[0][0]设下boolean，免得之后被改掉。最后判断是否执行[0][0]
    //////////////////////
    public void setZeroesA(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        //检查[0][0]
        boolean zeros=false;
        if(matrix[0][0]==0){
            zeros=true;
        }

        //标记领头位置
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }



        //填0
        for(int i=1;i<m;i++){
            if(matrix[i][0]==0){
                for(int j=0;j<n;j++){
                    matrix[i][j]=0;
                }
            }
        }

        for(int j=1;j<n;j++){
            if(matrix[0][j]==0){
                for(int i=0;i<m;i++){
                    matrix[i][j]=0;
                }
            }
        }

        if(zeros==true){
            for(int i=0;i<m;i++){
                matrix[i][0]=0;
            }
            for(int j=0;j<n;j++){
                matrix[0][j]=0;
            }
        }
    }
    /////////////////////////
    //上面的有问题，改不好了。抄了一个
    /////////////////////
    public void setZeroesB(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean i0 = false, j0 = false;

        // 第一行是否包含 0
        for (int j = 0; j < n; ++j) {
            if (matrix[0][j] == 0) {
                i0 = true;
                break;
            }
        }

        // 第一列是否包含 0
        for (int i = 0; i < m; ++i) {
            if (matrix[i][0] == 0) {
                j0 = true;
                break;
            }
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (i0) {
            for (int j = 0; j < n; ++j) {
                matrix[0][j] = 0;
            }
        }
        if (j0) {
            for (int i = 0; i < m; ++i) {
                matrix[i][0] = 0;
            }
        }
    }
//
//    作者：lcbin
//    链接：https://leetcode.cn/problems/zero-matrix-lcci/solution/-by-lcbin-n12y/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
