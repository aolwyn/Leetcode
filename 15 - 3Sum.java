class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*Algorithm:
        - this problem wants us to find sets of triplets that sum to a target value of 0.
        - the input array is not sorted and the solution must no contain duplicates and can be returned in any order.
        - because the solution does not care about order, we can sort the array at the start to help avoid duplicates later.
        - the general algorithm is to sort the array and then proceed with 2 pointer to find triplets. 
        - Algorithm is as follows:
            --> we enumerate the first element of the triplet nums[i] for 0<= i <= n-2,
            and look for j and k such that nums[i] +nums[j] + nums[k] == 0.
            -->  if i > 0 and nums [i] == nums[i-1] it means that the element currently enumerated is the same as the previous element, we can skip it directly, because it will not produce new results.
            --> if nums[i] is > 0, then the sum should never be 0 so we can just skip iteration
            --> otherwise, set left and right pointers to be the bounds. adjust left and right pointer if sum is > or < 0
            --> key thing to note is we don't want to break out of the outer loop; we want to keep iterating. so in order to do so, we need to get out of the duplicates for left and right pointer's val
            NOTE: with a sorted array, once we hit values above 0, we shouldnt be proceeding any longer as we wont find a triplet.
        */
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length < 3)
            return ans;

        Arrays.sort(nums);
        int n = nums.length;
        for(int i =0; i < n-2 && nums[i] <= 0; i++){
            if(i > 0 && nums[i-1] == nums[i]){//this checks duplicates
                continue;
            }
            int j = i+1;
            int k = n -1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < 0){
                    j++;

                }else if(sum > 0){
                    k--;
                }else{
                    ans.add(List.of(nums[i],nums[j],nums[k])); 
                    //increment and decrement L+R pointer to avoid duplicate and start at new value
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j-1]){
                        j++;
                    }
                    while(k > j && nums[k] == nums[k+1]){
                        k--;
                    }
                }
            }
        }
        return ans;
    }
}