package com.oop;

import com.oop.dao.EmployeeDao;
import com.oop.domain.Doctor;
import com.oop.domain.Employee;
import com.oop.domain.Nurse;
import com.oop.report.EmployeeReportFormatter;
import com.oop.report.FormatType;

public class ClientModule {

    public static void main(String[] args) {
        Employee employee1 = new Nurse(100, "Rahim", "R&D", true);
        Employee employee2 = new Nurse(200, "Karim", "R&D", true);
        Employee employee3 = new Doctor(300, "Kasem", "R&D", true);

        hireNewEmployee(employee1);
        hireNewEmployee(employee2);
        hireNewEmployee(employee3);

        terminateEmployee(employee2);

        printEmployeeReport(employee3, FormatType.CSV);

        printEmployeeReport(employee3, FormatType.XML);

    }

    public static void hireNewEmployee(Employee e) {
        EmployeeDao dao = new EmployeeDao();
        dao.saveEmployee(e);
    }

    public static void terminateEmployee(Employee e) {
        EmployeeDao dao = new EmployeeDao();
        dao.deleteEmployee(e);
    }

    public static void printEmployeeReport(Employee e,
                                           FormatType formatType) {
        EmployeeReportFormatter formatter = new EmployeeReportFormatter(e,
                formatType);
        System.out.println(formatter.getFormattedEmployee());
    }
}
