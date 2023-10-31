import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Member {
    private final int id;

    public Member(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    /* Créer le programme d'entrainement à effectuer à chaque fois que le memebre va à la salle */
    public List<Exercise> generateRoutine() {
        return IntStream.range(0, 6).mapToObj(_i -> new Exercise()).collect(Collectors.toList());
    }

    /* Effectuer le programme définis par generateRoutine() */
    public void performRoutine() throws InterruptedException {
        List<Exercise> routine = generateRoutine();

        routine.forEach(exercise -> {
            System.out.println("Membre " + this.getId() + " effectue l'exercise: " + exercise);
            try {
                Thread.sleep(exercise.getDuree());
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        });
    }
}
