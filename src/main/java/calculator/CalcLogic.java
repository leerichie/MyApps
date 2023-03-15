package calculator;

public class CalcLogic {

    // attributes
    private double preNum;
    private double totalNum;

    // constructors
    public CalcLogic() {
    }

    public CalcLogic(double preNum, double totalNum) {
        this.preNum = preNum;
        this.totalNum = totalNum;
    }

    // get & set
    public double getPreNum() {
        return preNum;
    }

    public void setPreNum(double preNum) {
        this.preNum = preNum;
    }

    // methods
    public double add(int a, int b){
        setPreNum(a + b);
        this.totalNum += getPreNum();
        return getPreNum();
    }

    public double subtract(int a, int b){
        setPreNum(a - b);
        this.totalNum += getPreNum();
        return getPreNum();
    }

    public double multiply(int a, int b){
        setPreNum(a * b);
        this.totalNum += getPreNum();
        return getPreNum();
    }

    public double divide(int a, int b){
        setPreNum(a / b);
        this.totalNum += getPreNum();
        return getPreNum();
    }
}
