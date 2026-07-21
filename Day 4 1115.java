import java.util.concurrent.Semaphore;

class FooBar {
    private int n;
    private Semaphore fooSemaphore;
    private Semaphore barSemaphore;

    public FooBar(int n) {
        this.n = n;
        this.fooSemaphore = new Semaphore(1); // Start with foo allowed
        this.barSemaphore = new Semaphore(0); // bar must wait
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            fooSemaphore.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            barSemaphore.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            barSemaphore.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fooSemaphore.release();
        }
    }
}
