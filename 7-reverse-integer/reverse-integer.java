// class Solution {
//     public int reverse(int x) {
//         long rev = 0;
//         while(x!=0)
//         {
//             int digit = x%10;
//             rev = rev*10 + digit;
//             x=x/10;
//             if(rev>Integer.MAX_VALUE || rev < Integer.MIN_VALUE)
//             {
//                 return 0;
//             }
//         }
//         return (int)rev;
//     }
// }


class Solution {
    public int reverse(int x) {
        int res = 0;
        while(x!=0)
        {
            int lastDigit = x%10;
            int currRes = res*10 + lastDigit;
            if((currRes - lastDigit)/10!=res) //currRes = res*10+lastDigit
            {
                return 0;
            }
            res = currRes;
            x/=10;
        }
        return res;
    }
}