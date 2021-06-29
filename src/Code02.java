import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code02 {
    static Person1 [] members = new Person1[100];
    static int count = 0;
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(new File("data.txt"));
            while (in.hasNext()){
                String str1 = in.next();
                String str2 = in.next();
                members[count] = new Person1();
                members[count].name = str1;
                members[count].number = str2;
                count++;
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("No data.");
            System.exit(1);
        }
        for(int i = 0; i<count; i++)
            System.out.println(members[i].name + "'s phone number is " + members[i].number);
    }
}
