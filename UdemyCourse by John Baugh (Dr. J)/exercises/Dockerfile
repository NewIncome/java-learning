# We need a specific version of OpenJDK for Java
FROM openjdk:11

# Set working directory
WORKDIR /djavab0

# Copy the necessary source files
COPY Proj4_3_Parallel.java .

# Compile the Java program
RUN javac Proj4_3_Parallel.java

# Set the default command to run our Java program
CMD ["java", "Proj4_3_Parallel"]

# To delete the created images and containers
#docker rm $(docker ps -a -q --filter ancestor=djava01) && docker rmi djava01