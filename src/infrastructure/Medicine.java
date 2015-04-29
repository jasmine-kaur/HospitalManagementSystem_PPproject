/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infrastructure;

/**
 *
 * @author Mansi Verma
 */
public class Medicine {

    private long medicineId;
    private String medicineName;
    private int dosage;
    private int quantity;
    
    private long getMedicineId(){
        return medicineId;
    }
    
    public String getMedicineName(){
        return medicineName;
    }
    
    public void setMedicineName(String medicineName){
        this.medicineName=medicineName;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public void setQuantity(int quantity){
        this.quantity=quantity;
    }
    
    public int getDosage(){
        return quantity;
    }
    
    public void setDosage(int dose){
        this.dosage=dose;
    }
    
}
