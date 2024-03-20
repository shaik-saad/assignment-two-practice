# First stage
# Install Java Development Kit on Alpine
FROM openjdk:8-jdk-alpine AS builder

# Make a working directory
WORKDIR /app

# Copy java file from host to current working directory on container
COPY ./src/Calculator.java .

# Run java compile command to create class file and jar command to create jar file
RUN javac Calculator.java && \
    jar cvfe CalculatorApp.jar Calculator Calculator.class


# Second stage
# Install Java Runtime Environment on Alpine
FROM openjdk:8-jre-alpine

# Make a working directory
WORKDIR /app

# Copy jar file from previous build to current working directory on container
COPY --from=builder /app/CalculatorApp.jar .

# Meta data for the image
LABEL description="CLI Calculator App builder" \
        maintainer="https://github.com/shaik-saad" \
        version="1.0.0"