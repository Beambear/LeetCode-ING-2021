package practice;
//给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
public class P498_FindDiagonalOrder {

    // x+y = n
    // n = 2,3,4,5......2*x
    public int[] findDiagonalOrder(int[][] mat){
        int[] array = new int[mat[0].length*mat.length];
        int count=0;
        int maxN=0;
        if(mat[0].length > mat.length){
            maxN=2*mat[0].length-2;
        }else{
            maxN=2*mat.length-2;
        }
        System.out.println("max N:"+(2*mat.length-2));
        for(int n=0;n<=maxN;n++){
            if(n%2 == 0){   //left to right && bot to top
                for(int x = 0; x <=n;x++){
                    int y=n-x;
                    if(x<mat[0].length && y<mat.length){
                        array[count]=mat[y][x];
                        count++;
                        System.out.println("Curr N:"+n+"; x:"+x+"; y:"+y);
                    }
                }
            }
            if(n%2 == 1){   //right to left && top to bot
                for(int y = 0; y<=n;y++){
                    int x=n-y;
                    if(x<mat[0].length && y<mat.length){
                        array[count]=mat[y][x];
                        count++;
                        System.out.println("Curr N:"+n+"; x:"+x+"; y:"+y);
                    }
                }
            }

        }
        return array;
    }
}
