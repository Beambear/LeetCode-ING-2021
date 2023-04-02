package practice;

import java.util.HashSet;
import java.util.Set;

/*
    1733. 需要教语言的最少人数
在一个由 m 个用户组成的社交网络里，我们获取到一些用户之间的好友关系。两个用户之间可以相互沟通的条件是他们都掌握同一门语言。

给你一个整数 n ，数组 languages 和数组 friendships ，它们的含义如下：

总共有 n 种语言，编号从 1 到 n 。
languages[i] 是第 i 位用户掌握的语言集合。
friendships[i] = [u​​​​​​i​​​, v​​​​​​i] 表示 u​​​​​​​​​​​i​​​​​ 和 vi 为好友关系。
你可以选择 一门 语言并教会一些用户，使得所有好友之间都可以相互沟通。请返回你 最少 需要教会多少名用户。

请注意，好友关系没有传递性，也就是说如果 x 和 y 是好友，且 y 和 z 是好友， x 和 z 不一定是好友。


示例 1：

输入：n = 2, languages = [[1],[2],[1,2]], friendships = [[1,2],[1,3],[2,3]]
输出：1
解释：你可以选择教用户 1 第二门语言，也可以选择教用户 2 第一门语言。
示例 2：

输入：n = 3, languages = [[2],[1,3],[1,2],[3]], friendships = [[1,4],[1,2],[3,4],[2,3]]
输出：2
解释：教用户 1 和用户 3 第三门语言，需要教 2 名用户。
 */
public class P1733_MinimumNumberOfPeopletoTeach {
    /////////////////
    //思路：
    //  每个语言为一层，每层为一个friendship的graph
    //  遍历graph的edge，确认当前语言是否可行
    //      edge可行->不进行任何操作
    //      edge不行->把不会该语言的用户'i'->boolean[i]=true
    //      最后统计每一层 boolean = true的人数
    //      人数最少的那层为需要教学次数最少的语言
    ////////////////
    //  边际考虑：
    //      m 属于[1,500] 一定会有用户，但可能会没edge，
    //      1 <= friendships.length <= 500， 至少会有一个friendship
    ////////////
    /*
        之前题目理解错误，不是选一种语言让所有人都用。而是选一种语言来教，如果两人本身就能沟通，那么则不需要教
     */
    public int minimumTeachingsA(int n,int[][] languages, int[][] friendships){
        int result = 501; //记录教学次数最小的语言编号
        int m = languages.length;   // user numbers
        for(int i=1;i<=n;i++){  //遍历每一种语言
            boolean[]   studyUser = new boolean[m];
            int curStudyCount = 0;

            for(int[] friendship:friendships){ //遍历Edge
                int userA = friendship[0]-1; //人是从1号开始编的，从0开始存的，所以需要-1
                int userB = friendship[1]-1;
                if(! isLearned(i,languages[userA]) && studyUser[userA]==false){
                    studyUser[userA]=true;  //这人不会，又没学
                    curStudyCount++;
                }
                if(! isLearned(i,languages[userB]) && studyUser[userB]==false){
                    studyUser[userB]=true;
                    curStudyCount++;
                }
            }
            result = Math.min(result,curStudyCount);
        }
        return result;
    }

    private boolean isLearned(int language, int[] userLanguages){
        for(int u:userLanguages){
            if(u==language){
                return true;
            }
        }
        return false;
    }

    /**
     * 正确理解题义后重做
     */

    /////////////////////
    //思路：
    //  同上把friendship看作graph，遍历edge
    //  判断edge两侧用户是否有用共同语言，
    //  有共同语言 -> 这条edge 两侧用户不用为此friendship学习新语言
    //  无共同语言 -> 用户A和B互相学习对方所有语言
    //  boolean[user][language] 来记录是否已经学会
    //  int[languageStudy] 来记录每个语言被学习的次数
    //
    //  1.先根据language填完 boolean[user][language]
    //  2.遍历friendship, 确认是否有共同语言
    //      有->不操作
    //      无->相互学习所有语言，
    //          更新boolean[user][language]
    //          更新int[languageStudy]
    //  3.遍历int[languageStudy],找到并返回最小数值
    ///////////////////////
    //  abilities要做成三维数组， abilities = new boolean[2][m+1][n+1];
    //  新增一个分ori 和 after study
    //  考虑是否能交流用ori，考虑是否要学习用after study
    ///////////////////
    public int minimumTeachingB(int n, int[][] languages, int[][] friendships){
        int m = languages.length;   //用户人数
        boolean[][][] abilities = new boolean[2][m+1][n+1];  //用户数 x 语言数 跟编号规则统一，编号没有0，所以+1
        int[] studyCount = new int[n+1];    //脚标规则统一

        //完成布尔表
        for(int user=1; user<=m;user++){//遍历每个人
            for(int i:languages[user-1]){    //遍历每个人语言能力
                abilities[0][user][i]=true;
                abilities[1][user][i]=true;
            }
        }

        //遍历friendships
        for(int[] friendship:friendships){
            int userA = friendship[0];  //脚标统一，不用-1
            int userB = friendship[1];

            boolean communicated = haveSharedLanguage(userA,userB,abilities);   //查找是否有共同语言
            System.out.println("userA:"+userA+", userB:"+userB+", communicated:"+communicated);
            if(!communicated){  //学会双方所有语言
                for(int i:languages[userA-1]){    //A会的所有语言，脚标-1因为是从0开排的
                    System.out.println(i+":"+abilities[userB][i]);
                    if(!abilities[1][userB][i]){   //B还没学过
                        System.out.println("userB study:"+i);
                        studyCount[i]++;    //学
                        abilities[1][userB][i]=true;//学会了
                    }
                }

                for(int i:languages[userB-1]){    //A学B
                    if(!abilities[1][userA][i]){
                        System.out.println("userA study:"+i);
                        studyCount[i]++;
                        abilities[1][userA][i]=true;
                    }
                }
            }
        }
        //完成所有教学
        int result=501;
        for(int i=1;i<n+1;i++){
            System.out.println("language:"+i+", studyCount:"+studyCount[i]+", result:"+result);
            result = Math.min(result,studyCount[i]);
        }
        return result;
    }

    private boolean haveSharedLanguage(int userA, int userB,boolean[][][] abilities){
        //布尔表[ori][用户标号][语言编号]
        //查询[userA][i]==true && [userB][i] == true;
        for(int i=1;i<abilities[0][0].length;i++){
            if(abilities[0][userA][i] && abilities[0][userB][i]){
                return true;
            }
        }
        return false;
    }

    /**
     * Chat GPT 根据 C++ 贪心算法 改java后的思路，
     * 同样把friendship看作graph.
     * 但是他新建了notCommunivated 集合来储存无法交流的朋友，
     * 而不是用三维boolean来管理交流关系。
     */
    ////////////////
    //思路：
    //  hash表储存无法完成交流的用户
    //  遍历好友关系，判断能否交流
    //      能 -> do nothing
    //      不能-> 需要学习一个共同语言，把两人都加进哈希表
    //     用int[] studyCount记录语言学习次数
    //  遍历哈希表的人，统计每种语言需要被学习的次数
    //  return 哈希大小-学习最多的语言人数。
    //  ？？？
    ///////////////
    public int minimumTeachingsC(int n, int[][] languages, int[][] friendships){
        // 无法完成交流，需要学习新语言的用户
        Set<Integer> studentUsers = new HashSet<>();

        ////遍历friendships，寻找需要学习的用户
        for(int[] friendship : friendships){
            int userA = friendship[0]-1;
            int userB = friendship[1]-1;
            boolean communicated = false;
            for(int i: languages[userA]){   //遍历userA的语言
                for(int j: languages[userB]){   //遍历userB的语言
                    if(i==j){   //有共同语言
                        communicated = true;
                        break;  //不再操作,跳出遍历B的循环
                    }
                }

                if (communicated){
                    break;  //不再操作，跳出遍历A的循环
                }
            }//完成A和B语言能力遍历

            if(!communicated){  //无法交流
                studentUsers.add(userA);
                studentUsers.add(userB);
            }
        }   //完成关系网遍历

        //统计在学生中，已经会某种语言的人数
        int[] abilities = new int[n]; //记录人数
        for(int student:studentUsers){
            for(int i:languages[student]){
                abilities[i-1]++; //记录他会这门语言
            }
        }

        //查找已会人数最多的语言
        int mostLearned =0;
        for(int ability:abilities){
            mostLearned = Math.max(ability,mostLearned);
        }

        return (studentUsers.size()-mostLearned);   //全部学生数 - 已会人数 = 需要教学的次数

    }
}
