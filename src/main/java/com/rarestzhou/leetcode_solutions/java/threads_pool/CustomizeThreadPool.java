package com.rarestzhou.leetcode_solutions.java.threads_pool;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.Objects;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @author: wuxiu
 * @date: 2021/1/4 16:54
 * @description: 自定义线程池类
 */
public class CustomizeThreadPool {

    private static final int THREAD_POOL_SIZE = 5;
    private static List<Thread> threads = Lists.newArrayListWithCapacity(THREAD_POOL_SIZE);
    /**
     * 线程池是否还在继续运行，true：线程池处于工作状态，false：线程池即将销毁停止工作
     */
    boolean isRunning = Boolean.FALSE;

    public CustomizeThreadPool(int threadPoolSize) {
        isRunning = Boolean.TRUE;
        for (int i = 0; i < threadPoolSize; i++) {
            threads.add(new Thread(this::threadWorker));
        }
    }

    private void threadWorker() {
        while (isRunning) {
            // 获取任务
            Task task = getOneTask();
            if (Objects.isNull(task)) {
                break;
            }
            // 执行任务
            task.run();
        }
    }

    /**
     * 获取任务：
     *  1、判断任务队列是否为空，为空，取任务方法等待，**直到任务队列中有任务**(线程同步方法、条件变量、互斥锁、信号量和无锁化编程)，再取出任务向下执行
     *
     * @return
     */
    private Task getOneTask() {
        // TODO by 无朽 2021/1/4 do something

        // 进入临界区时加锁(保证多线程环境下资源访问安全性)

        // 等待任务

        // 获取任务
        return null;
    }

    private void destructThreads() {
        isRunning = Boolean.FALSE;
        CollectionUtils.removeAll(threads, threads);
    }
}
