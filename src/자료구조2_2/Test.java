package 자료구조2_2;

public class Test {
    public static int s = 0;
    public int t = 0;

    public static void print1() {
        System.out.println("s=" + s);
        //System.out.println("t=" + t);
    }

    public void print2() {
        System.out.println("s=" + s);
        System.out.println("t=" + t);

    }

    public static void main(String[] args) {
        s = 100;
        //t = 100;
        print1();


        Test test1 = new Test();
        test1.t = 100;
        test1.print2();
    }
}