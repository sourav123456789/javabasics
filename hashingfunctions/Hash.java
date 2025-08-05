public class Hash {
    public static void main(String[] args) {
        String p = "soura";
        String t = "hi soura";
        boolean ans = isExist(p , t);
        System.out.println(ans);
    }

    private static boolean isExist(String p, String t) {
        int hash = getHash(p);
        t = t.replace(" " , "");
        for (int i = 0 ; i <= t.length() - p.length() ; i++) {
            if(p.charAt(0) == t.charAt(i)) {
                int currHash = getHash(t.substring(i , i + p.length()));
                if(hash == currHash && p.equals(t.substring(i , i + p.length()))) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int getHash(String p) {
        int mod = 1000000007;
        long hash = 0;
        int pow = 0;
        for (int i = p.length() - 1 ; i >= 0 ; i--) {
            int ch = (int)(p.charAt(i) - 'a');
            int ans = ((ch % mod) * (((int)Math.pow(26 , pow)) % mod)) % mod;
            hash = ((hash % mod) + (ans % mod)) % mod;
            pow++;
        }
        return (int)hash;
    }
}
