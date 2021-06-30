package 자료구조2_2;

import java.util.Scanner;

public class Code11 {
    Polynomial3[] polys = new Polynomial3[100];
    int n = 0;
    private void processCommand(){
        Scanner kb = new Scanner(System.in);

        while (true){
            System.out.print("$ ");
            String command = kb.next();
            if(command.equals("create")){
                char name = kb.next().charAt(0);  //kb.next()[Scanner]로 char타입 데이터를 받지 못한다.
                polys[n] = new Polynomial3(name);//name은 길이가 1인 문자이기 때문에 위와 같이 작성하면 입력을 받을수 있다.[편법]
                n++;
            }else if(command.equals("add")){
                char name = kb.next().charAt(0);
                int index = find(name);
                if(index == -1){
                    System.out.println("No such poly.");
                }else {
                    int c = kb.nextInt(); //계수
                    int e = kb.nextInt(); //차수
                    polys[index].addTerm(c,e);// 다항식 번호, 계수, 차수 넘겨주기
                }
            }else if(command.equals("calc")){
                char name = kb.next().charAt(0);
                int index = find(name);
                if(index == -1){
                    System.out.println("No such poly.");
                }else{
                    int x = kb.nextInt();
                    int result = polys[index].calcPoly(x);
                    System.out.println(result);
                }
            }else if(command.equals("print")){
                char name = kb.next().charAt(0);
                int index = find(name);
                if(index == -1){
                    System.out.println("No such poly.");
                }else {
                    polys[index].printPolynomial();
                }
            }else if(command.equals("exit")){
                break;
            }
        }
        kb.close();
    }

    private int find(char name) {
        for(int i=0; i<n; i++)
            if(polys[i].getName() == name)
            return i;
        return -1;
    }

    public static void main(String[] args) {
        Code11 app = new Code11();
        app.processCommand();
    }
}
