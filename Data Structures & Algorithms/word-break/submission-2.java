class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dictionary = new HashSet<>(wordDict);

        int maxWordLength = 0;
        for (String word : wordDict) {
            maxWordLength = Math.max(maxWordLength, word.length());
        }

        Boolean[] dp = new Boolean[s.length() + 1];
        return solve(s, 0, dictionary, maxWordLength, dp);
    }

    private boolean solve(
        String s,
        int index,
        Set<String> dictionary,
        int maxWordLength,
        Boolean[] dp
    ) {
        if (index == s.length()) {
            return true;
        }

        if (dp[index] != null) {
            return dp[index];
        }

        int endLimit = Math.min(s.length(), index + maxWordLength);

        for (int end = index + 1; end <= endLimit; end++) {
            String word = s.substring(index, end);

            if (dictionary.contains(word)
                    && solve(s, end, dictionary, maxWordLength, dp)) {
                return dp[index] = true;
            }
        }

        return dp[index] = false;
    }
}
