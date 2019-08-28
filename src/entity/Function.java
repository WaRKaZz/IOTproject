package entity;

import java.math.BigInteger;

public class Function {
    private boolean functionType;
    private String functionName;
    private boolean functionBoolean;
    private int functionInteger;
    private String functionText;
    private BigInteger functionId;

    public boolean isFunctionBoolean() {
        return functionBoolean;
    }

    public void setFunctionBoolean(boolean functionBoolean) {
        this.functionBoolean = functionBoolean;
    }

    public int getFunctionInteger() {
        return functionInteger;
    }

    public void setFunctionInteger(int functionInteger) {
        this.functionInteger = functionInteger;
    }

    public String getFunctionText() {
        return functionText;
    }

    public void setFunctionText(String functionText) {
        this.functionText = functionText;
    }

    public BigInteger getFunctionId() {
        return functionId;
    }

    public void setFunctionId(BigInteger functionId) {
        this.functionId = functionId;
    }

    public boolean isFunctionType() {
        return functionType;
    }

    public void setFunctionType(boolean functionType) {
        this.functionType = functionType;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }
}
