class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch: s.toCharArray())
        {
            if(!st.isEmpty() && isPair(st.peek(), ch)) st.pop();
            else st.push(ch);
        }
        return st.isEmpty();
    }
    Boolean isPair(char ch1, char ch2)
    {
        return (ch1=='(' && ch2==')') ||
        (ch1=='[' && ch2==']') ||
        (ch1=='{' && ch2=='}');
    }
}