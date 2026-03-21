/**
 * Message type priority
Implement console program which will meet the following requirements:
a. Program starts and ask user to enter message type
b. Only ‘A’, ‘B’, ‘C’ or ‘D’ message types are allowed.
c. In case user entered invalid message type, program asks to enter message type again
d. When valid message type is entered program prints message type priority to console
e. Priority and Message Type implemented as enum types
f. Message types have next priorities:
Message Type Priority
A HIGH
B MEDIUM
C LOW
D LOW

MessageType enum has next method:

public Priority getPriority() {
        <write your code here>
}
 */
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;


public class HomeworkEnum {
  // ---- Demo ----
  public static void main(String[] args) {
    /* Stream.of(MessageType.values()).forEach(e -> System.out.print(e.name()+" "));
    System.out.println(); */
    Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("Please, enter message type to check it's priority: ");
			String userInput = sc.next();

			if (isValidMessageType(userInput)) {
				System.out.println("For your MessageType the priority is: " +
                           MessageType.valueOf(userInput).getPriority().toString());
				break;
			} else {
				System.out.println("Please, enter valid "
						+ "message type. Only 'A', 'B', 'C' or 'D' are allowed");
				continue;
			}

		}
  }

  private static boolean isValidMessageType(String userInput) {
    /* return Arrays.asList(MessageType.values())
                  .stream()
                  .map(MessageType::name)
                  .toList().contains(userInput); */
    for(MessageType type : MessageType.values())
      if(type.name() == userInput) return true;

    return false;
	}
}

// ---- Enums ----
enum Priority { HIGH, MEDIUM, LOW }

enum MessageType {
  A(Priority.HIGH), B(Priority.MEDIUM), C(Priority.LOW), D(Priority.LOW);
  
  private Priority priority;

  private MessageType(Priority priority) { this.priority = priority; }

  public Priority getPriority() {
    return this.priority;
  }
}
