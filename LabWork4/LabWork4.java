/**
 * @Author : mohammed Bekhouche
 * @since : 12/12/2019
 */
package labwork4;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LabWork4 {

    public static void main(String[] args) {
        //create tasks 
        Runnable printFa = new PrintFa("Fa");
        Runnable printLa = new PrintLa("La");

        // create threads 
        Thread thread1 = new Thread(printFa);
        Thread thread2 = new Thread(printLa);

        //start threads
        thread1.start();
        thread2.start();

    }

}

class PrintFa implements Runnable {

    private String str;

    public PrintFa(String s) {
        str = s;
    }

    public void run() {
        for (int i = 0; i < 4; i++) {
            System.out.print(str);
            try {
                Thread.sleep(8010);
                System.out.println();
            } catch (InterruptedException ex) {
                System.out.println("exception");

            }

        }
    }
}

class PrintLa implements Runnable {

    private String str;

    public PrintLa(String s) {
        str = s;
    }

    public void run() {
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 8; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    System.out.println("exception");
                }
                System.out.print(str);
            }
        }
    }
}
