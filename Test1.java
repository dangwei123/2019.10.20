1.
我们把符合下列属性的数组 A 称作山脉：

A.length >= 3
存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/peak-index-in-a-mountain-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int left=0;
        int right=A.length-1;
        while(left<=right){
            if(A[left]>A[left+1]){
                return left;
            }
            if(A[right]>A[right-1]){
                return right;
            }
            left++;
            right--;
        }
        return 0;
    }
}

2.
罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。

字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/roman-to-integer
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int romanToInt(String s) {
        int sum=0;
        int i=0;
        while(i<s.length()){
            char c=s.charAt(i);
             switch(c){
                 case'M':
                     sum+=1000;
                     break;
                 case'D':
                     sum+=500;
                     break;
                 case'C':
                     sum+=100;
                     break;
                 case'L':
                     sum+=50;
                     break;
                 case'X':
                     sum+=10;
                     break;
                 case'V':
                     sum+=5;
                     break;
                 case'I':
                     sum+=1;
                     break;
                 default:
                     break;
             }
            if(i<s.length()-1){
                if(s.charAt(i)=='C'&&(s.charAt(i+1)=='D'||s.charAt(i+1)=='M')){
                sum-=200;
            }if(s.charAt(i)=='X'&&(s.charAt(i+1)=='L'||s.charAt(i+1)=='C')){
                sum-=20;
            }if(s.charAt(i)=='I'&&(s.charAt(i+1)=='V'||s.charAt(i+1)=='X')){
                sum-=2;
            }
            }
            i++;
        }
        return sum;
    }
}

3.
有一个数组，其中的值符合等差数列的数值规律，也就是说：

在 0 <= i < arr.length - 1 的前提下，arr[i+1] - arr[i] 的值都相等。
我们会从该数组中删除一个 既不是第一个 也 不是最后一个的值，得到一个新的数组  arr。

给你这个缺值的数组 arr，请你帮忙找出被删除的那个数。

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/missing-number-in-arithmetic-progression
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int missingNumber(int[] arr) {
        Arrays.sort(arr);
       int a=Math.abs(arr[arr.length-1]-arr[0])/arr.length;
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            if(arr[left+1]-arr[left]!=a){
                return arr[left]+a;
            }if(arr[right]-arr[right-1]!=a){
                return arr[right]-a;
            }
            left++;
            right--;
        }
        return 0;
    }
}

4.
给定一个矩阵 A， 返回 A 的转置矩阵。

矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。

 class Solution {
    public int[][] transpose(int[][] A) {
        int[][] res=new int[A[0].length][A.length];
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                res[j][i]=A[i][j];
            }
        }
        return res;
    }
}