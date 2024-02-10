import java.util.Scanner;

public class Q5New {

    public static int n;
    public static String[] cards;

    public static void main(String[] Args) {

        // Get input.
        Scanner stdin = new Scanner(System.in);
        n = stdin.nextInt();
        cards = new String[n];
        for (int i=0; i<n; i++)
            cards[i] = stdin.next();

        // Set up brute force and output solution.
        int[] perm = new int[4];
        boolean[] used = new boolean[4];
        int res = eval(perm, used, 0);
        System.out.println(res);
    }

    public static int eval(int[] perm, boolean[] used, int k) {

        // Filled in our permutation, now try all 16 orderings (up, down, up, up) etc.) and
        // return the best answer for this permutation.
        if (k == perm.length) {
            int res = 52;
            for (int i=0; i<16; i++)
                res = Math.min(res, solve(perm, i));
            return res;
        }

        int res = 52;

        // Usual permutation algorithm...
        for (int i=0; i<perm.length; i++) {
            if (!used[i]) {
                perm[k] = i;
                used[i] = true;
                int tmp = eval(perm, used, k+1);
                res = Math.min(res,  tmp);
                used[i] = false;
            }
        }

        // Best we found.
        return res;
    }

    public static int solve(int[] perm, int mask) {

        // Unroll the mask so we can see which list is up or down.
        int[] up = new int[4];
        for (int i=0; i<4; i++)
            up[i] = (mask&(1<<i)) != 0 ? 1 : 0;

        // "Resort" the sequence based on the up down flags.
        int[] seq = getSequence(perm, up);

        // Set up LIS DP.
        int[] dp = new int[n];
        dp[0] = 1;
        int res = 1;

        // Run DP for LIS.
        for (int i=1; i<n; i++) {
            dp[i] = 1;
            for (int j=0; j<i; j++)
                if (seq[j] < seq[i])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            res = Math.max(res,  dp[i]);
        }

        // We have to move all cards NOT in the LIST.
        return n-res;
    }

    // Return the "resorted" version of the cards based on the up down orderings of each suit.
    public static int[] getSequence(int[] perm, int[] up) {

        int[] res = new int[n];
        for (int i=0; i<n; i++)
            res[i] = cardval(perm, up, cards[i]);
        return res;
    }

    // We return the integer value of each card based on the permutation and the up down orientation.
    public static int cardval(int[] perm, int[] up, String s) {

        // Convert to numbers.
        int num = getNum(s.charAt(0));
        int suit = getSuit(s.charAt(1));

        // Calculate where this suit lies.
        int adjustSuit = 0;
        for (int i=0; i<perm.length; i++)
            if (suit == perm[i])
                adjustSuit = i;

        // Flip if up is 1...
        if (up[adjustSuit] == 1) num = 12 - num;

        // This is our mapped number.
        return 13*adjustSuit + num;
    }

    public static int getSuit(char c) {
        if (c == 'c') return 0;
        if (c == 'd') return 1;
        if (c == 'h') return 2;
        return 3;
    }

    public static int getNum(char c) {
        if (c >= '2' && c <= '9') return c - '2';
        if (c == 'T') return 8;
        if (c == 'J') return 9;
        if (c == 'Q') return 10;
        if (c == 'K') return 11;
        return 12;
    }
}
