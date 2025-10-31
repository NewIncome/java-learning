import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectorsPract1 {
  
  public static void main(String[] args) {
    
    //Collectors.toList
    List<String> nombres = List.of("Luisina", "Ibra", "Suscribite", "TodoCode");
    List<String> nombresConA = nombres.stream().filter(e -> e.contains("a")).collect(Collectors.toList());

    //Collectors.toSet
    List<String> lenguajes = List.of("java", "python", "java", "PHP", "javascript");
    Set<String> sinRepetidos = lenguajes.stream()
        .map(String::toUpperCase)
        .collect(Collectors.toSet());

    System.out.println(sinRepetidos);

  }
}
