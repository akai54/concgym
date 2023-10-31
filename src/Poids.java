import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public enum Poids {
    SMALL_5KG,
    MEDIUM_10KG,
    LARGE_25KG;

    static final Map<Poids, Integer> numOfPoids = new HashMap<>();

    static {
        numOfPoids.put(SMALL_5KG, 110);
        numOfPoids.put(MEDIUM_10KG, 90);
        numOfPoids.put(LARGE_25KG, 75);
    }

    /* Retourne un poids au hassard */
    public static Poids getRandomPoids() {
        return Poids.values()[new Random().nextInt(Poids.values().length)];
    }
}
