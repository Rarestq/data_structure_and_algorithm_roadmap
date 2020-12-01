package com.rarestzhou.leetcode_solutions.java;

import com.alibaba.fastjson.JSON;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @author: wuxiu
 * @date: 2020/10/19 13:39
 * @description:
 */
public class DeserializerDemo {

    public static void main(String[] args) {
        // fastjson 反序列化获取不到值 - json 字符串的 key 后面有空格
        String str = "{\"addr \":\"hangzhou\",\"age\":22,\"name\":\"wuxiu\"}";
        User user1 = JSON.parseObject(str, User.class);
        System.out.println(user1);

        // fastjson 反序列化获取不到值 - getter/setter 方法没有按照驼峰规则命名(这个是正常的)
        String str1 = "{\"addr\":\"hangzhou\",\"age\":22,\"name\":\"wuxiu\",\"sex_gender\":\"男\"}";
        User user2 = JSON.parseObject(str1, User.class);
        System.out.println(user2);

    }
}
