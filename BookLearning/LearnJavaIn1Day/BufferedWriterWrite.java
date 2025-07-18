import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterWrite {
  public static void main(String[] args) {
    String text = "Hello World";

    // If the argument in the FileWriter is 'false' it will overwrite the data in the file, instead of appending it
    // And if the file doesn't exist it will create it
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("myFile2.txt", true)))
    {
      writer.write(text);
      writer.newLine();
    }
    catch ( IOException e )
    {
      System.out.println(e.getMessage());
    }
  }
}
