class Solution {
    public int countArrangement(int n) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        boolean used[] = new boolean[n];
        permutation(nums, arr, used, 0, new ArrayList<>());
        // int finalCount = 0;
        // for (ArrayList<Integer> ar : arr) {
        //     if (isBeautiful(ar))
        //         finalCount++;
        // }
        // return finalCount;
        return arr.size();
    }

    private boolean isBeautiful(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            if ((arr.get(i) % (i + 1) != 0) && (i + 1) % arr.get(i) != 0) {
                return false;
            }
        }
        return true;
    }

    private void permutation(int nums[], ArrayList<ArrayList<Integer>> arr, boolean used[], int idx,
            ArrayList<Integer> path) {
        if (idx == nums.length) {
            arr.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                if ((nums[i] % (path.size()+1)) == 0 || ((path.size()+1) % nums[i] == 0)) {
                    used[i] = true;
                    path.add(nums[i]);
                    permutation(nums, arr, used, idx + 1, path);
                    path.remove(path.size() - 1);
                    used[i] = false;
                }
            }
        }
    }
}