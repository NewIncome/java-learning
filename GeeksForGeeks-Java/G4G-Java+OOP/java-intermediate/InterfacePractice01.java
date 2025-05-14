/**
 * Project/exercise to practice Java Interfaces
 * Suggested by Gemini
 * Complete requirements in GoogleDocs 'Java practice exercises', in the link:
 * https://docs.google.com/document/d/1dXUg2GsvIJhSTGJ-ylxtvsPUs5wuI2UwSaE9AsQAksc/edit?tab=t.0
 */
@FunctionalInterface
interface TaskPerformer {
  void begin(String task);  
}

interface MultifunctionalDevice {
  //abstract methods
  void powerOn();
  void powerOff();
  void performTask(TaskPerformer taskName);
  String getDeviceInfo();

  default void displayBatteryLevel() {
    System.out.println("N/A");
  }

  static void getManufacturer() {
    System.out.println("Umbrella Corp");
  }
}

class SmartPhone implements MultifunctionalDevice {
  private String brand, model;
  private int batteryLevel = 100;

  public SmartPhone(String brand, String model) {
    this.brand = brand;
    this.model = model;
  }

  @Override
  public void powerOn() {
    System.out.println("Smartphone powering on");
  }
  @Override
  public void powerOff() {
    System.out.println("Smartphone shutting off");
  }
  //Method to be used by a Lambda expression
  @Override
  public void performTask(TaskPerformer task) {
    //call the abstract method of the TaskPerformer -instance-
    task.begin(getDeviceInfo());
  }
  @Override
  public String getDeviceInfo() {
    return brand + " - " + model;
  }

  @Override
  public void displayBatteryLevel() {
    System.out.println("Battery level: " + batteryLevel + "%");
  }

  //Method to serve as implementation for the TaskPerformer interface, by Method Reference
  public void takePhoto(String task) {
    System.out.println("Performing the Photo task _" + task + "_");
  }
}

class SmartTelevision extends SmartPhone {
  public SmartTelevision(String brand, String model) {
    super(brand, model);
  }

  @Override
  public void displayBatteryLevel() {
    System.out.println("Not applicable - requires external power");
  }

  //Method to serve as implementation for the TaskPerformer interface, by Method Reference
  public void playVideo(String task) {
    System.out.println("Performing the Video task _" + task + "_");
  }
}

public class InterfacePractice01 {
  public static void main(String[] args) {
    MultifunctionalDevice.getManufacturer();
    createExtraLine();

    SmartPhone phone1 = new SmartPhone("Xiaomi", "Poco");
    SmartTelevision tv1 = new SmartTelevision("LG", "4K");

    //Implementing with Lambda Expressions, some modified tasks
    TaskPerformer task1 = (str) -> System.out.println("Performing the following SmartPhone task on: ..." + str + "...");
    TaskPerformer task2 = (str) -> System.out.println("Performing the following SmartTelevision task on: ..." + str + "...");

    phone1.performTask(task1);
    tv1.performTask(task2);
    createExtraLine();

    // Using Method Reference to SmartPhone's takePhoto method
    TaskPerformer phoneTask = phone1::takePhoto;
    phoneTask.begin("Fast Photo");
    // Using Method Reference to SmartTelevision's playVideo method
    TaskPerformer tvTask = tv1::playVideo;
    tvTask.begin("Play from ending");
  }

  static void createExtraLine() { System.out.println(); }
}

// Pendings:
// (1)visual of how the lambda gets called
// (2)if not too difficult do the same for Method References
// (3)explore OpenSource Java projects on Github
