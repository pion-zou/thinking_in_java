package collection.pets;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ty on 2016/11/16.
 */
public class ForNameCreator extends PetCreator {
    private static List<Class<? extends Pet>> types = new ArrayList<Class<? extends Pet>>();

    private static String[] typeNames = {
        "typeinfo.collection.pets.Mutt",
            "typeinfo.collection.pets.Pug",
            "typeinfo.collection.pets.EgyptianMau",
            "typeinfo.collection.pets.Manix",
            "typeinfo.collection.pets.Cymric",
            "typeinfo.collection.pets.Rat",
            "typeinfo.collection.pets.Mouse",
            "typeinfo.collection.pets.Hamster"
    };

    @SuppressWarnings("unchecked")

    private static void loader() {
        try {
            for (String name : typeNames)
                types.add((Class<? extends Pet>)Class.forName(name));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static { loader(); }
    public List<Class<? extends Pet>> types() { return types; }
}
