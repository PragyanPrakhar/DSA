class Solution {
    public int nextBeautifulNumber(int n) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int low=n+1;
        int high=1_000_000;
        int ans=-1;
        int num=n+1;
        while (true){
            if(isBalanced(num)){
                return num;
            }
            num++;
        }
        // return -1;
    }
    private boolean isBalanced(int n){
        HashMap<Integer,Integer> hm=new HashMap<>();
        int temp=n;
        while(temp!=0){
            int rem = temp % 10;
            // hm.put(rem,hm.getOrDefault(rem,0)+1);
            if(!hm.containsKey(rem)) hm.put(rem,1);
            else hm.put(rem,hm.get(rem)+1);
            temp = temp / 10;
        }

        for (Map.Entry<Integer,Integer> entry:hm.entrySet()){
            int key=entry.getKey();
            if (entry.getValue() != key){
                return false;
            }
        }
        return true;
    }
}