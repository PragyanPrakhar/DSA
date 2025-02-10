//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        sc.nextLine();        // Consume the newline character

        while (t-- > 0) {
            String input = sc.nextLine();

            // Replace ][ with ],[
            input = input.replace("][", "],[");

            ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
            String[] rows = input.split("],\\s*\\[");

            for (String row : rows) {
                row = row.replaceAll("[\\[\\]]", ""); // Remove any surrounding brackets
                ArrayList<Integer> intRow = new ArrayList<>();
                for (String num : row.split(",")) {
                    intRow.add(Integer.parseInt(num.trim()));
                }
                mat.add(intRow);
            }

            Solution obj = new Solution();
            ArrayList<String> result = obj.findPath(mat);

            if (result.isEmpty()) {
                System.out.println("[]");
            } else {
                for (String res : result) {
                    System.out.print(res + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    // Function to find all possible paths
    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        // code here
        ArrayList<String> ans=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        findingPaths(ans,0,0,mat,sb);
        Collections.sort(ans);
        return ans;
    }
    private void findingPaths(ArrayList<String> ans,int row,int col,ArrayList<ArrayList<Integer>> mat,StringBuilder temp)
    {
        if(row==mat.size()-1 && col==mat.get(0).size()-1)
        {
             ans.add(temp.toString());
             return ;
        }
        mat.get(row).set(col,0);
        if(row<mat.size()-1 && mat.get(row+1).get(col)==1)
        {
            // mat.get(row+1).set(col,2); //visited mark
            temp.append('D');
            findingPaths(ans,row+1,col,mat,temp);
            // mat.get(row+1).set(col,1);  // unvisited mark
            temp.deleteCharAt(temp.length()-1);
        }
        if(row>0 && mat.get(row-1).get(col)==1)
        {
            // mat.get(row-1).set(col,2);
            temp.append('U');
            findingPaths(ans,row-1,col,mat,temp);
            // mat.get(row-1).set(col,1);
            temp.deleteCharAt(temp.length()-1);
        }
        if(col>0 && mat.get(row).get(col-1)==1)
        {
            // mat.get(row).set(col-1,2);
            temp.append('L');
            findingPaths(ans,row,col-1,mat,temp);
            // mat.get(row).set(col-1,1);
            temp.deleteCharAt(temp.length()-1);
        }
        if(col<mat.get(0).size()-1 && mat.get(row).get(col+1)==1)
        {
            // mat.get(row).set(col+1,2);
            temp.append('R');
            findingPaths(ans,row,col+1,mat,temp);
            // mat.get(row).set(col+1,1);
            temp.deleteCharAt(temp.length()-1);
        }
        mat.get(row).set(col,1);
    }

}