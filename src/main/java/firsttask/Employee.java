package firsttask;

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
  // A HashSet is a collection of items where every item is unique,
  private HashSet<Employee> subjectDevs = new HashSet<>();
  private Employee teamLeader;
  private Salary salary;


  private Employee(){

  }

  public static Employee createNewTeamLeader(String name, String surname, int age, HashSet<Employee> subjectDevs){
        Employee employee = new Employee();
        employee.name = name;
        employee.surname = surname;
        employee.age = age;
        employee.subjectDevs = subjectDevs;
        employee.position = new Position(PositionNameEnum.TL);
        return employee;
  }

    public static Employee createNewDev(String name, String surname, int age, Employee teamLeader){
        Employee employee = new Employee();
        employee.name = name;
        employee.surname = surname;
        employee.age = age;
        employee.teamLeader = teamLeader;
        employee.position = new Position(PositionNameEnum.DEV);
        teamLeader.addDev(employee);
        return employee;
    }

    public static Employee createNewDevWithOutLeader(String name, String surname, int age){
        Employee employee = new Employee();
        employee.name = name;
        employee.surname = surname;
        employee.age = age;
        employee.position = new Position(PositionNameEnum.DEV);
        return employee;
    }

    public void setTeamLeader(Employee teamLeader){
      this.teamLeader = teamLeader;
    }

    public void addDev(Employee dev){
      this.subjectDevs.add(dev);
      dev.setTeamLeader(this);
    }

    public void removeDev(Employee dev){
        this.subjectDevs.remove(dev);
        if(this.equals(dev.getTeamLeader())){
            dev.setTeamLeader(null);
        }
    }

    public Employee getTeamLeader(){
        return teamLeader;
    }

    public void calculateSalary(int hours, int hourRate){
        double netSalary = hours*hourRate;
        double grossSalary = netSalary * 1.2;
        this.salary = new Salary(netSalary, grossSalary);
    }

    public Set<Employee> getSubjectDevs(){
        return this.subjectDevs;
    }

    @Override
            // to String pisemna reprezentacja obiektu - służy do zwracania tekstowej, czytelnej dla człowieka reprezentacji obiektu.
   public String toString() {
        String test = "Employee{" + "name= " + name + ", surname= " + surname + "}";
        if(this.salary != null){
            test = test.concat(" ".concat(this.salary.toString()));
        }
        return test;
   }
}



