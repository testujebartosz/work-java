package taskfirst;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
public class Employee {

    private String name;
    private String surname;
    private int age;
    private Position position;
    //A HashSet is a collection of items where every item is unique.
    private Set<Employee> subjectDevs = new HashSet<>();
    private Employee teamLeader;
    private Salary salary;

    public Employee(){

    }

    public void createNewTeamLeader(String name, String surname, int age, HashSet<Employee> subjectDevs){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.subjectDevs = subjectDevs;
        this.position = new Position(PositionNameEnumDevTL.TL);
    }

    public void createNewDev(String name, String surname, int age){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.position = new Position(PositionNameEnumDevTL.DEV);
    }

    public void addDev(Employee dev){
        this.subjectDevs.add(dev);
    }

    public void removeDev(Employee dev){
        this.subjectDevs.remove(dev);
    }

    public void calculateSalary(int hours, int hourRate){
        double netSalary = hours*hourRate;
        double grossSalary = netSalary * 1.2;
        this.salary = new Salary(netSalary, grossSalary);
    }

    public Set<Employee> getSubjectDevs(){
        return this.subjectDevs;
    }

//    public void setTeamLeader(Employee teamLeader){
//        this.teamLeader = teamLeader;
//    }

    // to String pisemna reprezentacja obiektu - służy do zwracania tekstowej, czytelnej dla człowieka reprezentacji obiektu.
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", position=" + position.getName()  +
                ", salary=" + salary.getNetSalary() +
                "}";
    }
}