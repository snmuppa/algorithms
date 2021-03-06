/**
There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].

Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.

 

Example 1:

Input: [[10,20],[30,200],[400,50],[30,20]]
Output: 110
Explanation: 
The first person goes to city A for a cost of 10.
The second person goes to city A for a cost of 30.
The third person goes to city B for a cost of 50.
The fourth person goes to city B for a cost of 20.

The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
 

Note:

1 <= costs.length <= 100
It is guaranteed that costs.length is even.
1 <= costs[i][0], costs[i][1] <= 1000
*/

class TwoCityScheduling {
    class CostComparator implements Comparator<int[]>{
        @Override
        public int compare(int[] left, int[] right){
            return ((left[0] - left[1]) - (right[0] - right[1]));
        }
    }
    
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new CostComparator());
        
        var result = 0;
        var halfWayIndex = costs.length / 2;
        
        for(int i = 0; i < halfWayIndex; i++) {
            result += (costs[i][0] + costs[i + halfWayIndex][1]);
        }
        
        return result;
    }
}
