package dbs.assignment.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.util.ErrorHandler;

import dbs.assignment.documents.OrderTransaction;

import javax.jms.ConnectionFactory;


@ComponentScan(basePackages = "dbs.assignment")
@SpringBootApplication
@EnableJms
public class OrderprocessApplication {

  public static void main(String[] args) {
    SpringApplication.run(OrderprocessApplication.class, args);
  }

  @Bean
  public JmsListenerContainerFactory<?> myFactory(final ConnectionFactory connectionFactory,
      final DefaultJmsListenerContainerFactoryConfigurer configurer) {
    final DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
    // This provides all boot's default to this factory, including the message
    // converter
    configurer.configure(factory, connectionFactory);
    // You could still override some of Boot's default if necessary.
    return factory;
  }

  @Bean // Serialize message content to json using TextMessage
  public MessageConverter jacksonJmsMessageConverter() {
    final MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
    converter.setTargetType(MessageType.TEXT);
    converter.setTypeIdPropertyName("_type");
    return converter;
  }

/*  public static void main(final String[] args) {
    // Launch the application
    final ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

    final JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

    // Send a message with a POJO - the template reuse the message converter
    System.out.println("Sending an order message.");
    jmsTemplate.convertAndSend("OrderTransactionQueue", new OrderTransaction("soumya", "nithesh",900));
  }*/
}