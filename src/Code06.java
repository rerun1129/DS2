import java.util.Scanner;

public class Code06 {

    static Code06_Poly [] polys = new Code06_Poly[100];
    static int n = 0;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        while (true){
            System.out.print("$ ");
            String command = kb.next();
            if(command.equals("create")){
                char name = kb.next().charAt(0);  //kb.next()[Scanner]로 char타입 데이터를 받지 못한다.
                polys[n] = new Code06_Poly();//name은 길이가 1인 문자이기 때문에 위와 같이 작성하면 입력을 받을수 있다.[편법]
                polys[n].terms = new Code06_Term[100];
                polys[n].name = name;
                polys[n].n = 0;

                n++;
            }else if(command.equals("add")){
                char name = kb.next().charAt(0);
                int index = find(name);
                if(index == -1){
                    System.out.println("No such poly.");
                }else {
                    int c = kb.nextInt(); //계수
                    int e = kb.nextInt(); //차수
                    addTerm(polys[index], c, e); // 다항식 번호, 계수, 차수 넘겨주기
                }
            }else if(command.equals("calc")){
                char name = kb.next().charAt(0);
                int index = find(name);
                if(index == -1){
                    System.out.println("No such poly.");
                }else{
                    int x = kb.nextInt();
                    int result = calcPoly(polys[index], x);
                    System.out.println(result);
                }

            }else if(command.equals("print")){
                char name = kb.next().charAt(0);
                int index = find(name);
                if(index == -1){
                    System.out.println("No such poly.");
                }else {
                    printPolynomial(polys[index]);
                }
            }else if(command.equals("exit")){
                break;
            }
        }
        kb.close();
    }

    private static int calcPoly(Code06_Poly poly, int x) {
        int result = 0;
        for(int i = 0 ; i< poly.n; i++)
            result += calcTerm(poly.terms[i], x);
        return result;
    }

    private static int calcTerm(Code06_Term term, int x) {
        return (int) (term.coef * Math.pow(x,term.expo));
    }

    private static void printPolynomial(Code06_Poly poly) {
        for (int i = 0; i < poly.n; i++) {
            printTerm(poly.terms[i]);
        }
            System.out.println();
    }


    private static void printTerm(Code06_Term term) {

        if (term.coef == 1) {
            System.out.print("x^" + term.expo);
        } else if (term.expo == 1) {           //1차식의 계수가 -1일때 -만 표시만 헤결하면됨
            System.out.print(term.coef + "x");
        } else if (term.coef == -1) {
            System.out.print("-x^" + term.expo);
        } else if (term.expo == 0) {
            System.out.print(term.coef + "");
        } else if (term.expo == 0) {
            System.out.print(term.coef + "");
        } else {
            System.out.print(term.coef + "x^" + term.expo);
        }
    }
    private static void addTerm(Code06_Poly poly, int c, int e) {
        int index = findTerm(poly, e);
        if(index != -1){
            poly.terms[index].coef += c;
        }else{
            int i = poly.n-1;
            while (i >= 0 && poly.terms[i].expo < e) {
                poly.terms[i+1] = poly.terms[i];
                i--;
            }
            poly.terms[i+1] = new Code06_Term();
            poly.terms[i+1].coef = c;
            poly.terms[i+1].expo = e;
            poly.n++;
        }
    }
    private static int findTerm(Code06_Poly poly, int e) {
        for(int i = 0; i< poly.n && poly.terms[i].expo >= e; i++)
            if(poly.terms[i].expo == e)
                return i;
            return -1;
    }
    private static int find(char name) {
        for(int i=0; i<n; i++)
            if(polys[i].name == name)
            return i;
        return -1;
    }
}
