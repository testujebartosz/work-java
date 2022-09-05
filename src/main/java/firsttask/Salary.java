package firsttask;

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




    public String toString(){
        return "Salary{" + "netSalary= " + netSalary + ", grossSalary= " + grossSalary + "}";
    }

}
