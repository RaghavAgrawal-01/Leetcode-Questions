class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums) set.add(i);
        for(int i=1; i<Integer.MAX_VALUE; i++){   
            System.out.println(i+ " " +(!set.contains(i)));
            if(!set.contains(i)) return i;
        }
        return -1;
    }
}