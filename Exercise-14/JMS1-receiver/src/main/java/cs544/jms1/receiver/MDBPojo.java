package cs544.jms1.receiver;

import javax.jms.*;

public class MDBPojo implements MessageListener {

    public void onMessage(Message message){
    	ObjectMessage objmessage = (ObjectMessage)message;
    	try {
			Person person = (Person)objmessage.getObject();
			System.out.println("MDBPojo receives message with person object : " + person.getFirstName()+" "+person.getLastName());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}

