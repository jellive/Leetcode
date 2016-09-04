public class Solution {
    public int[] twoSum(int[] numbers, int target) {
            // Start typing your Java solution below
            // DO NOT write main() function
            HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
            int[] r=new int[2];
            for(int i=0;i<numbers.length;i++) {
                int j=target-numbers[i];
                if(h.containsKey(j)) {
                    r[0]=h.get(j);
                    r[1]=i;
                    break;
                }
                else h.put(numbers[i],i);
            }
            return r;
    }
}
