public class StringBuilderFun {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Jack Sparrow");

        System.out.println(System.identityHashCode(sb));

        sb.append(" is awesome");
        System.out.println(sb);

        sb.insert(5, "Foo ");
        System.out.println(sb);

        sb.replace(5, 8, "Bar"); //2nd param is exclusive, 1st is inclusive
        System.out.println(sb);

        sb.delete(5, 9); //2nd param is exclusive, 1st is inclusive
        System.out.println(sb);

        System.out.println(System.identityHashCode(sb));
    }//end main
}