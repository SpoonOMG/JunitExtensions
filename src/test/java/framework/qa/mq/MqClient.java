package framework.qa.mq;

import com.ibm.mq.jms.MQQueueConnectionFactory;
import com.ibm.msg.client.wmq.WMQConstants;
import framework.qa.config.Config;

import javax.jms.JMSException;
import javax.jms.QueueConnection;
import java.util.function.Supplier;

public abstract class MqClient {
    protected static final Config CFG = Config.getInstance();

    public MqClient() throws JMSException {
        connect();
    }

    public Supplier<QueueConnection> connect() throws JMSException {
        return () -> {
            try {
                var cf = new MQQueueConnectionFactory();
                cf.setTransportType(WMQConstants.WMQ_CM_CLIENT);
                cf.setBooleanProperty(WMQConstants.USER_AUTHENTICATION_MQCSP, false);
                System.setProperty("com.ibm.mq.cfg.useIBMCipherMappings", "false");
                cf.setHostName(CFG.mqHost());
                cf.setPort(CFG.port());
                cf.setQueueManager(CFG.queueManager());
                cf.setChannel(CFG.channel());
                cf.setStringProperty(WMQConstants.USERID, CFG.user());
                cf.setStringProperty(WMQConstants.PASSWORD, CFG.pass());
                cf.setAppName(CFG.mq_appName());
                return cf.createQueueConnection();
            } catch (JMSException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        };
    }



}
