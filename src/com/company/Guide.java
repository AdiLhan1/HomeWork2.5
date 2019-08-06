package com.company;


import java.util.concurrent.CountDownLatch;

public class Guide extends Thread {
    private CountDownLatch LATCH;
    private int personNumber;

    public Guide(int personNumber, CountDownLatch LATCH) {
        this.personNumber = personNumber;
        this.LATCH = LATCH;
    }

    public void run() {
        try {
            System.out.printf("Человек %dый собрался\n", personNumber);
            // Уменьшаем счетчик на 1
            LATCH.countDown();
            if (personNumber < 15) {
                System.out.println("Пока ждем остальных");
            }
            // Метод await блокирует поток до тех пор, пока
            // счетчик CountDownLatch не обнулится
            LATCH.await();
        } catch (InterruptedException e) {
        }
    }
}



