package Threading.Example4;

public class C_Thread implements Runnable{
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("C_Thread\t>>> " + i);
            try {
                Thread.sleep(700);
            } catch (Exception e) {
                System.out.println("C_Thread_Error");
            }
        }
    }
}
