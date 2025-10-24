package com.hrms.payroll.entity;

public class AttendanceDTO {
    private Long id;
    private Long empId;
    private Integer presentDays;
    private Integer absentDays;
    private Integer leaveDays;

    public AttendanceDTO() {
    }

    public AttendanceDTO(Long id, Long empId, Integer presentDays, Integer absentDays, Integer leaveDays) {
        this.id = id;
        this.empId = empId;
        this.presentDays = presentDays;
        this.absentDays = absentDays;
        this.leaveDays = leaveDays;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public Integer getPresentDays() {
        return presentDays;
    }

    public void setPresentDays(Integer presentDays) {
        this.presentDays = presentDays;
    }

    public Integer getAbsentDays() {
        return absentDays;
    }

    public void setAbsentDays(Integer absentDays) {
        this.absentDays = absentDays;
    }

    public Integer getLeaveDays() {
        return leaveDays;
    }

    public void setLeaveDays(Integer leaveDays) {
        this.leaveDays = leaveDays;
    }
}