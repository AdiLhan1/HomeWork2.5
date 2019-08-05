package com.company;


import java.util.concurrent.CountDownLatch;

public class Guide extends Thread {
    static final int PERSON_COUNT = 15;
    static CountDownLatch LATCH;
    private int personNumber;

    public Guide(int personNumber) {
        this.personNumber = personNumber;
    }

    public void run() {
            try {
                System.out.printf("Человек %d собрался\n", personNumber);
                // Уменьшаем счетчик на 1
                LATCH.countDown();
                if (personNumber<15) {
                    System.out.println("Пока ждем остальных");
                }
                // Метод await блокирует поток до тех пор, пока
                // счетчик CountDownLatch не обнулится
                LATCH.await();
            } catch (InterruptedException e) {
            }
        }
    }



