public class Employee {
    public final int WORKING_DAYS = 261;

    private String employeeName;
    private double dailyRate;
    private Department department;
    private Project project;

    public Employee(String employeeName, String newProjectName, int newPersonHours, double newRatePerHour,
            int newProjectWeeks, double dailyRate, String deptName, String deptCode) {
        this.employeeName = employeeName;
        setDailyRate(dailyRate);
        this.project = new Project(newProjectName, newPersonHours, newRatePerHour, newProjectWeeks);
        this.department = new Department(deptName, deptCode);
    }

    public Employee(Employee employee) {
        this.employeeName = employee.employeeName;
        setDailyRate(employee.dailyRate);
        this.project = employee.project;
        this.department = employee.department;
    }

    public String getEmpName() {
        return employeeName;
    }

    public void setEmpName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(String newProjectName, int newPersonHours, double newRatePerHour, int newProjectWeeks) {
        this.project = new Project(newProjectName, newPersonHours, newRatePerHour, newProjectWeeks);
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        if (dailyRate > 0) {
            this.dailyRate = dailyRate;
        } else {
            this.dailyRate = 0;
        }
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(String deptNAme, String deptCode) {
        this.department = new Department(deptNAme, deptCode);
    }

    public double calculateYearlySalary() {
        return dailyRate * WORKING_DAYS;
    }

    public String toString() {
        return "Employee name: " + employeeName + " Yearly Salary: "
                + calculateYearlySalary() + "\n"
                + "DeptName: " + department.getDeptName() + " DeptCode: " + department.getDeptCode() + "\n"
                + project.toString();
    }
}
