package LeetCode.second_0628;

import java.util.HashMap;
import java.util.Stack;

/*
20. 有效的括号
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true
 */
public class Simple_20 {
    public boolean isValid(String s) {
        HashMap<Character, Character> hashMap = new HashMap<>();
        if (s.length() == 0) {
            return true;
        }
        hashMap.put('(', ')');
        hashMap.put('[', ']');
        hashMap.put('{', '}');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty() && !hashMap.containsKey(s.charAt(i))) {
                return false;
            } else if (hashMap.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if (hashMap.get(stack.peek()) == s.charAt(i)){
                stack.pop();
            } else
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "(]";
        System.out.println(new Simple_20().isValid(s));
    }
}
