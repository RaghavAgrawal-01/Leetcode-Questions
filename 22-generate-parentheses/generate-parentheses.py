class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        sol = []
        ans = []
        
        def backtrack(num_open, num_close):
            if num_open == num_close==n:
                ans.append(''.join(sol))
                return

            if num_open < n:
                sol.append('(')
                backtrack(num_open+1, num_close)
                sol.pop()
            
            if num_close < num_open:
                sol.append(')')
                backtrack(num_open, num_close+1)
                sol.pop()
        
        backtrack(0, 0)
        return ans