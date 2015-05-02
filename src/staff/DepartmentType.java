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
    PEDIATRICIAN("pediatrician"),
    ORTHOPEDIC("orthopedic");
    private final String departmentType;
    
    private DepartmentType(final String DepartmentType){
        this.departmentType=DepartmentType;
    }
    
     public String getDepartmentType() {
        return departmentType;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return departmentType;
    }
}
