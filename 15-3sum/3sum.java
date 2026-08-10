// class Solution {
//     public List<List<Integer>> threeSum(int[] arr) {
//         if (arr == null || arr.length < 3) return new ArrayList<>();
//     // Sort the elements
//     Arrays.sort(arr);
//     Set<List<Integer>> result = new HashSet<>();
//     // Now fix the first element and find the other two elements
//     for (int i = 0; i < arr.length - 2; i++)
//     {
//       // Find other two elements using Two Sum approach
//       int left = i + 1;
//       int right = arr.length - 1;
//       while (left < right) {
//         int sum = arr[i] + arr[left] + arr[right];
//         if (sum == 0) {
//           // Add the set, and move to find other triplets
//           result.add(Arrays.asList(arr[i], arr[left], arr[right]));
//           left++;
//           right--;
//         } else if (sum < 0)
//           left++;
//         else
//           right--;
//       }
//     }
//     return new ArrayList<>(result);
//     }
// }





class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res  = new ArrayList<>();
        Arrays.sort(nums);
        for(int i= 0;i < nums.length; i++)
        {
            if(nums[i] > 0)
            {
                continue;
            }
            if(i > 0 && nums[i]==nums[i-1])
            {
                continue;
            }
            int left = i+1;
            int right = nums.length-1;
            int target = -nums[i];
            while(left < right){
                if(nums[left]+nums[right]>target){
                    right--;
                }else if (nums[left]+nums[right] < target){
                    left++;
                }else{
                    List<Integer> tmp = new ArrayList<>(3);
                    tmp.add(nums[i]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    res.add(tmp);
                    while(left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    left++;
                     while(left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    right--;
                }
            }
        }
        return res;
    }
}