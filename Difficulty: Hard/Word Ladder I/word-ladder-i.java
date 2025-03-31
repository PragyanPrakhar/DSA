//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       
System.out.println("~");
}
    }
}

// } Driver Code Ends

class Pair{
    String word;
    int level;
    Pair(String word,int level){
        this.word=word;
        this.level=level;
    }
}
class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        HashSet<String> hs=new HashSet<>();
        Queue<Pair> q=new LinkedList<>();
        for(String word:wordList){
            hs.add(word);
        }
        q.add(new Pair(startWord,1));
        while(!q.isEmpty()){
            String word=q.peek().word;
            int level=q.peek().level;
            q.remove();
            if(word.equals(targetWord)){
                return level;
            }
            for(int i=0;i<word.length();i++){
                char chA[]=word.toCharArray();
                for(char ch='a';ch<='z';ch++){
                    chA[i]=ch;
                    String replacedWord=new String(chA);
                    if(hs.contains(replacedWord)){
                        q.add(new Pair(replacedWord,level+1));
                        hs.remove(replacedWord);
                    }
                }
            }
        }
        return 0;
    }
}