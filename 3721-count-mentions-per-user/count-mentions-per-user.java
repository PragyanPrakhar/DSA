class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {

        int[] ans = new int[numberOfUsers];

        Collections.sort(events, (a, b) -> {
            int t1 = Integer.parseInt(a.get(1));
            int t2 = Integer.parseInt(b.get(1));
            if (t1 != t2) return t1 - t2;
            return a.get(0).equals("OFFLINE") ? -1 : 1;
        });

        Set<Integer> online = new HashSet<>();
        Map<Integer, Integer> offline = new HashMap<>();

        for (int i = 0; i < numberOfUsers; i++) online.add(i);

        for (List<String> e : events) {
            String type = e.get(0);
            int time = Integer.parseInt(e.get(1));

            // bring users back online
            Iterator<Map.Entry<Integer, Integer>> it = offline.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, Integer> entry = it.next();
                if (time >= entry.getValue() + 60) {
                    online.add(entry.getKey());
                    it.remove();
                }
            }

            if (type.equals("MESSAGE")) {
                String target = e.get(2);

                if (target.equals("ALL")) {
                    for (int i = 0; i < numberOfUsers; i++) ans[i]++;
                } 
                else if (target.equals("HERE")) {
                    for (int user : online) ans[user]++;
                } 
                else {
                    for (String u : target.split(" ")) {
                        int user = Integer.parseInt(u.substring(2));
                        ans[user]++;
                    }
                }
            } 
            else { // OFFLINE
                int user = Integer.parseInt(e.get(2));
                online.remove(user);
                offline.put(user, time);
            }
        }

        return ans;
    }
}
