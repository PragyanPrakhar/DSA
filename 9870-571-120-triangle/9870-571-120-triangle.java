class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = 0;
        int col = 0;
        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < triangle.size(); i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < triangle.get(i).size(); j++) {
                temp.add(-1);
            }
            dp.add(temp);
        }
        return ans(triangle, row, col, dp);
    }

    private int ans(List<List<Integer>> triangle, int row, int col, ArrayList<ArrayList<Integer>> dp) {
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }
        if (dp.get(row).get(col) != -1) {
            return dp.get(row).get(col);
        }
        int down = triangle.get(row).get(col) + ans(triangle, row + 1, col, dp);
        int diagonal = triangle.get(row).get(col) + ans(triangle, row + 1, col + 1, dp);
        int minPath = Math.min(down, diagonal);
        dp.get(row).set(col, minPath);
        return minPath;
    }
}
