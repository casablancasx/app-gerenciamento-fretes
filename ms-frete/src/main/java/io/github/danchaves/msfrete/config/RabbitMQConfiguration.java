package io.github.danchaves.msfrete.config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    @Value("${rabbitmq.exchange.frete}")
    private String exchange;

    @Value("${rabbitmq.queue.frete-deletado}")
    private String filaFreteDeletadoMsEmail;


    @Value("${rabbitmq.queue.frete-cadastrado}")
    private String filaFreteCadastradoMsEmail;


    @Value("${rabbitmq.routinkey.fretecadastrado}")
    private String routingKeyFreteCadastrado;

   @Value("${rabbitmq.queue.frete-deletado}")
    private String routingKeyFreteDeletado;



    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory){
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public ApplicationListener<ApplicationReadyEvent> inicializarRabbitAdmin(RabbitAdmin rabbitAdmin){
        return event -> rabbitAdmin.initialize();
    }

    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }


    @Bean
    public DirectExchange exchange(){
        return ExchangeBuilder.directExchange(exchange).build();
    }

    @Bean
    public Queue criarFilaFreteCadastrado(){
        return QueueBuilder.durable(filaFreteCadastradoMsEmail).build();
    }

    @Bean
    public Queue criarFilaFreteDeletado(){
        return QueueBuilder.durable(filaFreteDeletadoMsEmail).build();
    }

    @Bean
    public Binding bindingFreteCadastradoMsEmail(){
        return BindingBuilder.bind(criarFilaFreteCadastrado()).to(exchange()).with(routingKeyFreteCadastrado);
    }
    @Bean
    public Binding bindingFreteDeletadoMsEmail(){
        return BindingBuilder.bind(criarFilaFreteCadastrado()).to(exchange()).with(routingKeyFreteDeletado);
    }

}
