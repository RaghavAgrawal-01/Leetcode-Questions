// class Solution {
//     public String countAndSay(int n) {
//         if (n == 1) return "1";
//         String result = "1";
//         for(int i = 2; i <= n; i++)
//         {
//             StringBuilder sb = new StringBuilder();
//             int count = 1;
//             for(int j = 1; j < result.length(); j++)
//             {
//                 if(result.charAt(j) == result.charAt(j - 1))
//                 {
//                     count++;
//                 }
//                 else
//                 {
//                     sb.append(count).append(result.charAt(j - 1));
//                     count = 1;
//                 }
//             }        
//             sb.append(count).append(result.charAt(result.length() - 1));
//             result = sb.toString();
//         }
//         return result;
//     }
// }








//Approach (Simple Recursion)
//T.C : O(2^n)
//S.C : O(2^n)
class Solution {
    public String countAndSay(int n) {
        if(n == 1) {
            return "1";
        }
        String say = countAndSay(n - 1);
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < say.length(); i++)
        {
            int count = 1;
            char ch = say.charAt(i);
            while(i < say.length() - 1 && say.charAt(i) == say.charAt(i + 1)) {
                count++;
                i++;
            }
            result.append(count).append(ch);
        }
        return result.toString();
    }
}