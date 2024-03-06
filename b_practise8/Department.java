public class Department {
    private String deptName;
    private String deptCode;

    public Department(String deptName, String deptCode) {
        setDeptName(deptName);
        setDeptCode(deptCode);
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public boolean equals(Object other) {
        if (other instanceof Department) {
            Department othDepartment = (Department) other;
            return this.getDeptName().equals(othDepartment.deptName);
        }
        return false;
    }

    public String toString() {
        return "DeptName: " + deptName + " DeptCode: " + deptCode;
    }
}
