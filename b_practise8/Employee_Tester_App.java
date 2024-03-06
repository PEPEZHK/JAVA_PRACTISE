import java.util.ArrayList;

public class Employee_Tester_App {
    public static void main(String[] args) {
        Project p1 = new Project(" ArcTech Business Solution", 4, 112400, 45);

        ArrayList<Employee> arr = new ArrayList<Employee>();

        Employee emp1 = new Employee("Darth Vader", "SunMarkets POS", 1, 256, 35, 250, "INformational Technoogy", "IT");

        Employee emp2 = new Employee(emp1);
        emp2.setEmpName("Susan Tuador");
        emp2.setDepartment("Phylosophy", "II");
        emp2.setDailyRate(500);

        Employee emp3 = new Employee(emp1);
        emp3.setEmpName("Salvador Dalhi");
        emp3.setDepartment("Phylosophy", "II");
        emp3.setDailyRate(300);

        Employee emp4 = new Employee(emp1);
        int index = 0;
        int count1 = 0;

        int count = 0;
        arr.add(emp1);
        arr.add(emp2);
        arr.add(emp3);
        arr.add(emp4);

        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.size(); j++) {
                if (i != j) {
                    if (arr.get(i).getEmpName().equals(arr.get(j).getEmpName())) {
                        index = i;
                        count1++;
                        count = 1;
                    } else {
                        if (arr.get(i).getDepartment().equals(arr.get(j).getDepartment())) {
                            count++;

                        }
                    }

                }
            }
        }

        System.out.println("Employees: " + "\n" + "\n");
        for (int i = 0; i < arr.size(); i++) {
            System.out.println("\n" + arr.get(i).toString() + p1.toString());
        }
        System.out.println("--------- end employee list ----------");
        System.out.println("______________________________________");
        System.out.println("Employees with Matching Departments: (" + count + ")\n");
        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(i).getEmpName().equals(arr.get(j).getEmpName())) {
                    System.out.println(arr.get(i).toString() + "\n");
                    System.out.println(arr.get(j).toString());
                    System.out.println("\nEmployees with Matching Departments: (" + count1 + ")\n");
                }
            }
        }

        for (int i = 0; i < arr.size(); i++) {
            if (!arr.get(i).getEmpName().equals(arr.get(index).getEmpName())) {
                System.out.println(arr.get(i).toString() + "\n");
                System.out.println();
            }
        }

    }
}
