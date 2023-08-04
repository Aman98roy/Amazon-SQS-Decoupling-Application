package com.frontend.sqs.controller;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FrontendController {

    @Value("${aws.region}")
    private String awsRegion;

    @PostMapping("/send")
    @ResponseBody
    public ModelAndView  sendMessageToSQS(@RequestParam String message) {
        AmazonSQS sqs = AmazonSQSClientBuilder.standard()
                .withCredentials(DefaultAWSCredentialsProviderChain.getInstance())
                .withRegion(awsRegion)
                .build();

        // Replace "your-queue-url" with the actual URL of your SQS queue
        String queueUrl = "https://sqs.us-east-1.amazonaws.com/106976931628/frontend-queue";

        sqs.sendMessage(queueUrl, message);
        return  new ModelAndView("message");
    }
}