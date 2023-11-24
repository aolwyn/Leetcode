class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        /*Algorithm:
        - we can walkthrough the array, change capacity based on plant needs.
        - if we have enough water, we can just water and decrement current capacity.
        - if we don't, we walk back (2*length +1) and then decrease cap by capacity - watering req.
        */
        int steps = 0;
        int cap = capacity;

        for(int i = 0; i < plants.length; i++){
            if(cap >= plants[i]){
                cap -= plants[i];
                steps++;
            }else{
                steps+= (2*i)+1;
                cap =capacity - plants[i];
            }
        }
        return steps;
    }
}