package Threading.Example2;

public class A_Thread extends Thread {
    public void print() {
        for (int i = 0; i < 10; i++) {
            System.out.println("A_Thread\t>>> " + i);
            try {
                Thread.sleep(700);
            } catch (Exception e) {
                System.out.println("A_Thread_Error");
            }
        }
    }
}
