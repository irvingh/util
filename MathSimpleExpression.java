import java.util.LinkedList;

public class MathSimpleExpression {

    MathSimpleExpression() {
        solve(new String[]{"100", "*", "(", "2", "+", "12", ")", "/", "14"});
    }

    public void solve(String[] expression) {
        LinkedList<Double> values = new LinkedList<>();
        LinkedList<String> opers = new LinkedList<>();

        for (int i=0; i<expression.length; i++) {
            if (expression[i]=="(")
                opers.push(expression[i]);
            else if (expression[i]==")") {
                while (opers.peek() != "(")
                    values.push(op(opers.poll(), values.poll(), values.poll()));
                opers.poll();
            } else if (expression[i]=="+" || expression[i]=="-" || expression[i]=="*" || expression[i]=="/") {
                while (!opers.isEmpty() && hasPred(expression[i], opers.peek()))
                    values.push(op(opers.poll(), values.poll(), values.poll()));
                opers.push(expression[i]);
            } else if (isNumeric(expression[i]))
                values.push(Double.parseDouble(expression[i]));
        }
        while (!opers.isEmpty())
            values.push(op(opers.poll(), values.poll(), values.poll()));
        System.out.println(values.peek());
    }

    private Double op(String op, Double arg2, Double arg1) {
        switch (op) {
            case "+": return arg1 + arg2;
            case "-": return arg1 - arg2;
            case "*": return arg1 * arg2;
            case "/": return arg1 / arg2;
        }
        return -1d;
    }

    private boolean hasPred(String op1, String op2) {
        if (op2=="(" || op2==")")
            return false;
        else if ((op1=="*" || op1=="/") && (op2=="+" || op2=="-"))
            return false;
        else
            return true;
    }

    private boolean isNumeric(String s) {
        for (char c : s.toCharArray())
            if (!Character.isDigit(c)) return false;
        return true;
    }
}
