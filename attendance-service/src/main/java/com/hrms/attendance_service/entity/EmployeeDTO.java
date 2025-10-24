package com.hrms.attendance_service.entity;

public class EmployeeDTO {
    private Long empId;

    private String fName;
    private String lName;
    private String designation;
    private double baseSal;
    private String joiningDate;
    private DeptDTO dept;

    public static class DeptDTO {
        private Long deptId;
        private String dName; // match with entity

        public Long getDeptId() { return deptId; }
        public void setDeptId(Long deptId) { this.deptId = deptId; }

        public String getDName() { return dName; }
        public void setDName(String dName) { this.dName = dName; }
    }

    // Correct Getters/Setters
    public Long getEmpId() { return empId; }
    public void setEmpId(Long empId) { this.empId = empId; }

    public String getFName() { return fName; }
    public void setFName(String fName) { this.fName = fName; }

    public String getLName() { return lName; }
    public void setLName(String lName) { this.lName = lName; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public double getBaseSal() { return baseSal; }
    public void setBaseSal(double baseSal) { this.baseSal = baseSal; }

    public String getJoiningDate() { return joiningDate; }
    public void setJoiningDate(String joiningDate) { this.joiningDate = joiningDate; }

    public DeptDTO getDept() { return dept; }
    public void setDept(DeptDTO dept) { this.dept = dept; }
}
