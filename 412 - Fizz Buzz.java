class Solution {
    public List<String> fizzBuzz(int n) {
        /*Algorithm:
        - 3 cases, use a flag to determine whether it should just be an integer or fizz buzzed.
        - use modular division and add to an String based on conditions, return accordingly.
         */

        List<String> returnedValues = new ArrayList<>();

        for(int i = 1; i < n+1; i++){
            String temp = "";
            int flag = 0;

            if(i % 3 == 0){
                temp = temp + "Fizz";
                flag = 1;
            }
             if(i % 5 == 0){
                temp = temp + "Buzz";
                flag = 1;
            }
            if(flag == 0){
                temp = temp + Integer.toString(i);
            }

            returnedValues.add(temp);
        }
        
        return returnedValues;
    }
}