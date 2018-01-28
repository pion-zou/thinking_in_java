package collection;

import collection.pets.Cat;
import collection.pets.Dog;
import collection.pets.Hamster;
import collection.pets.Pet;
import net.mindview.util.Print;

import java.util.HashMap;
import java.util.Map;

public class PetMap {
    public static void main(String[] args){
        Map<String , Pet> petMap = new HashMap<>();
        petMap.put("My Cat" , new Cat("Molly"));
        petMap.put("My Dog" , new Dog("Ginger"));
        petMap.put("My Hamster" , new Hamster("Bosco"));
        print(petMap);
        Pet dog = petMap.get("My Dog");
        print(dog);
        print(petMap.containsKey("My Dog"));
        print(petMap.containsValue(dog));
    }

    public static void print(Object o){
        System.out.println(o.toString());
    }
}
