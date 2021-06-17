package Threading.Example1;

public class Threading_Example1 {
    public static void main(String[] args) throws Exception {
        for(int i=0; i<10; i++){
            System.out.println("Main_Thread >>> " + i);
            Thread.sleep(1000);
        }
    }
}
