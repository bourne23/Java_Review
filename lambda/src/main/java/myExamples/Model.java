package myExamples;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Model {


   private int size;
   private int weight;
   private String name;

   public Model (String  name){
      this.name=name;
   }
   public Model (String  name, Integer weight){
      this.name=name;
      this.weight = weight;
   }
}
