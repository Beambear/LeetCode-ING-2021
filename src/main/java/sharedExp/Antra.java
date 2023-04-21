package sharedExp;

import java.util.HashMap;
import java.util.Map;

/*

 */
public class Antra {
    /**
     * 1.在一个String里找出每个字母的出现次数，存入HashMap
     * input: ABCDCCCDAA
     * output: {A = 3, B = 1, C = 4, D = 2}
     */
    public Map charMapAndCount(String input){
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<input.length();i++){
            char cur = input.charAt(i);
            if(map.containsKey(cur)){
                int count = map.get(cur)+1;
                map.put(cur,count);
            }else{
                map.put(cur,1);
            }
        }
        return map;
    }

    /**
     * 2.Reverse String
     */
    public void reverseString(char[] s) {
        int mid = s.length/2;
        int i=0;
        int j=s.length-1;
        while(i<mid && j >=mid){
            char temp = s[i];
            s[i]=s[j];
            s[j]=temp;
            i++;
            j--;
        }
    }
    ////GPT优化///
    public String reverseStringGPT(String str) {
        // 将字符串转化为字符数组
        char[] chars = str.toCharArray();

        // 定义双指针，一个指向字符串头部，一个指向字符串尾部
        int left = 0, right = str.length() - 1;

        // 循环交换头部和尾部的字符，直到双指针相遇或者跨过中点
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        // 将字符数组转化为字符串并返回
        return new String(chars);
    }

    /**
     * 3.Find the largest and second-largest elements in the input array, and return them as an array of length two.
     */

    public Integer[] findTwoLargest(int[] input){
        Integer[] res = new Integer[2];
        res[0]=null;
        res[1]=null;
        for(int i=0;i<input.length;i++){
            int cur = input[i];
            if(res[0]==null || cur >= res[0]){
                res[1] = res[0];
                res[0] = cur;
            }else if(res[1]==null || cur > res[1]){
                res[1]=cur;
            }
        }
        return res;
    }

    /**
     * 4.Find the unique char in string
     */
    public char findUniqueChar(String input){
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<input.length();i++){
            char cur = input.charAt(i);
            if(map.containsKey(cur)){
                int count = map.get(cur)+1;
                map.put(cur,count);
            }else{
                map.put(cur,1);
            }
        }
        char res = ' ';
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            if(entry.getValue() == 1){
                res = entry.getKey();
                break;
            }
        }
        return res;
    }

    /**
     * 5.Find the unique integers
     */
    public int findUniqueInt(int[] nums){
        Map<Integer,Boolean> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int cur = nums[i];
            if(map.containsKey(cur)){
                map.put(cur,false);
            }else{
                map.put(cur,true);
            }
        }

        int res = 0;
        for(Map.Entry<Integer,Boolean> entry: map.entrySet()){
            if(entry.getValue() == true ){
                res= entry.getKey();
                break;
            }
        }
        return res;
    }

    /**
     * 6. Subarray sum Equals K
     */
}
