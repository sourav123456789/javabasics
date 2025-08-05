public class LongestPallindromicSubstring {
    public static void main(String[] args) {
        String s1 = "babadada";
        String s = getLongestPallindrome(s1);
        System.out.println(s);
    }

    private static String getLongestPallindrome(String s1) {
        StringBuffer sb = new StringBuffer();
        sb.append("#");
        for (int i = 0; i < s1.length(); i++) {
            sb.append(s1.charAt(i));
            sb.append("#");
        }
        String s = sb.toString();
        int[] dp = new int[s.length()];
        int c = 0;
        int r = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i < r + c) {
                // optimize
                int mirror = c - (i - c);
                if (i + dp[mirror] < r + c) {
                    dp[i] = Math.min(dp[mirror], (r + c) - i);
                } else {
                    int count = Math.min(dp[mirror], (r + c) - i);
                    int p1 = i + dp[mirror] + 1;
                    int p2 = i - dp[mirror] - 1;

                    // expand

                    while (p1 < s.length() && p2 >= 0) {
                        if (s.charAt(p1) == s.charAt(p2)) {
                            count++;
                            p1++;
                            p2--;
                        } else {
                            break;
                        }
                    }

                    dp[i] = count;

                    if (i + dp[i] > r + c) {
                        c = i;
                        r = dp[i];
                    }
                }
            }

            else {
                // expand

                int p1 = i + 1;
                int p2 = i - 1;

                // expand
                int count = 0;

                while (p1 < s.length() && p2 >= 0) {
                    if (s.charAt(p1) == s.charAt(p2)) {
                        count++;
                        p1++;
                        p2--;
                    } else {
                        break;
                    }
                }

                dp[i] = count;

                if (i + dp[i] > r + c) {
                    c = i;
                    r = dp[i];
                }
            }
        }

        int index = -1;
        int length = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > length) {
                length = dp[i];
                index = i;
            }
        }

        return s.substring(index - dp[index], index + dp[index] + 1).replace("#", "");
    }

}
