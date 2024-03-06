public class Project_Tester_App {
    public static void main(String[] args) {
        Project p1 = new Project(" ArcTech Business Solution", 5, 112461, 45);

        p1.setRatePerHour(123456);

        System.out.println(p1.toString());

        Project p2 = new Project(" SunMarkets POS Implementation", 25, 167, 45);
        System.out.println(p2.toString());

        p1.deactivateProject();
        System.out.println(p1.toString());

        // p1.activateProject(34, 209);
        // System.out.println(p1.toString());
    }

}
