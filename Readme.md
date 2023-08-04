# Decoupling Applications with Spring Boot and Amazon SQS

## Introduction

This repository contains the code and resources for the tech blog titled "Decoupling Applications with Spring Boot and Amazon Simple Queue Service (SQS)." In this tutorial, we explore the concept of decoupling applications using Spring Boot and SQS on AWS. Decoupling applications is a crucial architectural pattern that promotes loose coupling between different components, making them more scalable, maintainable, and fault-tolerant.

## Prerequisites

Before getting started with the code, ensure you have the following prerequisites:

1. Java Development Kit (JDK) installed for Spring Boot development.
2. AWS account with appropriate access credentials.
3. AWS SDK for Java installed and configured with credentials on your local machine.

## Project Structure

The repository is organized as follows:

- `frontend-sqs`: This directory contains the Spring Boot frontend application. It handles user interactions with a webpage and sends messages to an SQS queue.

- `backend-sqs`: This directory contains the Spring Boot backend application. It processes the messages received from the SQS queue and stores them in a DynamoDB table.

- `terraform`: This directory contains the terraform file to provision Amazon SQS and Dyanamo DB.

## Setup and Deployment

Follow the steps below to set up and deploy the applications:

1. Clone this repository to your local machine.

```bash
git clone https://github.com/Aman98roy/Amazon-SQS-Decoupling-Application.git
cd Amazon-SQS-Decoupling-Application

