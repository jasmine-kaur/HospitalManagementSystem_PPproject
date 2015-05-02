/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staff;

/**
 *
 * @author Mansi Verma
 */
public enum StaffType {
    DOCTOR("doctor"),
    WARDBOY("wardboy"),
    HOD("hod"),
    NURSE("nurse"),
    RECEPTIONIST("receptionist"),
    TRAUMASURGEON("traumasurgeon"),
    PATHOLOGYDESK("pathologydesk"),
    RADIOLOGYDESK("radiologydesk"),
    EMERGENCYDESK("emergencydesk"),
    DEPARTMENTADMIN("departmentadmin"),
    STAFFADMIN("staffadmin"),
    WARDCARETAKER("wardcaretaker"),
    ACCOUNTANT("accountant"),
    INFRAADMIN("infraadmin");
    
    
    private final String staffType;
    
    private StaffType(final String staffType){
        this.staffType=staffType;
    }
    
     public String getStaffType() {
        return staffType;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return staffType;
    }
}
