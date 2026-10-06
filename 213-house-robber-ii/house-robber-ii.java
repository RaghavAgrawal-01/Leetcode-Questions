class Solution {
    public int solve(int[] nums){
        int n = nums.length;
        int prev2 = 0;
        int prev1 = nums[0];
        for(int i=1; i<n; i++){
            int inc = prev2 + nums[i];
            int exc = prev1 + 0;
            int ans = Math.max(inc, exc);
            prev2 = prev1;
            prev1 = ans;
        }
        return prev1;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int[] first= new int[n-1];
        int[] second= new int[n-1];
        for(int i=0; i<n-1; i++){
            first[i] = nums[i];
        }
        for(int i=1; i<n; i++){
            second[i-1] = nums[i];
        }
        return Math.max(solve(first), solve(second));
    }
}