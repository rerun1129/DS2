package 자료구조2_2;

public class Polynomial3 {
    private char name; //다항식 이름
    private int n; //항 개수
    private Term3[] terms; //항들을 저장할 배열

    public Polynomial3(char name){
        this.name = name;
        n = 0;
        terms = new Term3[100];
    }
    public char getName(){
        return name;
    }

        public int calcPoly(int x) {
            int result = 0;
            for(int i = 0 ; i<n; i++)
                result += terms[i].calcTerm(x);
            return result;
        }
        public void printPolynomial() {
            for(int i = 0; i< n; i++){
                terms[i].printTerm();
                System.out.print("+");
            }
            System.out.println();
        }
        public void addTerm(int c, int e) {
            int index = findTerm(e);
            if(index != -1){
                terms[index].setCoef(terms[index].getCoef() + c);
            }else{
                int i = n-1;
                while (i >= 0 && terms[i].getExpo() < e) {
                    terms[i+1] = terms[i];
                    i--;
                }
                terms[i+1] = new Term3(c,e);
                n++;
            }
        }
        private int findTerm(int e) {
            for(int i = 0; i< n && terms[i].getExpo() >= e; i++)
                if(terms[i].getExpo() == e)
                    return i;
            return -1;
        }
    }


