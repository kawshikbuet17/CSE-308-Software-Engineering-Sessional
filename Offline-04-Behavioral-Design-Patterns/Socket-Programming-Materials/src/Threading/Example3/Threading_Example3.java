package Threading.Example3;

public class Threading_Example3 {
    public static void main(String[] args) throws Exception {
        B_Thread obj = new B_Thread();
        obj.start();
        for(int i=0; i<10; i++){
            System.out.println("Main_Thread\t>>> " + i);
            Thread.sleep(500);
        }
    }
}
