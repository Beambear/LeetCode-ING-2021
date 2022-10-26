package practice;

public class P278_FirstBadVersion {
    public int firstBadVersion(int n){
        int left = 1;
        int right = n;
        while(left<=right){
            int mid = left+(right-left)/2;
            boolean cur = isBadVersion(mid);
            if(cur==true && isBadVersion(mid-1)==false){
                return mid;
            }else if(cur =false){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return -1;
    }

    private boolean isBadVersion(int cur)
    {
        if(cur == 4){
            return true;
        }
        return false;
    }
}
