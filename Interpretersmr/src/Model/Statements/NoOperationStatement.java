package Model.Statements;

import Exceptions.InterpreterException;
import Model.ProgramState.ProgramState;

public class NoOperationStatement implements IStatement{

    @Override
    public ProgramState execute(ProgramState state) throws InterpreterException {
        return null;
    }

    @Override
    public String toString() {
        return "NoOperationStatement{}";
    }
}
