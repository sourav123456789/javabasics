public class MaxProfit {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2, 5};
        int x = 1;
        int y = 1;
        int z = 1;

        int ans = dfs(arr, x, y, z, 0);
        System.out.println(ans);
    }

    private static int dfs(int[] arr, int x, int y, int z, int i) {
        if (i > arr.length - 1) {
            return 0;
        }

        // at any point we have the option to skip the element
        int ans = dfs(arr, x, y, z, i + 1);

        // choose 3 size array
        if (z > 0 && i + 2 <= arr.length - 1) {
            ans = Math.max(ans,  arr[i] + arr[i + 1] + arr[i + 2] + dfs(arr, x, y, z - 1, i + 3));
        }

        if (y > 0 && i + 1 <= arr.length - 1) {
            ans = Math.max(ans,  arr[i] + arr[i + 1] + dfs(arr, x, y - 1, z, i + 2));
        }

        if (x > 0 && i <= arr.length - 1) {
            ans = Math.max(ans, arr[i] + dfs(arr, x - 1, y, z, i + 1));
        }
        return ans;
    }
}
