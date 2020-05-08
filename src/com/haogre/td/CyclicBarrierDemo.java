package com.haogre.td;

import java.util.concurrent.CyclicBarrier;

/**
 * Created with IntelliJ IDEA
 *
 * @Project : Janot's
 * @Description:
 * @Author : haogre@gmail.com
 * @Date : 12/11/19 3:37 PM
 * @Version : V1.0
 **/
public class CyclicBarrierDemo {

    private static final CyclicBarrier c = new CyclicBarrier(2);

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                c.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(1);
        }).start();

        try {
            c.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(2);

    }
}
