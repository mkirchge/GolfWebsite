/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reststuff;

/**
 *
 * @author maxkirchgesner
 */
public class orderdetails {
    
    private String name;
    private String phone;
    private String ccname;
    private String ccnum;
    private String ccsn;
    private String billing;
    private String shipping;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getCCName() {
        return ccname;
    }

    public void setCCName(String ccname) {
        this.ccname = ccname;
    }
    
    public String getCCNum() {
        return ccnum;
    }

    public void setCCNum(String ccnum) {
        this.ccnum = ccnum;
    }
    
    public String getCCsn() {
        return ccsn;
    }

    public void setCCsn(String ccsn) {
        this.ccsn = ccsn;
    }
    
    public String getBilling() {
        return billing;
    }

    public void setBilling(String billing) {
        this.billing = billing;
    }
    
    public String getShipping() {
        return shipping;
    }

    public void setShipping(String shipping) {
        this.shipping = shipping;
    }
    
}
