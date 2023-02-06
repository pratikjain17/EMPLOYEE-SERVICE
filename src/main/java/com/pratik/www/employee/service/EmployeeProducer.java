package com.pratik.www.employee.service;

import com.pratik.www.employee.db.entity.EmployeeEntity;
import com.pratik.www.employee.db.repository.EmployeeEntityRepository;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeProducer.class);
    private NewTopic topic;

    @Autowired
    private EmployeeEntityRepository employeeRepo;

    @Autowired
    private KafkaTemplate<String, EmployeeEntity> kafkaTemplate;

    public EmployeeProducer(NewTopic topic, KafkaTemplate<String, EmployeeEntity> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String employeeId){
        EmployeeEntity employee = employeeRepo.findById(employeeId).get();
        LOGGER.info(String.format("Order Event => %s", employee.toString()));

        Message<EmployeeEntity> message = MessageBuilder.withPayload(employee)
                .build();
        kafkaTemplate.send(message);
    }
}
