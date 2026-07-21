import java.util.concurrent.locks.ReentrantLock;

class DiningPhilosophers {

    private final ReentrantLock[] forks;

    public DiningPhilosophers() {
        forks = new ReentrantLock[5];
        for (int i = 0; i < 5; i++) {
            forks[i] = new ReentrantLock();
        }
    }

    public void wantsToEat(
            int philosopher,
            Runnable pickLeftFork,
            Runnable pickRightFork,
            Runnable eat,
            Runnable putLeftFork,
            Runnable putRightFork) throws InterruptedException {

        int left = philosopher;
        int right = (philosopher + 1) % 5;

        // Lock forks in a fixed order
        ReentrantLock first = forks[Math.min(left, right)];
        ReentrantLock second = forks[Math.max(left, right)];

        first.lock();
        second.lock();

        try {
            pickLeftFork.run();
            pickRightFork.run();

            eat.run();

            putLeftFork.run();
            putRightFork.run();
        } finally {
            second.unlock();
            first.unlock();
        }
    }
}
