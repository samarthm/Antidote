/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication13;

import com.twilio.sdk.TwilioRestException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author samarthmadduru
 */
public class Server {
    
    public static void stayOn() throws InterruptedException, TwilioRestException, IOException{
        while(!(getTheirMessage.returnParsed().contains("42.00"))){
            getTheirMessage.returnParsed();
            TimeUnit.SECONDS.sleep(3);

            
        }
        if(getTheirMessage.returnParsed().contains("42.00")){
            HelloTwilio.sendMessageToAll("+12248294273");
        }
        while(!(getTheirMessage.returnParsed().contains("42.00"))){
            getTheirMessage.returnParsed();
            TimeUnit.SECONDS.sleep(3);            
        }
        if(getTheirMessage.returnParsed().contains("42.00")){
            HelloTwilio.sendMessageToAll("+12248294273");
        }
       
    }
    
    public static void main(String[] args) throws InterruptedException, TwilioRestException, IOException{
        stayOn();
    }
    
}
