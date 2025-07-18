import java.io.*;

public class BufferReaderRead {
  public static void main(String[] args) {
    String line;

    // With this 'try-with-resources' statement, Java will automatically close the BufferedReader object
    try (BufferedReader reader = new BufferedReader(new FileReader("myFile.txt")))
    {
      line = reader.readLine();
   
      while (line != null)
      {
        System.out.println(line);
        line = reader.readLine();
      }
    }
    catch (IOException e)
    {
      System.out.println(e.getMessage());
    }

    //before Java 7 way, for Legacy code
    /*BufferedReader reader = null;

    try
    {
      reader = new BufferedReader(new FileReader("myFile.txt"));
      line = reader.readLine();           
      while (line != null)
      {
          System.out.println(line);
          line = reader.readLine();
      }
    }
    catch (IOException e)
    {
      System.out.println(e.getMessage());
    }
    finally
    {
        try
        {
          if (reader != null)
            reader.close();
        }
        catch (IOException e)
        {
          System.out.println(e.getMessage());
        }
    }*/
  }
}
