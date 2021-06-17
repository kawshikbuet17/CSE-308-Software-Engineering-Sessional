package Threading.Example2;

public class Threading_Example2 {
    public static void main(String[] args) throws Exception {
        A_Thread obj = new A_Thread();
        obj.print();
        for(int i=0; i<10; i++){
            System.out.println("Main_Thread\t>>> " + i);
            Thread.sleep(500);
        }
    }
}

