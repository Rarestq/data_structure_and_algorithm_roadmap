package com.rarestzhou.leetcode_solutions.java.threads_pool;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @author: wuxiu
 * @date: 2021/1/4 16:50
 * @description: 通用函数工具类
 */
@Slf4j
public class GeneralFunctionUtil {

    private GeneralFunctionUtil() {}

    public static <T> T recordRunTime(String customerMessage, Supplier<T> supplier) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        T t = supplier.get();
        long elapsed = stopwatch.elapsed(TimeUnit.MILLISECONDS);
        log.info("{},执行花费了{}ms", customerMessage, elapsed);
        return t;
    }

    public static <T> T recordRunTime(Supplier<T> supplier, Consumer<Long> consumer) {
        if (Objects.isNull(supplier) || Objects.isNull(consumer)) {
            throw new RuntimeException("WatchUtil,Supplier Or Consumer is none");
        }
        Stopwatch stopwatch = Stopwatch.createStarted();
        T t;
        try {
            t = supplier.get();
        } finally {
            long elapsed = stopwatch.elapsed(TimeUnit.MILLISECONDS);
            consumer.accept(elapsed);
        }
        return t;
    }

    public static void recordRunTime(Runnable runnable, Consumer<Long> consumer) {
        if (Objects.isNull(runnable) || Objects.isNull(consumer)) {
            throw new RuntimeException("WatchUtil,Runnable Or Consumer is none");
        }
        Stopwatch stopwatch = Stopwatch.createStarted();
        try {
            runnable.run();
        } finally {
            long elapsed = stopwatch.elapsed(TimeUnit.MILLISECONDS);
            consumer.accept(elapsed);
        }
    }
}
