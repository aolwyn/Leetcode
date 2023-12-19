class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>();
    private int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        /*Algorithm:
        - we are asked to find all subsets of an array nums but duplicates CAN exist.
        - need a method to keep track of seen elements.
            --> we can sort the array first.
        - we do our normal backtracking and add next element and when index >= length of nums then we stop.
        - for removing duplicates, after first call of helper, remove last element. 
        - while in bounds and value is same as previous, incrmeent index (until new val found) then call function again
        */
        if(nums.length == 0 || nums == null)
            return ans;
        this.nums = nums;
        Arrays.sort(nums);
        DFS(0);
        return ans;

    }

    private void DFS(int index){
        if(index >= nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
            
        temp.add(nums[index]);
        DFS(index+1);
        temp.remove(temp.size()-1);
        while(index+1 < nums.length && nums[index] == nums[index+1]){ //while valuue is still same
            index++;
        }
        DFS(index+1);
    }
}