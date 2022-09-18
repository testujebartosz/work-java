package taskfirst;

import java.time.LocalDate;
import java.util.*;

import static taskfirst.Employee.addEmployeeToVacationCalendar;

public class SystemCheck {
    public static void main(String[] args) {

        Employee teamLeader = new Employee();
        teamLeader.createNewTeamLeader("Bartek", "Wojtek", 55, new HashSet<>());
        teamLeader.calculateSalary(160, 80);

        Employee firstDev = new Employee();
        firstDev.createNewDev("Kamil","Kowalski", 33);
        firstDev.calculateSalary(150, 70);

        Employee secondDev = new Employee();
        secondDev.createNewDev("Adam", "Wielki", 55);
        secondDev.calculateSalary(140, 75);

        Employee thirdDev = new Employee();
        thirdDev.createNewDev("Jarek", "Czarek", 33);
        thirdDev.calculateSalary(140, 75);

        Employee teamLeaderSecond = new Employee();
        teamLeaderSecond.createNewTeamLeader("Arek", "Wojtek", 55, new HashSet<>());
        teamLeaderSecond.calculateSalary(160, 80);

        teamLeader.addDev(firstDev);
        teamLeader.addDev(secondDev);
        teamLeader.addDev(thirdDev);

        teamLeader.removeDev(firstDev);
        teamLeaderSecond.addDev(firstDev);

        System.out.println(teamLeader.getSubjectDevs());

        LocalDate dateFirst = LocalDate.of(2022, 6, 29);
        addEmployeeToVacationCalendar(dateFirst, firstDev);
        addEmployeeToVacationCalendar(dateFirst, secondDev);
        LocalDate dateSecond = LocalDate.of(2022, 8, 22);
        addEmployeeToVacationCalendar(dateSecond, thirdDev);
        System.out.println(Employee.getOooMap());
    }
}
