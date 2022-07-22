package practice;

public class P5_LongestPalindromicSubstring {

    //center expand 02

    //center expand 01
    //偶数回文失败
    //奇数回文通过
    public String longestPalindrome(String s) {
        String result= "";
        result +=s.charAt(0);
        int longestLength=1;
        for(int i=0;i<s.length()-1;i++){  //center char
            result=expandSymmetric(s,result,i);
            result=expandCenter(s,result,i);
        }
        return result;
    }

    private String expandSymmetric(String s,String result, int center){
        int distance=0;
        while(center-distance>=0 && center+distance<=s.length()&& s.charAt(center-distance) ==s.charAt(center+1+distance)){
            String currString = "";
            if(isLongest(result.length(),2*distance)){
                for(int i= center-distance;i<center+distance;i++){
                    currString += s.charAt(i);
                }
                result=currString;
            }
            distance++;
        }
        return result;
    }

    private String expandCenter(String s,String result, int center){
        int distance=0;
        while(center-distance>=0 && center+distance<=s.length()&& s.charAt(center-distance)==s.charAt(center+distance)){
            String currString = "";
            if(isLongest(result.length(),2*distance+1)){
                for(int i= center-distance;i<=center+distance;i++){
                    currString += s.charAt(i);
                }
                result=currString;
            }
            distance++;
        }
        return result;
    }

    private boolean isLongest(int numO, int numN){ //numO = old max length; numN = curr max length
        if(numO>numN){
            return false;
        }else{
            return true;
        }
    }
    private String findLongest(String sO, String sN){
        if( sO.length() > sN.length())
        {
            return sO;
        }else{
            return sN;
        }
    }
}
