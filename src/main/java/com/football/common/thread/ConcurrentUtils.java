package com.football.common.thread;

/**
 * Created by IntelliJ IDEA.
 * User: Truong Nguyen
 * Date: 11-Jul-18
 * Time: 10:19 AM
 * To change this template use File | Settings | File Templates.
 */

import com.football.common.constant.Constant;
import org.apache.logging.log4j.LogManager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class ConcurrentUtils {

    private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(Constant.LOG_APPENDER.COMMON);

    public static void stop(ExecutorService executor, int timeout, TimeUnit unit) {
        try {
            executor.shutdown();
            executor.awaitTermination(timeout, unit);
        } catch (InterruptedException e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            if (!executor.isTerminated()) {
                LOGGER.error("Killing non-finished tasks");
            }
            executor.shutdownNow();
        }
    }

    public static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}

