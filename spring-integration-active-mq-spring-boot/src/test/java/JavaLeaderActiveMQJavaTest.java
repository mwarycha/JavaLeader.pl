import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import junit.framework.TestCase;
import org.springframework.boot.test.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;
import pl.javaleader.springintegrationactivemqspringboot.SpringIntegrationActiveMqSpringBootApplication;
import pl.javaleader.springintegrationactivemqspringboot.configurations.ActiveMQConfig;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringIntegrationActiveMqSpringBootApplication.class)
public class JavaLeaderActiveMQJavaTest extends TestCase {
 
    @Rule
    public OutputCapture outputCapture = new OutputCapture();
 
    @Autowired
    @Qualifier("jmsConnectionFactory")
    ConnectionFactory jmsConnectionFactory;

    String queueName = ActiveMQConfig.JAVA_LEADER_QUEUE;

    MessageProducer jmsamqproducer;
    Destination jmsamqdestination;
    Session jmsamqsession;
    Connection jmsamqconn;

    @Before
    public void setUpJmsSession() throws JMSException {
        jmsamqconn = jmsConnectionFactory.createConnection();
        jmsamqconn.start();
        jmsamqsession     = jmsamqconn.createSession(false, Session.AUTO_ACKNOWLEDGE);
        jmsamqdestination = jmsamqsession.createQueue(queueName);
        jmsamqproducer    = jmsamqsession.createProducer(jmsamqdestination);
        jmsamqproducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
    }
     
    @After
    public void tearDownJmsSession() throws JMSException {
        jmsamqsession.close();
        jmsamqconn.close();

    }
 
    @Test
    public void testSendMsgToConsumer() {
        try {
            TextMessage msg = jmsamqsession.createTextMessage("JavaLeader.pl message");
            jmsamqproducer.send(jmsamqdestination, msg);
            Thread.sleep(3000L);
            assertTrue(this.outputCapture.toString().contains("JavaLeader.pl message"));
        } catch (JMSException e) {
            fail();
        } catch (InterruptedException e) {
            fail();
        }
    }
}