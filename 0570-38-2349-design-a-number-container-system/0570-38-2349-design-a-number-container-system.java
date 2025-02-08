import java.util.*;

class NumberContainers {
    private HashMap<Integer, Integer> indexMap; // Stores index -> number
    private HashMap<Integer, PriorityQueue<Integer>> numHeapMap; // Stores number -> min-heap of indices

    public NumberContainers() {
        indexMap = new HashMap<>();
        numHeapMap = new HashMap<>();
    }

    public void change(int index, int number) {
        if (indexMap.containsKey(index)) {
            int oldNumber = indexMap.get(index);
            if (oldNumber == number) return; // No change needed
            
            // Remove index from old number's heap
            numHeapMap.get(oldNumber).remove(index);
            if (numHeapMap.get(oldNumber).isEmpty()) {
                numHeapMap.remove(oldNumber); // Clean up empty heaps
            }
        }
        
        // Update indexMap
        indexMap.put(index, number);
        
        // Add index to new number’s heap
        numHeapMap.putIfAbsent(number, new PriorityQueue<>());
        numHeapMap.get(number).offer(index);
    }

    public int find(int number) {
        return numHeapMap.containsKey(number) && !numHeapMap.get(number).isEmpty()
                ? numHeapMap.get(number).peek() 
                : -1;
    }
}
