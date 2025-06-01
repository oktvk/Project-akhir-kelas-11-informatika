public class OhmLaw {
    private double voltage;    
    private double current;    
    private double resistance; 


    public OhmLaw() {
        this.voltage = 0.0;
        this.current = 0.0;
        this.resistance = 0.0;
    }


    public double calculateVoltage(double current, double resistance) {
        if (current < 0 || resistance < 0) {
            throw new IllegalArgumentException("Current and resistance must be positive values");
        }
        return current * resistance;
    }


    public double calculateCurrent(double voltage, double resistance) {
        if (voltage < 0 || resistance <= 0) {
            throw new IllegalArgumentException("Voltage must be positive and resistance must be greater than zero");
        }
        return voltage / resistance;
    }


    public double calculateResistance(double voltage, double current) {
        if (voltage < 0 || current <= 0) {
            throw new IllegalArgumentException("Voltage must be positive and current must be greater than zero");
        }
        return voltage / current;
    }


    public double getVoltage() {
        return voltage;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    public double getCurrent() {
        return current;
    }

    public void setCurrent(double current) {
        this.current = current;
    }

    public double getResistance() {
        return resistance;
    }

    public void setResistance(double resistance) {
        this.resistance = resistance;
    }
} 