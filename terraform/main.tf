# Terraform Settings Block
terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 5.11" # Optional but recommended in production
    }
  }
}

# Provider Block
provider "aws" {
  profile = "default" # AWS Credentials Profile configured on your local desktop terminal  $HOME/.aws/credentials
  region  = "us-east-1"
}


# Create an SQS queue resource
resource "aws_sqs_queue" "frontend_queue" {
  name = "frontend-queue"  # Replace with your desired queue name
}

# Create a DynamoDB table resource
resource "aws_dynamodb_table" "message_table" {
  name         = "message-table"  # Replace with your desired table name
  billing_mode = "PAY_PER_REQUEST"  # Use on-demand billing for the table

  # Define the primary key for the table
  hash_key = "message_id"  # Use "message_id" attribute as the hash key

  attribute {
    name = "message_id"  # Name of the attribute used as the hash key
    type = "S"  # Data type of the hash key, "S" represents a string type
  }
}
