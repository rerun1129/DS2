package 자료구조2_2;

class Term3 {
    private int coef;  //계수
    private int expo;   //차수

    public Term3(int c, int e) {
        setCoef(c);
        expo = e;
    }
    public int getExpo(){
        return expo;
    }

    public int getCoef(){
        return coef;
    }
    public void setCoef(int coef){
        this.coef = coef;
    }

    public int calcTerm(int x) {
        return (int) (coef * Math.pow(x,expo));
    }
    public void printTerm() {
        System.out.print(coef + "x^" + expo);
    }
}

