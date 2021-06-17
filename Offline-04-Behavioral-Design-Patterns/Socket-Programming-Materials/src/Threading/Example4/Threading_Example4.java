package Threading.Example4;

public class Threading_Example4 {
    public static void main(String[] args)  throws Exception {
        C_Thread t1 = new C_Thread();
        Thread t2 = new Thread(t1);
        t2.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("Main_Thread\t>>> " + i);
            Thread.sleep(500);
        }
    }
}
