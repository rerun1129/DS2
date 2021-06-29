package 자료구조2_2;

class Term3 {
    int coef;  //계수
    int expo;   //차수

    public Term3(int c, int e) {
        coef = c;
        expo = e;
    }
    public int calcTerm(int x) {
        return (int) (coef * Math.pow(x,expo));
    }
    public void printTerm() {
        System.out.print(coef + "x^" + expo);
    }
}

