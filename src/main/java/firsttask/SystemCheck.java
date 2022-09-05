package firsttask;

import java.time.LocalDate;
import java.util.*;

public class SystemCheck {

  public static void main(String[] args) {

   Employee teamLeader = Employee.createNewTeamLeader("Bartek", "Kowalski", 33 , new HashSet<>());

    teamLeader.calculateSalary(160, 40);

    Employee devFirst = Employee.createNewDev("Jarek", "Fajny", 22, teamLeader);
    Employee devSecond = Employee.createNewDev("Artur", "Dobry", 32, teamLeader);
    Employee devThird = Employee.createNewDev("Edek", "Zły", 32, teamLeader);

    devFirst.calculateSalary(60 , 70);
    devSecond.calculateSalary(65,  70 );
    devThird.calculateSalary(65, 70);

    Employee teamLeaderSecond = Employee.createNewTeamLeader("Kamil", "Kowalski", 35 , new HashSet<>());

    teamLeaderSecond.calculateSalary(160, 40);

    Employee devFourth = Employee.createNewDev("Antoni", "Robot", 55, teamLeaderSecond);
    Employee devFifth = Employee.createNewDev("Piotr", "Waszka", 65, teamLeaderSecond );
    Employee devSixth = Employee.createNewDev("Bartek", "Wolny", 22,teamLeaderSecond);

    devFourth.calculateSalary(55, 77);
    devFifth.calculateSalary(65, 75);
    devSixth.calculateSalary(55, 90);

    Employee devSeventh = Employee.createNewDevWithOutLeader("Jarek", "Czarek", 33);
    teamLeaderSecond.addDev(devSeventh);

    teamLeaderSecond.addDev(devFifth);
    //devFifth.setTeamLeader(teamLeader);
    teamLeaderSecond.removeDev(devFifth);


    //the forEach() method performs the action specified by lambda expression for each entry of the hashmap
    teamLeaderSecond.getSubjectDevs().forEach(dev-> System.out.println(dev.toString()));
    // System.out.println(devFifth.getTeamLeader().toString());


    // 2022-01-01 Adam
    // 2022-01-02 Adam

    Map<LocalDate, List<Employee>> oooMap = new HashMap<>();

    /// LocalDate.of(2022, 6, 29)
    LocalDate when = LocalDate.of(2022, 6, 29);
    Employee who = devFirst;

    List<Employee> employees = oooMap.get(when);
    if (employees == null) {
      employees = new ArrayList<>();
      oooMap.put(when, employees);
    }
    employees.add(who);

    /// LocalDate.of(2022, 6, 29)
    when = LocalDate.of(2022, 6, 29);
    who = devSecond;

    employees = oooMap.get(when);
    if (employees == null) {
      employees = new ArrayList<>();
      oooMap.put(when, employees);
    }
    employees.add(who);

    //System.out.println(oooMap);
 }
}
