package Threading.Example3;

public class B_Thread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("B_Thread\t>>> " + i);
            try {
                Thread.sleep(700);
            } catch (Exception e) {
                System.out.println("B_Thread_Error");
            }
        }
    }
}
