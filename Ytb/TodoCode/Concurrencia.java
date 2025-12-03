public class Concurrencia {

  public static void main(String[] args) {

      Hilo proceso = new Hilo();  //creado como hilo
      proceso.start();
      /* Causes this thread to begin execution;
      * the Java Virtual Machine calls the run method of this thread. */
     
     Thread proceso2 = new Thread(new HiloRunnable());  //crearlo a travez de un hilo
     proceso2.start();
     //Runnable permite una mejor utilización de codigo

    }

  public class Hilo extends Thread {
    @Override
    public void run() {
      System.out.println("Hilo ejecutándose con clase Thread");
    }
  }

  public class HiloRunnable implements Runnable {
    @Override
    public void run() {
      System.out.println("Hilo ejecutándose usando Runnable");
    }
  }

}
