/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package account;

import BasicDetails.Name;
import java.util.Date;

/**
 *
 * @author Devanshu
 */
public class ExternalFunders {
    
    private int fundId;
    private Name trusteeName;
    private Date dateOfFunding;
    private long chequeNumber;
    private long accountNumber;
    private Name bankName;
    private long amountGiven;

    public void addUI(){
        this.fundId=0;
        this.amountGiven=0;
        this.bankName=null;
        this.chequeNumber=0;
        this.trusteeName=null;
        this.dateOfFunding=null;
        this.accountNumber=0;
    }
}
