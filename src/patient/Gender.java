/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package patient;

/**
 *
 * @author Devanshu
 */
public enum Gender{
    
    MALE("male"),
    FEMALE("female");
    
    private final String gender;
    
    private Gender(final String g){
        this.gender=g;
    }
    
     public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return gender;
    }
    
}
