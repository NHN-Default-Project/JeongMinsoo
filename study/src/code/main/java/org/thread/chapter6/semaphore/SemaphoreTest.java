package org.thread.chapter6.semaphore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

public class SemaphoreTest {
    public static void main(String[] args) {

    }

    @Test
    public void givienLoginQueue_whenReachLimit_thenBlocked() {
        int slot = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(slot);
        LoginQueueUsingSemaphore loginQueue = new LoginQueueUsingSemaphore(slot);
        IntStream.range(0, slot)
                .forEach(user -> executorService.execute(loginQueue::tryLogin));
        executorService.shutdown();

        assertEquals(0, loginQueue.availableSlots());
        assertFalse(loginQueue.tryLogin());
    }
}
