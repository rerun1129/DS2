import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code03 {
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
        bS(); //매개변수를 넘겨줄 필요가 없는 이유는 전역변수에 매개변수로 쓸 것들이 있기 때문
        for(int i = 0; i<count; i++)
            System.out.println(members[i].name + "'s phone number is " + members[i].number);
    }
    public static void bS(){
        for(int i= count-1; i>0; i--){
            for(int j=0; j<i; j++){
                if (members[j].name.compareTo(members[j+1].name) > 0 ){
                    Person1 tmpPerson = members[j];
                    members[j] = members[j+1];
                    members[j+1] = tmpPerson;
                }
            }
        }
    }
}
