class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
       /*Algorithm:
       - populate both hashsets to get only unique values.
       - iterate through each hashlist and populate unique values.
       - return lists.

       */
        List<Integer> unique1 = new ArrayList<>();
        List<Integer> unique2 = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for(int i = 0; i < nums1.length; i++){
            set1.add(nums1[i]);
        }
         for(int i = 0; i < nums2.length; i++){
            set2.add(nums2[i]);
        }

        for(int val : set1){
            if(!set2.contains(val)){
                unique1.add(val);
            }
        }
        for(int val : set2){
            if(!set1.contains(val)){
                unique2.add(val);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(unique1);
        ans.add(unique2);
        return ans;


    }
}