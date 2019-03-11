package com.gy.datastructure.stack;


/**
 * 分隔符匹配问题
 * 栈通常用于分隔符的匹配。分隔符匹配的问题就是在一段文本中’[’和’]’、‘{’‘}’、‘(’)‘’要成对的出现。
 * 我们可以这么考虑：{、(、[一定是在]、)、}前面出现，那么我们遇到左面的分隔符就可以把它们压入栈中，碰到右面的分隔符就弹出栈顶元素并进行比较，
 * 如果不相等或者栈已经为空，那么就不匹配。当然，循环完了也要检查栈是否为空，如果不为空，那么说明左面的分隔符多了，也是不匹配的。
 */
public class BracketChecker {

    private String input;

    public BracketChecker(String in) {
        input = in;
    }

    //check 分隔符是否匹配
    public void check() {
        int stackSize = input.length();
        MyStack theStack = new MyStack(stackSize);
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '{':
                case '[':
                case '(':
                    theStack.push(ch);
                    break;
                case '}':
                case ']':
                case ')':
                    if (!theStack.isEmpty()) {
                        char chx = theStack.pop();
                        if ((ch == '}' && chx != '{') ||
                                (ch == ')' && chx != '(') ||
                                (ch == ']' && chx != '[')) {
                            System.out.println("error char at " + i);
                        }
                    } else {
                        System.out.println("error char at " + i);
                    }
                    break;
                default:
                    break;
            }
        }

        if (!theStack.isEmpty()) {
            System.out.println("error missing right delimiter");
        }


    }


    public static void main(String[] args) {
        new BracketChecker("(sah[fdjs[([])])").check();
    }
}