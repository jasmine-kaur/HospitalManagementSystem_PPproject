
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasicDetails;

/**
 *
 * @author Mansi Verma
 */
public class Name {
    private String firstname;
    private String secondname;
    private String thirdname;
    
    public Name(String firstname, String secondname,String thirdname){
        this.firstname=firstname;
        this.secondname=secondname;
        this.thirdname=thirdname;
    }
    
    public void setFirstname(String firstname){
        this.firstname=firstname;
    }
    
    
    public void setSecondname(String secondname){
        this.secondname=secondname;
    }
    
    
    public void setThirdname(String thirdname){
        this.thirdname=thirdname;
    }
    
    public String getFirstname(){
        return this.firstname;
    }
    
    public String getSecondname(){
        return this.secondname;
    }
    
    public String getThirdname(){
        
        return this.thirdname;
    }
    
    @Override
     public String toString(){
        return " "+this.firstname+" "+this.secondname+this.thirdname;
    }
}
