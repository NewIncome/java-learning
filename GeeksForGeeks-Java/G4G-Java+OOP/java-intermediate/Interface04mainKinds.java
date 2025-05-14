import java.util.function.*;

class SmartDevice {
  private String name;

  SmartDevice(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public boolean isOnline() {
    return true; // Let's assume all devices are online
  }

  public void performAction(String action) {
    System.out.println(name + " is performing: " + action);
  }
}

public class Interface04mainKinds {
  public static void main(String[] args) {
    // Create a SmartDevice
    SmartDevice device = new SmartDevice("SmartPhone");

    // 1. Consumer: perform an action on the device
    Consumer<String> actionPerformer = device::performAction;
    actionPerformer.accept("Taking a photo");

    // 2. Supplier: get something from the device
    Supplier<String> nameSupplier = device::getName;
    System.out.println("Device name is: " + nameSupplier.get());

    // 3. Function: transform device name to uppercase
    Function<String, String> toUpperCase = String::toUpperCase;
    System.out.println("Uppercase name: " + toUpperCase.apply(device.getName()));

    // 4. Predicate: check if device is online
    Predicate<SmartDevice> isDeviceOnline = SmartDevice::isOnline;
    System.out.println("Is device online? " + isDeviceOnline.test(device));
  }
}
