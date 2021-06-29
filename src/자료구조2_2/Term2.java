package 자료구조2_2;

public class Term2 {
    public int coef;  //계수
    public int expo;   //차수

    public int calcTerm(int x) {
        return (int) (coef * Math.pow(x,expo));
    }
    public void printTerm() {
        System.out.print(coef + "x^" + expo);
    }
}
