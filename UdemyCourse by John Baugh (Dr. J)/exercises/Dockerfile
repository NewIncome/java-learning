# We need a specific version of OpenJDK for Java
FROM openjdk:11

# Set working directory
WORKDIR /djavab0

# Copy the necessary source files
COPY UserInput.java .

# Compile the Java program
RUN javac UserInput.java

# Set the default command to run our Java program
CMD ["java", "UserInput"]
