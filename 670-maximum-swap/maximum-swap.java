class Solution {
    public int maximumSwap(int num) {
        ArrayList<Integer> arr = new ArrayList<>();
        int temp = num;
        while (temp != 0) {
            arr.add(temp % 10);
            temp /= 10;
        }
        Collections.reverse(arr);
        int n = arr.size();
        for (int i = 0; i < n; i++) {
            int maxDigit = arr.get(i);
            int swapIdx = -1;
            for (int j = i + 1; j < n; j++) {
                if (arr.get(j) >= maxDigit) {
                    if (swapIdx == -1 || arr.get(j) >= arr.get(swapIdx)) {
                        maxDigit = arr.get(j);
                        swapIdx = j;
                    }
                }
            }
            if (swapIdx != -1 && arr.get(swapIdx) > arr.get(i)) {
                int tmp = arr.get(i);
                arr.set(i, arr.get(swapIdx));
                arr.set(swapIdx, tmp);
                break;
            }
        }
        int number = 0;
        for (int digit : arr) {
            number = number * 10 + digit;
        }
        return number;
    }
}
