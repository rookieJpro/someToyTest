package test;

/*
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 */

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        int max = 0;
        int count = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(')');
            }
            if(ch == ')'){
                if(stack.empty()){
                    count = 0;
                }
                if(!stack.empty()){
                char c = stack.pop();
                if(c==ch){
                    count += 2;
                    max = Math.max(max,count);
                }
                }
                
            }
        }
        return max;
    }
}