package com.backend.sqs.controller;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

@RestController
public class BackendController {

    @Value("${aws.region}")
    private String awsRegion;

    @Value("${sqs.queueUrl}")
    private String sqsQueueUrl;

    @Value("${dynamodb.tableName}")
    private String dynamoDBTableName;

    @GetMapping("/processMessages")
    public String processMessagesFromSQS() {
        AmazonSQS sqs = AmazonSQSClientBuilder.standard()
                .withCredentials(DefaultAWSCredentialsProviderChain.getInstance())
                .withRegion(awsRegion)
                .build();

        AmazonDynamoDB dynamoDB = AmazonDynamoDBClientBuilder.standard()
                .withCredentials(DefaultAWSCredentialsProviderChain.getInstance())
                .withRegion(awsRegion)
                .build();

        DynamoDB dynamoDBClient = new DynamoDB(dynamoDB);

        while (true) {
            // Receive messages from SQS
            for (Message message : sqs.receiveMessage(sqsQueueUrl).getMessages()) {
                String messageBody = message.getBody();
                // Process the message (you can perform any required backend processing here)

                // Create a unique identifier for the DynamoDB item
                String messageId = UUID.randomUUID().toString();

                // Create an Item object with the message data
                Item item = new Item()
                        .withPrimaryKey("message_id", messageId) // Set the primary key attribute
                        .withString("message_body", messageBody); // Add other attributes as needed

                // Put the Item into DynamoDB
                dynamoDBClient.getTable(dynamoDBTableName).putItem(item);

                // Delete the message from SQS to avoid duplication
                sqs.deleteMessage(sqsQueueUrl, message.getReceiptHandle());
            }
        }
    }
    
    
}