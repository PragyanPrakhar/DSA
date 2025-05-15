public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int bit = n & 1;         // Get the last bit
            result <<= 1;            // Shift result left
            result |= bit;           // Add the extracted bit
            n >>= 1;                 // Shift n right to get next bit
        }
        return result;
        
    }
}