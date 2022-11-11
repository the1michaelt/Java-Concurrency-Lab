public class Simulation {

    public void runSim() throws InterruptedException {
        System.out.println("Running simulation");
        Account myAccount = new Account(1000);

        Runnable runWithdraw = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        myAccount.withdraw(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        Thread thread1 = new Thread(runWithdraw, "Thread 1");
        Thread thread2 = new Thread(runWithdraw, "Thread 2");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
       System.out.println("End of simulation. Total withdrawn: " + myAccount.getAmountWithdrawn() + ". Current balance: " + myAccount.getBalance());
    }

}
