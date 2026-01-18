class Solution:
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        # We have a number of boats. boats can hold at most 2 people up to max weight (limit)
        # we want to sort out the MIN amount of boats.
        # does it make sense to sort then 2 pointer?
        # start with big ppl, if too big move right, otherwise try and add?

        left, right = 0, len(people) - 1

        num_boats = 0

        people.sort()

        while left<=right:
            # 2 cases: either a) over limit if 2 people, in which case put heavy person in and move right ptr
            # or b), they can fit in or at limit, so put both people in and iter
            if (people[left]+people[right]) > limit:
                right-=1
                num_boats+=1
            
            else:
                left+=1
                right-=1
                num_boats+=1

        return num_boats

        