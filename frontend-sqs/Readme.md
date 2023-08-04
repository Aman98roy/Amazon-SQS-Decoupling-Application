## Frontend Application Summary

The `frontend-sqs` directory contains the Spring Boot frontend application that handles user interactions with a webpage and sends messages to an SQS queue. To set up and run the application:

1. Open the `frontend-sqs` directory in your preferred IDE (e.g., IntelliJ IDEA, Eclipse).
2. Build the project to resolve dependencies.
3. Configure the AWS SDK with the SQS queue URL in `Controller Class` and credentials (Replace `YOUR_AWS_ACCESS_KEY` and `YOUR_AWS_SECRET_KEY` with your actual AWS access key and secret key, respectively in application.properties file).

    Note: Ensure to keep your AWS credentials secure and avoid exposing them publicly in version control systems.

4. Run the `FrontendApplication` class to start the Spring Boot application.

The frontend application is now running locally and connected to your AWS SQS queue. Feel free to explore and enhance this application as needed to suit your project requirements.

Happy coding! 😊🚀