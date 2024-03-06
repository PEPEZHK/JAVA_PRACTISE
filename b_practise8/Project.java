import java.time.LocalDate;

public class Project {
    public final double TAX = 0.13;
    public final int OVERHEAD = 50000;
    public final int EMP_HOURS_WEEK = 45;

    private String projectId;
    private String projectName;
    private char projectType;
    private int personHours;
    private double ratePerHour;
    private int projectWeeks;
    private static int projectCounter = 5000;

    public Project(String newProjectName, int newPersonHours, double newRatePerHour, int newProjectWeeks) {
        projectCounter++;
        projectName = newProjectName;
        setPersonHours(newPersonHours);
        setRatePerHour(newRatePerHour);
        setProjectWeeks(newProjectWeeks);
        setProjectId();
        setProjectType();
    }

    public String getProjectId() {
        return projectId;
    }

    private void setProjectId() {
        projectId = LocalDate.now().getYear() + "-" + projectCounter;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String newProjectName) {
        projectName = newProjectName;
    }

    public char getProjectType() {
        return projectType;
    }

    public void setProjectType() {
        double projectCost = calculateProjectCost(personHours, ratePerHour);
        if (projectCost > 1000000) {
            projectType = 'm';
        } else if (projectCost > 500000 && projectCost < 1000000) {
            projectType = 'l';
        } else if (projectCost > 0 && projectCost < 500000) {
            projectType = 's';
        } else if (projectCost == 0) {
            projectType = 'i';
        }
    }

    public int getpersonHours() {
        return personHours;
    }

    public void setPersonHours(int newPersonHours) {
        if (newPersonHours > 0) {
            personHours = newPersonHours;
        } else {
            personHours = 0;
        }
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(double newRatePerHour) {
        if (newRatePerHour > 0) {
            ratePerHour = newRatePerHour;
        } else {
            ratePerHour = 0;
        }
    }

    public int getProjectWeeks() {
        return projectWeeks;
    }

    public void setProjectWeeks(int newProjectWeeks) {
        if (newProjectWeeks > 0) {
            projectWeeks = newProjectWeeks;
        } else {
            projectWeeks = 0;
        }

    }

    public void deactivateProject() {
        ratePerHour = 0;
        personHours = 0;
        projectType = 'i';
    }

    public void activateProject(int newPersonHours, double newRatePerHour) {
        setPersonHours(newPersonHours);
        setRatePerHour(newRatePerHour);
        setProjectType();
    }

    public double calculateProjectCost(int personHours, double ratePerHour) {
        double humanResCost = personHours * ratePerHour;
        if (humanResCost > 20000) {
            return humanResCost + OVERHEAD + humanResCost * TAX;
        } else {
            return humanResCost + humanResCost * TAX;
        }
    }

    public int calculatePersonResources(int personHours, int projectWeeks) {
        return (int) Math.ceil(personHours * projectWeeks / EMP_HOURS_WEEK);
    }

    public String toString() {
        String output = "";
        if (projectType == 'i') {
            output = "-------INACTIVE PROJECT-------" + "\n"
                    + "Project Name: " + projectName + "\n"
                    + "Project ID: " + projectId;
        } else {
            output = "Project Name: " + projectName + "\n"
                    + "Project ID: " + projectId + "\n"
                    + "Project Type: " + projectType + "\n"
                    + "Team size: " + calculatePersonResources(personHours, projectWeeks) + "\n"
                    + "Estimated project cost: " + calculateProjectCost(personHours, ratePerHour);
        }
        return output;
    }
}
