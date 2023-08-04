## Backend Application Summary

The `backend-sqs` directory contains the Spring Boot backend application that processes messages received from the SQS queue. To set up and run the application:

1. Open the `backend-sqs` directory in your preferred IDE (e.g., IntelliJ IDEA, Eclipse).
2. Build the project to resolve dependencies.
3. Configure the AWS SDK with the SQS queue URL , Dynabmo Table name and credentials (Replace `YOUR_AWS_ACCESS_KEY`, `YOUR_AWS_SECRET_KEY`, `dynamodb.tableName` and `sqs.queueUrl` with your actual AWS access key and secret key, respectively in application.properties file).

    Note: Ensure to keep your AWS credentials secure and avoid exposing them publicly in version control systems.

4. Run the `Backend Application` class to start the Spring Boot application.

The Backend application is now running locally and connected to your AWS SQS queue. Feel free to explore and enhance this application as needed to suit your project requirements.

Happy coding! 😊🚀