/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdummy;

import java.util.Date;

/**
 *
 * @author TUSHAR MUHAMMAD
 */
public class ordersDisplay{

    private String oid,cusname,cusphn;
    private Date odate, ddate;
    public ordersDisplay(String oid, String cusname,
            String cusphn, Date odate, Date ddate) {
        this.oid = oid;
        this.cusname = cusname;
        this.cusphn = cusphn;
        this.odate = odate;
        this.ddate = ddate;
    }
    
    public String getoid() {
        return oid;
    }
          
     public String getcusname() {
        return cusname;
    }

    public String getcusphn() {
        return cusphn;
    }   
    
    public Date getodate() {
        return odate;
    }
    
    public Date getddate() {
        return ddate;
    }
    
    
    public void setoid(String oid) {
        this.oid = oid;
    }
     
    public void setcusname(String cusname) {
        this.cusname = cusname;
    }
    
    public void setcusphn(String cusphn) {
        this.cusphn = cusphn;
    }
     
    public void setodate(Date odate) {
        this.odate = odate;
    }
    public void setddate(Date ddate) {
        this.ddate = ddate;
    }
  
}
