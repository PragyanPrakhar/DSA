class Solution {
    public int findMaxLength(int[] nums) {
        // int zc=0;
        // int oc=0;
        // int res=0;
        // int[] ps=new int[nums.length];
        // ps[0]=nums[0];
        // for(int i=1;i<nums.length;i++)
        // {
        //     ps[i]=nums[i]+ps[i-1];
        // }
        // for(int i=ps.length-1;i>=0;i--)
        // {
        //     if(i%2==0) continue;
        //     if(ps[i]==(i+1)/2)
        //     {
        //         return i+1;
        //     }
        // }
        // return 0;
        // int res=0;
        // for(int i=0;i<nums.length;i++)
        // {
        //     int zc=0;
        //     int oc=0;

        //     for(int j=i;j<nums.length;j++)
        //     {
        //         if(nums[j]==0)
        //         {
        //             zc++;
        //         }
        //         else if(nums[j]==1)
        //         {
        //             oc++;
        //         }
        //         if(zc==oc)
        //         {
        //             res=Math.max(res,j-i+1);
        //         }
        //     }

        // }
        // return res;
         HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int sum = 0;
        map.put(0, -1); // Initialize the map with sum 0 at index -1

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                sum--;
            } else {
                sum++;
            }

            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxLen;
    }

}