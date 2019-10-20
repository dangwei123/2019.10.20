1.
给定正整数 K，你需要找出可以被 K 整除的、仅包含数字 1 的最小正整数 N。

返回 N 的长度。如果不存在这样的 N，就返回 -1。

 class Solution {
    public int smallestRepunitDivByK(int K) {
        if(K%2==0||K%5==0){
            return -1;
        }
        int i=1;
        for(int a=1;a%K!=0;i++){
            a%=K;
            a=a*10+1;
        }
        return i;
    }
}

2.
给你两个长度相等的整数数组，返回下面表达式的最大值：

|arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|

其中下标 i，j 满足 0 <= i, j < arr1.length。

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-of-absolute-value-expression
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int max1=Integer.MIN_VALUE;
        int min1=Integer.MAX_VALUE;
         int max2=Integer.MIN_VALUE;
        int min2=Integer.MAX_VALUE;
         int max3=Integer.MIN_VALUE;
        int min3=Integer.MAX_VALUE;
        int max4=Integer.MIN_VALUE;
        int min4=Integer.MAX_VALUE;
      for(int i=0;i<arr1.length;i++){
          max1=Math.max(max1,arr1[i]+arr2[i]+i);
          min1=Math.min(min1,arr1[i]+arr2[i]+i);
          
          max2=Math.max(max2,arr1[i]+arr2[i]-i);
          min2=Math.min(min2,arr1[i]+arr2[i]-i);
          
          max3=Math.max(max3,arr1[i]-arr2[i]+i);
          min3=Math.min(min3,arr1[i]-arr2[i]+i);
          
          max4=Math.max(max4,arr1[i]-arr2[i]-i);
          min4=Math.min(min4,arr1[i]-arr2[i]-i);
      }
        return Math.max(Math.max(max1-min1,max2-min2),
                        Math.max(max3-min3,max4-min4));
    }
   
}

3.
你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。

给定一个数字 n，找出可形成完整阶梯行的总行数。

n 是一个非负整数，并且在32位有符号整型的范围内。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/arranging-coins
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int arrangeCoins(int n) {
        int count=0;
        int i=1;
        while(n-i>=0){
            n-=i;
            count++;
            i++;
        }
        return count;
    }
}
4.
冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。

现在，给出位于一条水平线上的房屋和供暖器的位置，找到可以覆盖所有房屋的最小加热半径。

所以，你的输入将会是房屋和供暖器的位置。你将输出供暖器的最小加热半径。

说明:

给出的房屋和供暖器的数目是非负数且不会超过 25000。
给出的房屋和供暖器的位置均是非负数且不会超过10^9。
只要房屋位于供暖器的半径内(包括在边缘上)，它就可以得到供暖。
所有供暖器都遵循你的半径标准，加热的半径也一样。
示例 1:

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/heaters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int res=0;
        int i=0;
        for(int x:houses){
            while(i<heaters.length&&x>heaters[i]){
                i++;
            }
            if(i==0){
                res=Math.max(res,heaters[i]-x);
            }else if(i==heaters.length){
                res=Math.max(res,houses[houses.length-1]-heaters[i-1]);
            }else{
                res=Math.max(res,Math.min(x-heaters[i-1],heaters[i]-x));
            }
        }
        return res;
    }
}