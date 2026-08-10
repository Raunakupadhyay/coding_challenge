class Solution {
    public int characterReplacement(String s, int k) {
        int freq[]=new int[26];
        int l=0;
        int maxfreq=0;
        int len=0;
        for(int r=0;r<s.length();r++){
            int idx=s.charAt(r)-'A';
            freq[idx]++;
            maxfreq=Math.max(maxfreq,freq[idx]);
            while((r-l+1)-maxfreq >k){
                freq[s.charAt(l)-'A']--;
                l++;
            }
            len=Math.max(len,r-l+1);
        }
        return len;
        
   
    }
}