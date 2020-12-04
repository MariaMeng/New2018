package Date.Mar;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author mengxiang
 * @date 20/3/12
 */

class Result {
    int idx;
    String tag;

    public int getIdx() {
        return idx;
    }

    public String getTag() {
        return tag;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}

public class Main {

    private static final String BAD_CHARACTER = "bad character in tag name";
    private static final String TOO_MANY_FEW_CHARS = "too many/few characters in tag name";
    private static final String EXPECTED = "expected ";
    private static final String NO_MATCHING = "no matching begin tag";
    private static final int MAX_LENGTH_TAG = 10;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int counter = 0;
        while (true) {
            counter++;
            String str = in.nextLine();
            try {
                int n = Integer.parseInt(str);
                if (n == 0) {
                    break;
                }
                String res = "OK";
                Stack<String> stack = new Stack<>();
                for (int i = 1; i <= n; i++) {
                    String line = in.nextLine();
                    Result result  = isSuccess(line, stack);
                    int idx = result.getIdx();
                    String tag = result.getTag();
                    if (idx > 0) {
                        res = "line " + i + ": " + getErrorMessage(idx, tag) + ".";
                    }
                }

                System.out.println("Test Case " + counter);
                System.out.println(res);

            } catch (Exception e) {
                System.out.println("str: " + str  + "." + e);
            }
        }

    }




    private static Result isSuccess(String line, Stack<String> stack) {
        Result res = new Result();
        boolean isTag = false;
        // 标记是否为结束字符
        boolean isEnd = false;

        int tagStart = 0;
        int tagNum = 0;
        // 1. 校验tag 是否有误
        char[] str = line.toCharArray();
        for (int i = 0; i < str.length; i++) {
            char c = str[i];
            if (c == '<') {
                isTag = true;
                tagNum = 0;
                tagStart = i + 1;
            } else if (c == '>') {

                // 没有开始字符
                if (!isTag) {
                    res.setIdx(1);
                    return res;
                }  else if (tagNum == 0 || tagNum > MAX_LENGTH_TAG) {
                    res.setIdx(2);
                    return res;
                }
                else {
                    isTag = false;
                    // 如果为结束tag，则与 stack中匹配
                    if (isEnd) {

                        if (stack.isEmpty()) {
                            res.setIdx(4);
                            return res;
                        }
                        String stackTag = stack.pop();
                        boolean isSame = diff(stackTag, line.substring(tagStart + 1, i));
                        // 与栈中弹出的元素相比是否一致
                        if (!isSame) {
                            res.setIdx(3);
                            res.setTag(stackTag);
                            return res;
                        }
                        isEnd = false;
                    }
                    // 如果不是结束tag, 则将 当前字符插入到栈中
                    else {
                        stack.push(line.substring(tagStart, i));
                    }
                }
            }
            // 非 < > 的情况
            else {

                // 如果在括号内则统计++，如果正文则直接跳过
                if (isTag) {
                    tagNum++;


                    // 校验是否为 / 字符
                    if (c == '/') {
                        isEnd = true;
                    }
                }
                // 如果正文直接跳过
            }
        }
        if (isTag) {
            res.setIdx(1);
            return res;
        }

        return res;
    }

    private static boolean diff(String stackStr, String currStr) {
        return stackStr.equals(currStr);
    }

    private static String getErrorMessage(int idx, String tag) {
        if (idx == 1) {
            return BAD_CHARACTER;
        }
        if (idx == 2) {
            return TOO_MANY_FEW_CHARS;
        }
        if (idx == 3) {
            return EXPECTED + "</" + tag + ">";
        }
        else {
            return NO_MATCHING;
        }
    }

}
