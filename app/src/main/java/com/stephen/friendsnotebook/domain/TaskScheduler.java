package com.stephen.friendsnotebook.domain;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by StephenZhang on 2017/5/7.
 */

public class TaskScheduler {

    private static final int CORE_POOL_SIZE = 4;
    private static final int MAX_POOL_SIZE = 8;
    private static final int TIMEOUT = 30;

    private static TaskScheduler INSTANCE;

    private ThreadPoolExecutor threadPool;

    private TaskScheduler() {
        threadPool = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, TIMEOUT, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(CORE_POOL_SIZE));
    }

    public static TaskScheduler getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TaskScheduler();
        }

        return INSTANCE;
    }

    public void execute(BaseTask baseTask) {
        threadPool.execute(baseTask);
    }
}
