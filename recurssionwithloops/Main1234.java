import java.util.ArrayList;
import java.util.List;

public class Main1234 {
    static List<List<String>> ans = new ArrayList<>();
    public static void main(String[] args) {
        String s = "abc";
        List<String> curr = new ArrayList<>();
        dfs(s , 0 , curr);
        System.out.println(ans);
    }

    private static void dfs(String s , int start , List<String> curr) {

        if(start > s.length() - 1) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start ; i < s.length() ; i++) {
            curr.add(s.substring(start , i + 1));
            dfs(s , start + 1 , curr);
            curr.remove(curr.size() - 1);
        }
    }
}
