class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        solve(s, 0, new ArrayList<>(), res);
        return res;
    }
    public void solve(String s, int start,
                      List<String> temp,
                      List<List<String>> res) {
        if(start == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int end = start; end < s.length(); end++) {
            if(isPalindrome(s, start, end)) {
                temp.add(s.substring(start, end + 1));
                solve(s, end + 1, temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }
    public boolean isPalindrome(String s, int left, int right) {
        while(left < right) {
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}