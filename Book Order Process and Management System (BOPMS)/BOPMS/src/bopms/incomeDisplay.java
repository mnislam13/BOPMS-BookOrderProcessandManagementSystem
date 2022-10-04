/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdummy;

import java.util.Date;

/**
 *
 * @author user
 */
public class incomeDisplay {
    private int timeframe;
    private float amount;
  
    
    public incomeDisplay(int timeframe,float amount)
    {
        
        this.timeframe = timeframe;
        this.amount = amount;
    }
    
    public int gettimeframe() {
        return timeframe;
    }
     
    public float getamount() {
        return amount;
    }
    public void settimeframe(int timeframe) {
        this.timeframe = timeframe;
    }
    
    public void setamount(float amount) {
        this.amount = amount;
    }
}
