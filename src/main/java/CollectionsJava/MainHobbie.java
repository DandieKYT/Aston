package CollectionsJava;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static io.opentelemetry.semconv.resource.attributes.ResourceAttributes.TelemetrySdkLanguageValues.PHP;


public class MainHobbie {
    public static void main(String[] args) {
        String[] hobbie = new String[3];
        hobbie[0] = "Готовка";
        hobbie[1] = "Java";
        hobbie[2] = "Музыка";

        Hobbie cooking = new Hobbie("Готовка", 100, hobbie);
        Hobbie programming = new Hobbie("Програмированние", 150, hobbie);
        Hobbie music = new Hobbie("Музыка", 450, hobbie);

        Set<String> hobbieSet = new HashSet<>();
        hobbieSet.add("Готовка");
        hobbieSet.add("Музыка");
        hobbieSet.add("Java");


        while (hobbieSet.contains("Готовка")){
            hobbieSet.add("Ничего");
            if (hobbieSet.contains("Ничего"))
            {
                hobbieSet.remove("Ничего");
                System.out.println("Успех");
                return;
            }
        }
    }
}
