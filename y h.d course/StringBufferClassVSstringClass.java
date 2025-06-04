public class StringBufferClassVSstringClass {
  private static final int ITERATIONS = 100000;
  private static final int BUFFSIZE = 16;

  private void concatString() {
    System.out.print("concatString  -> ");
    long startTime = System.currentTimeMillis();
    String concat = "";
    for(int i = 0; i < ITERATIONS; i++) {
      concat += i % 10;
    }
    long endTime = System.currentTimeMillis();
    System.out.print("length: " + concat.length());
    System.out.println(" time: " + (endTime - startTime));
  }//end concatString

  private void concatStringBuffer() {
    System.out.print("concatStringBuffer  -> ");
    long startTime = System.currentTimeMillis();
    StringBuffer concat = new StringBuffer(BUFFSIZE);
    for(int i = 0; i < ITERATIONS; i++) {
      concat.append(i % 10);
    }
    long endTime = System.currentTimeMillis();
    System.out.print("length: " + concat.length());
    System.out.println(" time: " + (endTime - startTime));
  }//end concatStringBuffer

  public static void main(String[] args) {
    String str = new String("Hello ");
    str += "Stanford";

    StringBuffer strb = new StringBuffer("Hello ");
    strb.append("Stanford");

    StringBufferClassVSstringClass st = new StringBufferClassVSstringClass();
    System.out.println("Iterations: " + ITERATIONS);
    System.out.println("Buffer    : " + BUFFSIZE);

    st.concatStringBuffer();
    st.concatString();
  }//end main
}

