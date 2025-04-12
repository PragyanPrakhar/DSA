public class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            rank.add(0);
            size.add(1);
        }
    }

    public int findUltimateParent(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ultimateParent = findUltimateParent(parent.get(node));
        parent.set(node, ultimateParent);
        return ultimateParent;
    }

    public void unionByRank(int u, int v) {
        int ultimateParentU = findUltimateParent(u);
        int ultimateParentV = findUltimateParent(v);
        if (ultimateParentU == ultimateParentV) {
            return;
        }
        if (rank.get(ultimateParentU) < rank.get(ultimateParentV)) {
            parent.set(ultimateParentU, ultimateParentV);
        } else if (rank.get(ultimateParentU) > rank.get(ultimateParentV)) {
            parent.set(ultimateParentV, ultimateParentU);
        } else {
            parent.set(ultimateParentV, ultimateParentU);
            rank.set(ultimateParentU, rank.get(ultimateParentU) + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int ultimateParentU = findUltimateParent(u);
        int ultimateParentV = findUltimateParent(v);
        if (ultimateParentU == ultimateParentV) {
            return;
        }
        if (size.get(ultimateParentU) < size.get(ultimateParentV)) {
            parent.set(ultimateParentU, ultimateParentV);
            size.set(ultimateParentV, size.get(ultimateParentV) + size.get(ultimateParentU));
        } else {
            parent.set(ultimateParentV, ultimateParentU);
            size.set(ultimateParentU, size.get(ultimateParentU) + size.get(ultimateParentV));
        }

    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        HashMap<String, Integer> hm = new HashMap<>();
        DisjointSet ds = new DisjointSet(accounts.size());
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                if (!hm.containsKey(accounts.get(i).get(j))) {
                    hm.put(accounts.get(i).get(j), i);
                } else {
                    ds.unionBySize(i, hm.get(accounts.get(i).get(j)));

                }
            }
        }
        ArrayList<String>[] mergedMail=new ArrayList[n];
        for(int i=0;i<n;i++){
            mergedMail[i]=new ArrayList<String>();
        }
        List<List<String>> ans=new ArrayList<>();
        for(Map.Entry<String,Integer> entry:hm.entrySet()){
            String mail=entry.getKey();
            int node=ds.findUltimateParent(entry.getValue());
            mergedMail[node].add(mail);
        }
        for(int i=0;i<n;i++){
            if(mergedMail[i].size()==0) continue;
            Collections.sort(mergedMail[i]);
            List<String> temp=new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String it:mergedMail[i]){
                temp.add(it);
            }
            ans.add(temp);
        }
        return ans;


    }
}