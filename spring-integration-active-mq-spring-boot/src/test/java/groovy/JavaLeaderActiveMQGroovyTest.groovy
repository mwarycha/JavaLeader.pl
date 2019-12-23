package groovy

import org.springframework.boot.test.context.SpringBootContextLoader
import pl.javaleader.springintegrationactivemqspringboot.SpringIntegrationActiveMqSpringBootApplication
import pl.javaleader.springintegrationactivemqspringboot.configurations.ActiveMQConfig
import spock.lang.Specification
import javax.jms.Connection
import javax.jms.ConnectionFactory
import javax.jms.DeliveryMode
import javax.jms.Destination
import javax.jms.MessageProducer
import javax.jms.Session
import javax.jms.TextMessage

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.test.context.ContextConfiguration
import org.springframework.beans.factory.annotation.Autowired

@ContextConfiguration(loader = SpringBootContextLoader.class, classes = [SpringIntegrationActiveMqSpringBootApplication])
class JavaLeaderServiceTest extends Specification{

    @Autowired
    @Qualifier("jmsConnectionFactory")
    ConnectionFactory connectionFactory

    String queueName = ActiveMQConfig.JAVA_LEADER_QUEUE
    Session session
    Destination destination
    MessageProducer producer

    def setup(){
        Connection conn = connectionFactory.createConnection()
        conn.start()
        session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE)
        destination = session.createQueue(queueName)
        this.producer = session.createProducer(destination)
        this.producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT)
    }

    def "Test Send and Receive of JavaLeader Message"() {
        given:
            TextMessage txtMessage = session.createTextMessage()
            txtMessage.setText("JavaLeader.pl")
        when:
            producer.send(destination, txtMessage)
            sleep(3000) // wait 3 seconds
            then:
            true
    }
}