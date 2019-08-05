package com.company;

import java.util.concurrent.CountDownLatch;

import static com.company.Guide.LATCH;
import static com.company.Guide.PERSON_COUNT;

public class Main {

    public static void main(String[] args)throws InterruptedException {
        LATCH = new CountDownLatch(PERSON_COUNT + 2);
        for (int i = 1; i <=PERSON_COUNT; i++) {
            Guide r = new Guide(i);
            r.start();
            Thread.sleep(1000);
            if(i==PERSON_COUNT) {
                System.out.println("Все собрались),Выезжаем");
            }
            }





    }
}
