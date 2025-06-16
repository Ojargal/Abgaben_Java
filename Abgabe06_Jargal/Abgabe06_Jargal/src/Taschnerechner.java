public class Taschnerechner {
//    Eigenschaften
    private double operand1;
    private double operand2;
    private char operator;

//    Standard Konstruktor

    public Taschnerechner(){
        operand1 = 1;
        operand2 = 1;
        operator = '+';
    }


//    Konstruktor mit Parametern

    public Taschnerechner(double operand1, double operand2, char operator){
        setOperand1(operand1);
        setOperand2(operand2);
        setOperator(operator);

    }
//setter-Methoden


    public void setOperand1(double operand1) {
        this.operand1 = operand1;
    }

    public void setOperand2(double operand2) {
        this.operand2 = operand2;
    }

    public void setOperator(char operator) {
            this.operator = operator;
//        if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
//            this.operator = operator;
//        } else {
//            // Eine Ausnahme werfen, wenn der Operator ungültig ist
//            throw new IllegalArgumentException("Ungültiger Operator: " + operator + ". Erlaubt sind '+', '-', '*', '/'.");
//            // Alternativ: Einen Standardwert setzen und eine Warnung ausgeben:
//            // System.err.println("Warnung: Ungültiger Operator '" + operator + "'. Setze auf Standard '+'.");
//            // this.operator = '+';
//        }
    }

//    getter-Methoden

    public double getOperand1() {
        return operand1;
    }

    public double getOperand2() {
        return operand2;
    }

    public char getOperator() {
        return operator;
    }
//    rechne-Method
    public void rechne() {
        switch (operator) {

            case '+':

                System.out.println("= " + (operand1 + operand2));
                break;
            case '-':
                System.out.println("= " + (operand1 - operand2));
                break;
            case '*':
                System.out.println("= " + (operand1 * operand2));
                break;
            case '/':
                if (operand2 == 0) {
                    System.out.println("Fehler: Es darf ein Zahl  durch 0 nicht devidirt werden.");
//                    throw new ArithmeticException("Division durch Null ist nicht erlaubt.");
                } else {
                    System.out.println("= " + (operand1 / operand2));
                    }
                break;
            default:
                System.out.println("Ungültige Operator");
                break;

        }

    }}

