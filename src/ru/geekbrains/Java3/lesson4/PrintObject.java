package ru.geekbrains.Java3.lesson4;

public class PrintObject {
    private final Object mon = new Object();
    private volatile char currentLetter = 'A';
    private volatile char earlyLetter = 'C';

    public void printA () {
        synchronized (mon) {
           try {
               for (int i = 0; i < 5; i++) {
                   while (currentLetter != 'A' & earlyLetter != 'С') {
                       mon.wait();
                   }
                   System.out.print("A");
                   currentLetter = 'B';
                   earlyLetter = 'A';
                   mon.notifyAll();
               }
           } catch (InterruptedException e) {
               e.printStackTrace();
           }

        }
    }

    public void printB () {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'B' & earlyLetter != 'A') {
                        mon.wait();
                    }
                    System.out.print("B");
                    currentLetter = 'C';
                    earlyLetter = 'B';
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void printC () {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'C' & earlyLetter != 'B') {
                        mon.wait();
                    }
                    System.out.print("C" + " ");
                    currentLetter = 'A';
                    earlyLetter = 'C';
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
