import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.nio.charset.StandardCharsets;

public class NewTask {

    private static final String TASK_QUEUE_NAME = "task_queue";

    public static void main (String [] argv) throws Exception {
        ConnectionFactory connectionFactory = new ConnectionFactory ();
        connectionFactory.setHost ("localhost");
        connectionFactory.setUsername("mqadmin");
        connectionFactory.setPassword("Admin123XX_");

        try (Connection connection = connectionFactory.newConnection ();
             Channel channel = connection.createChannel ()) {
             channel.queueDeclare (TASK_QUEUE_NAME, true, false, false, null);

             String mensagem = "Olá sou JORGE RICARDO SOARES A.A de Souza";

             channel.basicPublish ("", TASK_QUEUE_NAME,
                    MessageProperties.PERSISTENT_TEXT_PLAIN,
                    mensagem.getBytes(StandardCharsets.UTF_8));
             System.out.println ("[x] Enviado '" + mensagem + "'");
        }
    }

}
