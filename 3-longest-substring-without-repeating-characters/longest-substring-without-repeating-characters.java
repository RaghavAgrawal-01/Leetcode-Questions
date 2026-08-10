class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] fr = new int[256];
        int max = 0, st=0;
        for(int end=0; end<s.length(); end++) 
        {
            char ch = s.charAt(end);
            fr[ch]++;
            while(fr[ch] > 1)
            {
                char ch2 = s.charAt(st++);
                fr[ch2]--;
            }
            int size=end-st+1;
            max = Math.max(max, size);
        }
        return max;
    }
}