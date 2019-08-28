package entity;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Device {
    private List<Function> inputFunctions= new ArrayList<>();
    private List<Function> outputFunctions = new ArrayList<>();
    private String deviceName;
    private BigInteger User;

    public BigInteger getUser() {
        return User;
    }

    public void setUser(BigInteger user) {
        User = user;
    }

    public List<Function> getInputFunctions() {
        return inputFunctions;
    }

    public void setInputFunctions(List<Function> inputFunctions) {
        this.inputFunctions = inputFunctions;
    }

    public List<Function> getOutputFunctions() {
        return outputFunctions;
    }

    public void setOutputFunctions(List<Function> outputFunctions) {
        this.outputFunctions = outputFunctions;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
}
