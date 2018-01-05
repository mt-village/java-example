package jp.mt.village.examples;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

import com.google.common.util.concurrent.RateLimiter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RateLimiterTests {

    @Test
    public void test() throws InterruptedException, ExecutionException {
        RateLimiter rateLimiter = RateLimiter.create(1);

        Callable<String> task = () -> {
            rateLimiter.acquire();
            return "hello";
        };

        CompletionService<String> srv = srv(10);
        for (int i = 0; i < 100 ;i++) {
            srv.submit(task);
        }
        for (int i = 0; i < 100 ;i++) {
            log.info(srv.take().get());
        }
    }

    private CompletionService<String> srv(int threadNum) {
        ExecutorService exec = Executors.newFixedThreadPool(threadNum);
        return new ExecutorCompletionService<>(exec);
    }
}
