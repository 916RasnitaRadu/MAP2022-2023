package Model.Expressions;

import Exceptions.InterpreterException;
import Model.ADTs.IDictionary;
import Model.Types.IntType;
import Model.Values.IntValue;
import Model.Values.Value;

public class ArithmeticExpression implements Expression{
    private Expression expression1, expression2; //
    private int operation; // 1 - '+'; 2 - '-'; 3 - '*'; 4 - '/'

    public ArithmeticExpression(int operation,Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
        this.operation = operation;
    }

    @Override
    public Value eval(IDictionary<String, Value> table) throws InterpreterException {
        Value value1 = null, value2 = null;
        value1 = expression1.eval(table);
        if (value1.getType().equals(new IntType())) {
            value2 = expression2.eval(table);
            if (value2.getType().equals(new IntType())) {
                IntValue integer1 = (IntValue) value1;
                IntValue integer2 = (IntValue) value2;
                int number1, number2;
                number1 = integer1.getValue();
                number2 = integer2.getValue();
                if (operation == 1) {
                    return new IntValue(number1 + number2);
                }
                if (operation == 2) {
                    return new IntValue(number1 - number2);
                }
                if (operation == 3) {
                    return new IntValue(number1 * number2);
                }
                if (operation == 4) {
                    if (number2 == 0) throw new InterpreterException("ERROR: Division by zero");
                    return new IntValue(number1 / number2);
                }
            } else {
                throw new InterpreterException("ERROR: second operand is not an integer");
            }
        }
        throw new InterpreterException("ERROR: first operand is not an integer");
    }

    public Expression getExpression1() {
        return expression1;
    }

    public void setExpression1(Expression expression1) {
        this.expression1 = expression1;
    }

    public Expression getExpression2() {
        return expression2;
    }

    public void setExpression2(Expression expression2) {
        this.expression2 = expression2;
    }

    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "ArithmeticExpression{" +
                "expression1=" + expression1 +
                ", expression2=" + expression2 +
                ", operation=" + operation +
                '}';
    }
}
