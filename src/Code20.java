import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code20 {
    static String [] names = new String[1000];
    static String [] numbers = new String[1000];
    static int n = 0;
    public static void main(String[] args) {

        Scanner scan;
        try {
            scan = new Scanner(new File("data.txt"));
            while (scan.hasNext()){
                names[n] = scan.next();
                numbers[n] = scan.next();
                n++;
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("No file.");
            System.exit(1);
        }
        bS();
        for(int i=0; i<n; i++){
            System.out.println((i+1) + ". names: " + names[i] + " numbers: " + numbers[i]);
        }
    }
    public static void bS(){
        for(int i = n-1; i>0; i--){
            for(int j = 0; j<i; j++){
                if(names[j].compareTo(names[j+1]) > 0){
                    String tmp = names[j];
                    names[j] = names[j+1];
                    names[j+1] = tmp;

                    tmp = numbers[j];
                   numbers[j] = numbers[j+1];
                   numbers[j+1] = tmp;


                }
            }
        }
    }
}
