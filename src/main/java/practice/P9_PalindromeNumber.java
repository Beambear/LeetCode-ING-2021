package practice;

public class P9_PalindromeNumber {
    //不将数字转化为字符串的方法
    public boolean isPalindrome(int x){
        if(x<0)
        {
            return false;
        }
        int digits = String.valueOf(x).length();
        int loopTime = (int) Math.ceil(0.5*digits);
        for(int i=0; i< loopTime;i++)
        {
            int left = (int) ((x / Math.pow(10, digits - 1 - i)) % 10);
            int right = (int) ((x%Math.pow(10,i+1))/Math.pow(10,i));
//            System.out.println(digits+"loop:"+i+"  left:"+left+"   right:"+right);
            if(left != right)
            {
                return false;
            }
        }
        return true;
    }

    //将数字转化为字符串的做法，Reference：力扣用户 “能得到offer的ID”
    public boolean isPalindrome2(int x) {
        if(x < 0) return false;
        StringBuffer sb = new StringBuffer(String.valueOf(x));
        return sb.reverse().toString().equals(String.valueOf(x));
    }
}
