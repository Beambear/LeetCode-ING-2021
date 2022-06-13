package driver;

import google.DriverGoogle;
import practice.FindDiagonalOrder;
import practice.HeightChecker;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    Main driver = new Main();
        driver.practice(498);
    }

    public void practice(int practiceNum){
        switch(practiceNum){
            case 498 :
                FindDiagonalOrder doIt498 = new FindDiagonalOrder();
                int[] test498 = doIt498.findDiagonalOrder(new int[][]{{2,3}});
                System.out.println("test 498: "+ Arrays.toString(test498));
                break;

            case 1051:
                HeightChecker doIt1051 = new HeightChecker();
                int test1051=doIt1051.heightChecker(new int[]{1, 1, 4, 2, 1, 3});
                System.out.println("test 1051: "+test1051);
                break;
        }
    }
}
