package Basics;

import java.util.Hashtable;

public class Demonstration {
    private static int max_val = Integer.MAX_VALUE;

    public static void twoThreads() throws InterruptedException {
        Sum s1 = new Sum(0 , max_val/2);
        Sum s2 = new Sum(max_val/2 , max_val);

        Thread t1 = new Thread(() -> {
           s1.add();
        });
        Thread t2 = new Thread(() -> {
            s2.add();
        });
        long currentTime = System.currentTimeMillis();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long endTime = System.currentTimeMillis();
        long sum = s1.getSum() + s2.getSum();
        double time = (endTime - currentTime)/1000;
        System.out.println("Time taken by two threads::"+time+",Sum is::"+sum);
    }
    static void singThread(){
        Sum s = new Sum(0 , max_val);
        long currentTime = System.currentTimeMillis();
        s.add();
        long endTime = System.currentTimeMillis();
        long sum = s.getSum();
        double time = (endTime - currentTime)/1000;
        System.out.println("Time taken by One thread::"+time+",Sum is::"+sum);
    }

    public static void main(String[] args) throws InterruptedException {
        singThread(); twoThreads();
    }
}
