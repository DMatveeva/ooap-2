package task_15;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Employee {

    private List<Shift> shifts; // Сотрудники работают по сменам, каждый сотрудник имеет список отработанных смен
    public List<Shift> getShifts() {
        return shifts;
    }
}

class PaymentCalculation {

    // За дневную смену платят стандартный оклад, за ночную - двойной оклад
    // Для метода, который подсчитывает оклад сотрудника за заданный период,
    // вместо цепочки if(shift.isDayShift()) then... создано 2 класса, DayShift и NightShift, и используется полиморфный вызов метода getRate()
    BigDecimal getPaymentForEmployeeForPeriod(Employee employee, LocalDateTime start, LocalDateTime end) {
        return employee.getShifts().stream()
                .filter(shift -> shift.shiftDate.isAfter(start) && shift.shiftDate.isBefore(end))
                .map(Shift::getRate)
                .reduce(BigDecimal::add).orElseThrow();
    }
}

class Shift {
    String location;
    LocalDateTime shiftDate;
    BigDecimal standartRate;
    BigDecimal getRate() {
        return standartRate;
    }
}

class DayShift extends Shift {
}

class NightShift extends Shift {
    BigDecimal getRate() {
        return standartRate.multiply(BigDecimal.valueOf(2));
    }
}