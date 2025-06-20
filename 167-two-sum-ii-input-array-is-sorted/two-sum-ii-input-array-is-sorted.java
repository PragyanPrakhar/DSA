class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // HashMap<Integer,Integer> hm=new HashMap<>();
        // for(int i=0;i<numbers.length;i++){
        //     int compl=target-numbers[i];
        //     if(hm.containsKey(compl)){
        //         return new int[]{hm.get(compl)+1,i+1};
        //     }
        //     hm.put(numbers[i],i);
        // }
        // return new int[]{-1,-1};
        
        int i=0;
        int j=numbers.length-1;
        while(i<=j){
            if(numbers[i]+numbers[j] < target) i++;
            else if(numbers[i]+numbers[j] > target) j--;
            else{
                return new int[]{i+1,j+1};
            }
        }
        return new int[]{-1,-1};
    }
}