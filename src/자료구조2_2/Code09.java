package 자료구조2_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code09 {
    static MyRectangle2[] rects = new MyRectangle2[100]; // 직사각형들의 배열
    static int n = 0; //사각형의 갯수

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(new File("data2.txt"));
            while (in.hasNext()) {
                rects[n] = new MyRectangle2(in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt());
                n++;
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("No file.");
            System.exit(1);
        }
        bS();
        for(int i=0; i<n; i++)
        System.out.println(rects[i].toString());
    }

    private static void bS() {
        for (int i=n-1; i>0; i--){
            for(int j=0; j<i; j++){
                if((rects[j].calcArea())>(rects[j+1].calcArea())){
                    MyRectangle2 tmp = rects[j];
                    rects[j] = rects[j+1];
                    rects[j+1] = tmp;
                }
            }
        }
    }
}
