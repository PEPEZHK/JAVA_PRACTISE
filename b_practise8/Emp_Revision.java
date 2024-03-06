import java.util.ArrayList;

public class Emp_Revision {
    public static void main(String[] args) {

        ArrayList<Employee> arr = new ArrayList<Employee>();

        Employee emp1 = new Employee("Tina Robertson", " GreenLife Communications", 1, 11240, 45, 250,
                "Information Technology", "IT");

        Employee emp2 = new Employee("Alexa Miles", "ChatBLK", 1, 11235, 64, 530, "Human Resources", "HR");

        Employee emp3 = new Employee(emp1);
        emp3.setEmpName("John Gomez");
        emp3.setDepartment("Human Resources", "HR");
        emp3.setDailyRate(305);

        arr.add(emp1);
        arr.add(emp2);
        arr.add(emp3);
        // arr.add(emp4);

        System.out.println("Employees: " + "\n" + "\n");
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i).toString());
        }
        System.out.println("--------- end employee list ----------");
        System.out.println("______________________________________");

        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if (i != j) {
                    if (arr.get(i).getEmpName().equals(arr.get(j).getEmpName())) {

                    } else {
                        if (arr.get(i).getDepartment().equals(arr.get(j).getDepartment())
                                && !arr.get(i).getProject().equals(arr.get(j).getProject())) {
                            System.out.println(
                                    arr.get(i).getEmpName() + " and " + arr.get(j).getEmpName()
                                            + " can switch projects");
                        } else {
                            if (!arr.get(i).getDepartment().equals(arr.get(j).getDepartment())) {
                                System.out.println(arr.get(i).getEmpName() + " and " + arr.get(j).getEmpName()
                                        + " cannot swtitch projects because they are in different departments!");
                            } else if (arr.get(i).getProject().equals(arr.get(j).getProject())) {
                                System.out.println(arr.get(i).getEmpName() + " and " + arr.get(j).getEmpName()
                                        + " cannot swtitch projects because they are on the same project!");
                            }
                        }
                    }
                }

            }
        }

    }
}
