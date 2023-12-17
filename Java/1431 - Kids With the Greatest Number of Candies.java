class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        /*Algorithm:
        - we want to find the kids with values > the curr max after adding the extras.
        - 1 pass to find max or use Arrays.stream(candies).max().getAsInt();
        - or use 2 passes, 1 to find max then the other to find all valid
        */
        
        List<Boolean> valid = new ArrayList<>();
        int max = 0;
        for(int candy : candies){
            max = Math.max(candy, max);
        }
        for(int candy : candies){
            if(candy + extraCandies >= max){
                valid.add(true);
            }else{
                valid.add(false);
            }
        }

        return valid;
    }
}