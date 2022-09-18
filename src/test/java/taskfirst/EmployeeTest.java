package taskfirst;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static taskfirst.Employee.addEmployeeToVacationCalendar;
import static taskfirst.Employee.getOooMap;

class EmployeeTest {

    @Test
    public void checkIfAddingDevToLeaderListWasSuccessful() {

        //given
        var devFirst = new Employee();
        var devSecond = new Employee();
        var teamLeader = new Employee();

        //then
        devFirst.createNewDev("Bartek", "Jarek", 33);
        teamLeader.createNewTeamLeader("Kamil", "Wolski", 55, new HashSet<>());
        teamLeader.addDev(devFirst);
        teamLeader.addDev(devSecond);

        //when
        assertEquals(2, teamLeader.getSubjectDevs().size());
    }

    @Test
    public void checkIfSalaryIsCalculateCorrectly() {

        //given
        var dev = new Employee();
        var teamLeader = new Employee();

        //then
        dev.calculateSalary(160, 40);
        teamLeader.calculateSalary(160, 60);

        //when
        assertEquals(6400, dev.getSalary().getNetSalary());
        assertEquals(9600, teamLeader.getSalary().getNetSalary());
    }

    @Test
    public void checkIfRemovingDevFromLeaderListWasSuccessful() {

        //given
        var dev = new Employee();
        var devSecond = new Employee();
        var teamLeader = new Employee();

        //then
        dev.createNewDev("Bartosz", "Kowalski", 45);
        devSecond.createNewDev("Jarek", "Czarek", 55);
        teamLeader.createNewTeamLeader("Arek", "Wolski", 34, new HashSet<>());
        teamLeader.addDev(dev);
        teamLeader.addDev(devSecond);
        teamLeader.removeDev(dev);
        teamLeader.removeDev(devSecond);

        //when
        assertEquals(0, teamLeader.getSubjectDevs().size());

    }

    @Test
    public void checkIfDevHasCorrectData() {

        //given
        var dev = new Employee();

        //then
        dev.createNewDev("Bartek", "Kowalski", 44);
        dev.calculateSalary(100, 50);

        //when
        assertThat(dev).satisfies(devData -> {
            assertThat(devData.getName()).isNotNull()
                    .isEqualTo("Bartek");
            assertThat(devData.getSalary().getNetSalary()).isEqualTo(5000);
            assertThat(devData.getSurname()).isNotEmpty()
                    .hasSize(8);
            assertThat(devData.getAge()).isLessThan(50);

        });
    }
    @Test
    public void checkIfEmployeeWasAddedToVacationCalendar() {
        //given
        Employee firstDev = new Employee();
        firstDev.createNewDev("Kamil", "Kowalski", 33);

        Employee secondDev = new Employee();
        secondDev.createNewDev("Adam", "Wielki", 55);

        Employee teamLeader = new Employee();
        teamLeader.createNewTeamLeader("Bartek", "Wojtek", 55, new HashSet<>());

        //then
        LocalDate dateFirst = LocalDate.of(2022, 6, 29);
        LocalDate dateSecond = LocalDate.of(2022, 7, 28);
        addEmployeeToVacationCalendar(dateFirst, firstDev);
        addEmployeeToVacationCalendar(dateFirst, secondDev);
        addEmployeeToVacationCalendar(dateSecond, teamLeader);

        //when
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(getOooMap().get(dateFirst)).contains(firstDev);
        softly.assertThat(getOooMap().get(dateFirst)).contains(secondDev);
        softly.assertThat(getOooMap().get(dateSecond)).contains(teamLeader);
        softly.assertAll();
    }

}