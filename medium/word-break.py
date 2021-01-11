class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp = [0] *( len(s) +1 )
        
        hashset = set(wordDict) 
        
        
        dp[0] =1 
        for i in range(0, len(s)):
            
            for j in range(i, -1, -1):
                
                # print(s[j:i+1] + " >>>>")
                if s[j : i+1] in wordDict and dp[j]:
                    dp[i+1] = 1
                    break 

        
        
        # print(dp)
        return dp[len(s)]

