package common.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    private final Logger logger = LoggerFactory.getLogger(ThreadPool.class);

    private final ThreadPoolExecutor POOL = new ThreadPoolExecutor(2, 5, 5, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy()
    );

    private void printStats(ThreadPoolExecutor threadPool) {
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
            logger.info("-----------------------");
            logger.info("Pool Size {}", threadPool.getPoolSize());
            logger.info("active threads count:{}", threadPool.getActiveCount());
            logger.info("number of tasks completed:{}", threadPool.getCompletedTaskCount());
            logger.info("number of tasks in queue:{}", threadPool.getQueue().size());
            logger.info("-----------------------");
        }, 0, 1, TimeUnit.SECONDS);
        POOL.execute(() -> {
            System.out.println(Thread.currentThread().getId());
        });
    }
}
