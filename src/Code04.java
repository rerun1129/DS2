import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code04 {
    static MyRectangle1 [] rects = new MyRectangle1[100]; // 직사각형들의 배열
    static int n = 0; //사각형의 갯수

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(new File("data2.txt"));
            while (in.hasNext()) {
                rects[n] = new MyRectangle1();
                rects[n].lu = new MyPoint();
                rects[n].lu.x = in.nextInt();   //주석 처리된 대로 해도 되지만 이렇게 해도 기능은 똑같다.
                rects[n].lu.y = in.nextInt();
                rects[n].width = in.nextInt();
                rects[n].height = in.nextInt();

                n++;
            }
            /*int x = in.nextInt(); // x,y좌표 , 높이, 너비를 각각 입력받는다.
            int y = in.nextInt();
            int w = in.nextInt();
            int h = in.nextInt();

            rects[n].lu.x = x;    // 이것이 직사각형의 왼쪽 꼭지점, 높이, 너비가 된다.
            rects[n].lu.y = y;    // .은 클래스의 경로를 읽어주는 것이라고 보면된다.
            rects[n].width = w;
            rects[n].height = h;

             */

            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("No file.");
            System.exit(1);
        }
        bS();
        for(int i=0; i<n; i++)
        System.out.println(rects[i].lu.x+" "+rects[i].lu.y+" "+rects[i].width+" "+rects[i].height);
    }

    private static void bS() {
        for (int i=n-1; i>0; i--){
            for(int j=0; j<i; j++){
                if(calcArea(rects[j])>calcArea(rects[j+1])){
                    MyRectangle1 tmp = rects[j];
                    rects[j] = rects[j+1];
                    rects[j+1] = tmp;
                }

            }
        }
    }
    public static int calcArea(MyRectangle1 r){
        return r.width*r.height;
    }
}
