package javaapplication13;



import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.SmsFactory;
import com.twilio.sdk.resource.instance.Account;
import java.io.IOException;
 
import java.util.HashMap;
 
public class HelloTwilio {
    
    public static void sendMessageToAll(String str) throws TwilioRestException, IOException{
        TwilioRestClient client = new TwilioRestClient("ACbd6bbceb4130efb0c898d4db3040b7ce", "db13a34093a347237d703471a7837115");
 
        Account account = client.getAccount();
 
        SmsFactory factory = account.getSmsFactory();
 
        HashMap<String, String> message = new HashMap<>();
 
        message.put("To", str);
        message.put("From", "+12245325413");
        message.put("Body", "Be wary, there might be a rape incident near: "+ getTheirMessage.formatted());
 
        factory.create(message);
    }
    
    public static void main(String[] args) throws TwilioRestException, IOException {
        sendMessageToAll("+12248294273");
    }
}
