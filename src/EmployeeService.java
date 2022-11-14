import java.util.Arrays;

public class EmployeeService {
    private final Employee[] empArr1;
    private int size;

    public EmployeeService() {
        this.empArr1 = new Employee[10];
    }

    public void addEmployee(String name, String surName, String lastName, int salary, int department) {
        if (size >= empArr1.length) {
            System.out.println("Массив заполнен");
        }
        Employee newEmployee = new Employee(name, surName, lastName, salary, department);
        empArr1[size++] = newEmployee;
    }

    public void removeEmployee(int employeeId) {
        for (int i = 0; i < empArr1.length; i++) {
            if (empArr1[i].getId() == employeeId) {
                empArr1[i] = null;
            }
            if (i != empArr1.length - 1) {
                System.arraycopy(empArr1, i + 1, empArr1, i, size - i);
            }
            size--;
            System.out.println("Работник " + employeeId + " удален");
            return;
        }
    }

    public void findEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            Employee employee = empArr1[i];
            if (employee.getId() == employeeId) {
                System.out.println(employee.getId() + ": " + employee.getName());
                return;
            }
        }
        System.out.println("Работник " + employeeId + " не существует");
    }

    public int getCurrentSize() {
        return size;
    }

    public void printAllContacts() {
        for (int i = 0; i < size; i++) {
            Employee employee = empArr1[i];
            if (employee != null) {
                System.out.println(employee.getId() + ": " + employee.getName());
            }
        }
    }

    public void getFIO(Employee[] employees) { //Получить Ф. И. О. всех сотрудников
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (employee != null) {
                System.out.println("ФИО всех сотрудников:  " + employee.getSurName() + " " + employee.getName() + " " + employee.getLastName());
            }
        }
    }

    public void getMaxSalary(Employee[] e) { //Найти сотрудника с максимальной зарплатой
        int max = Integer.MIN_VALUE;
        String name = "";
        for (int i = 0; i < e.length; i++) {
            if (empArr1[i] != null) {
                if (e[i].getSalary() > max) {
                    max = e[i].getSalary();
                    name = e[i].getName() + e[i].getSurName() + e[i].getLastName() + e[i].getDepartment();
                }
            }
        }
        System.out.println("Максимальная зп= " + max + " у сотрудника " + name);
    }

    public void getMinSalary(Employee[] e) { // Найти сотрудника с минимальной зарплатой
        int min = Integer.MAX_VALUE;
        String name = "";
        for (int i = 0; i < e.length; i++) {
            if (empArr1[i] != null && e[i].getSalary() < min) {
                min = e[i].getSalary();
                name = e[i].getName() + e[i].getSurName() + e[i].getLastName() + e[i].getDepartment();
            }
        }
        System.out.println("Минимальная зп= " + min + " у сотрудника " + name);
    }

    public void getSalarySumm(Employee[] e) {// Посчитать сумму затрат на зарплаты в месяц
        int total = 0;
        for (int i = 0; i < e.length; i++) {
            if (empArr1[i] != null) {
                total = total + e[i].getSalary();
            }
        }
        System.out.println("Сумма зп на месяц " + total);
    }

    public void getAverageSalary(Employee[] e) {//Подсчитать среднее значение зарплат
        int average = 0;
        int total = 0;
        for (int i = 0; i < e.length; i++) {
            if (empArr1[i] != null) {
                total = total + e[i].getSalary();
                average = total / e[i].getId(); 
            }
        }
        System.out.println("Средняя сумма зп " + average);
    }

    public void printEmployees(Employee[] e) { //Получить список всех сотрудников со всеми имеющимися по ним данными (вывести в консоль значения всех полей (toString)).
        System.out.println(Arrays.toString(e));
    }

    public void changeSalEmployee(Employee[] e, String name1, int newSal) {
        for (int i = 0; i < e.length; i++) {
            Employee employee = e[i];
            if (employee != null && employee.getName().equals(name1)) {
                System.out.println(employee.getName() + " Old salary " + employee.getSalary());
                employee.setSalary(newSal);
                System.out.println(employee.getName() + " new  salary " + employee.getSalary());

            }
        }
    }

    public void changeDepEmp(Employee[] e, String name1, int department) {
        for (int i = 0; i < e.length; i++) {
//            Employee employee = e[i];
            if (e[i] != null && e[i].getName().equals(name1)) {
                System.out.println(e[i].getName() + " Old dep" + e[i].getDepartment());
                e[i].setDepartment(department);
                System.out.println(e[i].getName() + " New dep" + e[i].getDepartment());

            }
        }
    }

    public void printFIODep(Employee[] e) {
        for (int i = 0; i < e.length; i++) {
            Employee employee = e[i];
            if (employee != null && employee.getDepartment() == 1) {
                System.out.println(employee.getName() + employee.getDepartment());
            }
        }
        System.out.println("NETY");
    }

    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();
        employeeService.addEmployee("P", "d", "s", 34000, 2);
        employeeService.addEmployee("S", "$", "F", 23222, 1);
        System.out.println(employeeService.getCurrentSize());
        employeeService.printAllContacts();
        employeeService.findEmployee(1);
//        employeeService.removeEmployee(1);
//        employeeService.findEmployee(1);
        employeeService.getFIO(employeeService.empArr1);
        employeeService.getMaxSalary(employeeService.empArr1);
        employeeService.getMinSalary(employeeService.empArr1);
        employeeService.getSalarySumm(employeeService.empArr1);
        employeeService.getAverageSalary(employeeService.empArr1);
        employeeService.printEmployees(employeeService.empArr1);
        employeeService.changeSalEmployee(employeeService.empArr1, "P", 55555);
        employeeService.changeDepEmp(employeeService.empArr1, "P", 1);
        employeeService.printFIODep(employeeService.empArr1);
    }
}

