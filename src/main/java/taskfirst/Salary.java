package taskfirst;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Salary {

    private double netSalary;
    private double grossSalary;

    public Salary(double netSalary, double grossSalary){
        this.netSalary = netSalary;
        this.grossSalary = grossSalary;
    }

    public double getNetSalary(){
        return this.netSalary;
    }


    public String toString(){
        return "Salary{" + "netSalary= " + netSalary + ", grossSalary= " + grossSalary + "}";
    }

}
