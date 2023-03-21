package practice;

import java.text.DecimalFormat;

/*
句子 是由若干个单词组成的字符串，单词之间用单个空格分隔，其中每个单词可以包含数字、小写字母、和美元符号 '$' 。如果单词的形式为美元符号后跟着一个非负实数，那么这个单词就表示一个价格。

例如 "$100"、"$23" 和 "$6.75" 表示价格，而 "100"、"$" 和 "2$3" 不是。
注意：本题输入中的价格均为整数。

给你一个字符串 sentence  和一个整数 discount 。对于每个表示价格的单词，都在价格的基础上减免 discount% ，并 更新 该单词到句子中。所有更新后的价格应该表示为一个 恰好保留小数点后两位 的数字。

返回表示修改后句子的字符串。

 

示例 1：

输入：sentence = "there are $1 $2 and 5$ candies in the shop", discount = 50
输出："there are $0.50 $1.00 and 5$ candies in the shop"
解释：
表示价格的单词是 "$1" 和 "$2" 。
- "$1" 减免 50% 为 "$0.50" ，所以 "$1" 替换为 "$0.50" 。
- "$2" 减免 50% 为 "$1" ，所以 "$1" 替换为 "$1.00" 。
示例 2：

输入：sentence = "1 2 $3 4 $5 $6 7 8$ $9 $10$", discount = 100
输出："1 2 $0.00 4 $0.00 $0.00 7 8$ $0.00 $10$"
解释：
任何价格减免 100% 都会得到 0 。
表示价格的单词分别是 "$3"、"$5"、"$6" 和 "$9"。
每个单词都替换为 "$0.00"。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/apply-discount-to-prices
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P2288_ApplyDiscountToPrices {
    //////////////
    //思路：
    //1.遍历整个String, 找到discount。 [不用遍历discount，Input 里给了]
    //  若discount == 0 -> return orig
    //  若discount !=
    //      遍历String， 替换价格
    //      注意$后可能有非数字，仅$+数字被看作价格。
    //////////////
    public String discountPrices(String sentence, int discount) {
//        if(discount == 0){        即便为0也要把int 替换成double
//            return sentence;
//        }
        double discountCal = (100-discount)/100;
        StringBuilder sb = new StringBuilder();
        char cur = ' ';
        for(int i=0;i<sentence.length();i++){
            cur = sentence.charAt(i);
            if(cur != '$'){
                sb.append(cur);
            }else{  //if At(i) is $
                sb.append(cur); //add $ into String builder
                if(i>0 && sentence.charAt(i-1)!= ' '){//if pre != ' ' -> this part is not price.
                    //do nothing
                }else {
                    StringBuilder temp = new StringBuilder();   //a new string to record next chars
                    int j=i+1;
                    while(i<sentence.length()-1){  //before next space
                        if(sentence.charAt(j) ==' '){
                            break;
                        }
                        temp.append(sentence.charAt(j));    //build a string contains chars after '$' before ' '
                        j++;
                        i++;
                    }

                    if(temp.toString().matches("\\d+")){    //if temp only contains ints
                        double price = Double.parseDouble(temp.toString()) * discountCal;//calculate price
                        DecimalFormat df = new DecimalFormat("0.00");
                        sb.append(df.format(price));
                    }else{  //if not only contains ints
                        sb.append(temp);
                    }
                }
            }
        }
        return sb.toString();
    }
}
