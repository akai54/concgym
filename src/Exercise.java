import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Exercise {
    private final MachineType machine;
    private final Map<Poids, Integer> poids;
    private final int duree;

    public Exercise () {
        this.machine = MachineType.getRandomEquipment();
        Map<Poids, Integer> poidsSet = new HashMap<>();
        poidsSet.put(Poids.SMALL_5KG, 0);
        poidsSet.put(Poids.MEDIUM_10KG, 0);
        poidsSet.put(Poids.LARGE_25KG, 0);

        for (int i = 0; i < 10; i++) {
            Poids randPlate = Poids.getRandomPoids();
            int rand = new Random().nextInt(4);
            if (rand < 3) {
                poidsSet.replace(randPlate, poidsSet.get(randPlate) + 1);
            }
        }
        this.poids = poidsSet;
        this.duree = 1000 + new Random().nextInt(2000);
    }

    public int getDuree() {
        return this.duree;
    }

    @Override
    public String toString() {
        int poidsTotal = (this.poids.get(Poids.SMALL_5KG) * 5) + (this.poids.get(Poids.MEDIUM_10KG) * 10) + (this.poids.get(Poids.LARGE_25KG) * 25);
        String weightsMessage = poidsTotal + "kg de poids total consistant de " + this.poids.get(Poids.SMALL_5KG) + " x 5 kg poids, " + this.poids.get(Poids.MEDIUM_10KG) + " x 10 kg poids, " + this.poids.get(Poids.LARGE_25KG) + " x 25 kg poids.";
        return this.machine.machineName + " avec " + weightsMessage + "\n";
    }
}
