class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dictionary = new HashSet<>();
        for (String word : wordDict) {
            dictionary.add(word);
        }
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return solve(s, 0, dictionary, dp) == 1;
    }

    private int solve(String s, int index, Set<String> dictionary, int[] dp) {
        if (index >= s.length())
            return 1;

        if(dp[index] != -1) return dp[index];
        for (int i = index; i < s.length(); i++) {
            if(dictionary.contains(s.substring(index,i+1)) && solve(s, i+1, dictionary, dp) == 1){
                return dp[index] = 1;
            }
        }
        return dp[index] = 0;
    }
}
