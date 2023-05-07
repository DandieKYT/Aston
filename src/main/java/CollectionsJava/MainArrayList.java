package CollectionsJava;

import java.util.*;
import java.util.ArrayList;

public class MainArrayList {
   public static void main(String[] args){

      List<String> sportsList = new ArrayList<>();
      sportsList.add("Футбол");
      sportsList.add("Теннис");
      sportsList.add("Плаванье");
       while (sportsList.contains("Теннис")){
           sportsList.add(1,"Волейбол");
      if (sportsList.contains("Волейбол"))
      {
          sportsList.remove(1);
          return;
         }
       }

   }
}


