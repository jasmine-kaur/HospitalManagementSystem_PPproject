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
public enum DepartmentType {
    CARDIOLOGY("cardiology"),
    NEUROLOGY("neurology"),
    PEDIATRITION("pediatrition"),
    OPTHALMOLOGY("opthalmology"),
    ENT("ent");
    private final String departmentType;
    
    private DepartmentType(final String departmentType){
        this.departmentType=departmentType;
    }
    
     public String getStaffType() {
        return departmentType;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return departmentType;
    }
}
