import java.util.ArrayList;
import java.util.List;

public class AllPremutationsOfString {
    static List<String> ans = new ArrayList<>();
    public static void main(String[] args) {
        String s = "aac";
        dfs(s  , "");
        System.out.println(ans);
    }

    private static void dfs(String s, String curr) {

        if(s.isEmpty()) {
            ans.add(curr);
            return;
        }

        for (int i = 0 ; i < s.length() ; i++ ) {
            if(i == 0 || s.charAt(i) != s.charAt(i - 1)) {
                dfs(s.substring(0, i) + s.substring(i + 1)
                        , curr + s.charAt(i));
            }
        }

    }
}
