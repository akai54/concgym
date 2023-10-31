import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Gym {
    private final int totalGymMembers;
    private Map<MachineType, Integer> machinesDispo;

    public Gym(int totalGymMembers, Map<MachineType, Integer> machinesDispo) {
        this.machinesDispo = machinesDispo;
        this.totalGymMembers = totalGymMembers;
    }

    public void openAjd(){
        List<Thread> gymMembresProgramme;
        gymMembresProgramme = IntStream.rangeClosed(1, this.totalGymMembers)
                .mapToObj((id) -> {
                    Member member = new Member(id);
                    return new Thread(() -> {
                       try {
                           member.performRoutine();
                       }catch (Exception e) {
                           System.out.println(e);
                       }
                    });
                }).collect(Collectors.toList());

        gymMembresProgramme.forEach((t) -> t.start());


    }
}