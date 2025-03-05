# We need a specific version of OpenJDK for Java
FROM openjdk:11

# Set working directory
WORKDIR /djavab0

# Copy the necessary source files
COPY House.java .
COPY HouseDemo.java .

# Compile the Java program
RUN javac HouseDemo.java

# Set the default command to run our Java program
CMD ["java", "HouseDemo"]

# To delete the created images and containers
#docker rm $(docker ps -a -q --filter ancestor=djava01) && docker rmi djava01