## 125. 验证回文串

---

题目详情见 [验证回文串](https://leetcode-cn.com/problems/valid-palindrome/) 或 [validalindrome](https://leetcode.com/problems/valid-palindrome/)


### 解题思路 1 - 常规思路
---
题目描述里指明了「只考虑字母和数字字符」，那么我们第一步要做的显然就是把字符串中非字母和非数字的字符过滤掉，然后就是反转处理后的字符串，最后再拿他跟原字符串比较，看是不是一样的就可以了。

具体步骤如下：

- 将字符串中的非字母和数字字符过滤掉 -> 正则表达式
- 反转字符串 -> new StringBuffer(s).reverse()
- 比较字符串 -> equalsIgnoreCase

这种解法代码看着是很简洁，但可以预料的是，这种方式性能上是比较差的，因为我们在处理字符串的时候用了正则表达式，而正则表达式是比较吃性能的(PS:正则表达式的底层原理是状态机)

代码如下：

```java
public class ValidPalindromeSolutions {

    public boolean isPalindrome(String s) {
        // 1、处理字符串 s，只保留数字和字母
        s = s.replaceAll("(?i)[^a-zA-Z0-9\u4E00-\u9FA5]", "");
        // 2、反转字符串s
        String reversedStr = new StringBuffer(s).reverse().toString();

        // 3、比较反转后的字符串和原字符串是不是相等的
        return s.equalsIgnoreCase(reversedStr);
    }
}

```

LeetCode 提交记录：
![isPalindrome](https://i.loli.net/2019/12/12/yer38Uu7bi2Vm4L.png)
---

### 解题思路 2 - 双指针法
---
建立两个指针，一个指向字符串序列开始的位置，一个指向字符串序列最后一个元素

通过分析可以得到该种解法的时间和空间复杂度为：

- 时间复杂度：O(n), 只进行了一次 for 循环。
- 空间复杂度：O(1), 常量的空间存储指针

代码如下：

```java
public class ValidPalindromeSolutions {

    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while(head <= tail) {
            cHead = s.charAt(head);
            cTail = s.charAt(tail);
            if (!Character.isLetterOrDigit(cHead)) {
                head++;
            } else if(!Character.isLetterOrDigit(cTail)) {
                tail--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                head++;
                tail--;
            }
        }

        return true;
    }
}
```
LeetCode 提交结果：
![isPalindrome](https://i.loli.net/2019/12/12/fHAqgpuicCQjIJP.png)
