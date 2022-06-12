package driver;

import google.DriverGoogle;
import practice.HeightChecker;

public class Main {

    public static void main(String[] args) {
	    Main driver = new Main();
        driver.practice(1051);
    }

    public void practice(int practiceNum){
        switch(practiceNum){
            case 1051:
                HeightChecker doIt = new HeightChecker();
                int result=doIt.heightChecker(new int[]{1, 1, 4, 2, 1, 3});
                System.out.println(result);
                break;
        }
    }
}
