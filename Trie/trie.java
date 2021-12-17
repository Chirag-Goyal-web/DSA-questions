import java.io.*;

public class trie {

    public static class Trie {
        private class Node {
          Node[]childs;
          boolean isEnd;
    
          Node() {
            childs = new Node[26];
          }
        }
    
        final private Node root;

        public Trie() {
          root = new Node();
        }
    
        public void insert(String word) {
    
          Node curr = root;
          for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
    
            if (curr.childs[ch - 'a'] == null) {
              curr.childs[ch - 'a'] = new Node();
            }
            curr = curr.childs[ch - 'a'];
          }
          curr.isEnd = true;
        }
    
        public boolean search(String word) {
          Node curr = root;
    
          for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
    
            if (curr.childs[ch - 'a'] == null)return false;
            curr = curr.childs[ch - 'a'];
          }
    
          return curr.isEnd;
        }
    
        public boolean startsWith(String prefix) {
          Node curr = root;
    
          for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
    
            if (curr.childs[ch - 'a'] == null)return false;
            curr = curr.childs[ch - 'a'];
          }
    
          return true;
        }

      }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Trie obj = new Trie();

        while (read.ready()) {
            String inp[] = read.readLine().split(" ");

            if (inp[0].equals("insert")) {
                obj.insert(inp[1]);
            } 
            else if (inp[0].equals("search")) {
                System.out.println(obj.search(inp[1]));
            } 
            else if (inp[0].equals("startsWith")) {
                System.out.println(obj.startsWith(inp[1]));
            }
        }
    }
}
