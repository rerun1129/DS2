import java.io.*;
import java.util.Scanner;

public class IndexMaker {

    static item [] items = new item[100000];


    //static String [] words = new String[100000];
    //static int [] count =  new int [100000];
    static int n = 0;


    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        while (true) {
            System.out.print("$ ");
            String command = kb.next();
            if (command.equals("read")) {
                String fN = kb.next();

                makeIndex(fN);
            } else if (command.equals("find")) {
                String str = kb.next();
                int index = findWord(str);
                if(index != -1){
                    System.out.println("The word " + items[index].word + " appears " + items[index].count + " times.");
                }else {
                    System.out.println("The word " + str + " do not appear. ");
                }

            } else if (command.equals("saveas")) {
                String fN = kb.next();
                saveAs(fN);
            } else if (command.equals("exit")) {
                break;
            }
        }
        kb.close();
    }


    static void makeIndex(String fN){
        try {
            Scanner inFile = new Scanner(new File(fN));
            while (inFile.hasNext()) {
                String str = inFile.next();
                String trimmed = trimming(str);
                if (trimmed != null) {
                    String t = trimmed.toLowerCase();
                    addWord(t);
                }
            }
            inFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("No file");
            return;
        }

    }
    static void addWord(String str){
        int index = findWord(str);
        if (index != -1){
            items[index].count++;
        }else{
            int i=n-1;
            while (i>=0 && items[i].word.compareTo(str)>0){
                items[i+1]= items[i];

                i--;
            }
            items[i+1] = new item();
            items[i+1].word = str;
            items[i+1].count = 1;
            n++;
        }
    }
    static int findWord(String str) {
        for (int i = 0; i < n; i++)
            if (items[i].word.equals(str))
                return i;
        return -1;
    }
    static void saveAs(String fN){
        try {
            PrintWriter outFile = new PrintWriter(new FileWriter(fN));
            for(int i=0; i<n; i++)
                outFile.println(items[i].word + " " + items[i].count); //모니터 화면이 아니라 파일로
            //출력하고 싶으면 System.out 대신에 인스턴스 이름을 써주면 된다.
            outFile.close();
        } catch (IOException e) {
            System.out.println("Save failed.");
            return;
        }
    }
    public static String trimming (String str){

        int i = 0 , j = str.length()-1;
        while (i < str.length() && !Character.isLetter(str.charAt(i)))
            i++;
        while (j >=0 && !Character.isLetter(str.charAt(j)))
            j--;
        if(i<=j)
            return str.substring(i,j+1); //@$shade#*$이라는 단어가 있다면 i=2, j=6이 된다.
        else                             //substring으로 짤라야 하기 때문에 2<=6=true
            return null;                     //리턴값의 범위는 i≤....<j 이기 때문에 i, j+1이 된다. j=6인 6의 자리값이 포함되어야 하기 때문에.
    }                                //이 이외의 값이 나올려면 i=str.length()-1 j=0이 될때까지 while문이 돌 것이고 예를들어 i가 5 j가 0이면 5<=0은 false이기 때문에 null값을 리턴하면 된다.
}

