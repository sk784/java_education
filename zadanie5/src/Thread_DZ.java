public class Thread_DZ {
    static final int size = 10000000;
    static final int h = size / 2;


    static void equalMassive() {
        long a = System.currentTimeMillis();
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++){
            arr[i] = 1;
        }
        System.out.println("Время заполнения массива единицами: " + (System.currentTimeMillis() - a)+" мс.");
        for (int i = 0; i < arr.length; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время выполнения расчета для целого массива "+ (System.currentTimeMillis() - a)+" мс.");
        System.out.println((char)27 + "[31mОбщее время выполнения расчета для целого массива "+ (System.currentTimeMillis() - a)+" мс.");
    }

    static void divideMassive() {
        long a = System.currentTimeMillis();
        float[] arr = new float[size];
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        for (int i = 0; i < arr.length; i++){
            arr[i] = 1;
        }
        System.out.println((char)27 + "[37mВремя заполнения массива единицами: " + (System.currentTimeMillis() - a)+" мс.");

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        System.out.println("Время деления массива пополам: " + (System.currentTimeMillis() - a)+" мс.");

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < a1.length; i++) {
                    a1[i] = (float) (a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.out.println("Время выполнения расчета для первого массива " + (System.currentTimeMillis() - a)+" мс.");
                }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < a2.length; i++) {
                    a2[i] = (float) (a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }

                System.out.println("Время выполнения расчета для второго массива " + (System.currentTimeMillis() - a)+" мс.");
                }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Время выполнения расчетов для двух массивов одновременно " + (System.currentTimeMillis() - a)+" мс.");

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        System.out.println("Время склейки массива "+ (System.currentTimeMillis() - a)+" мс.");
        System.out.println((char)27 + "[31mОбщее время выполнения расчета для поделенного и склеенного массива "+ (System.currentTimeMillis() - a)+" мс.");
    }

    public static void main(String[] args) {
        equalMassive();
        divideMassive();
    }
}
