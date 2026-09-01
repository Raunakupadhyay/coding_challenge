class Solution {
    public int countPrefixes(String[] words, String s) {
        int count=0;
        for(String x:words){
            if(s.startsWith(x)) count++;
        }
        return count;
    }
}