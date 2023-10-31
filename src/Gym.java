import java.util.Map;

public class Gym {
    private final int totalGymMembers;
    private Map<MachineType, Integer> machinesDispo;

    public Gym(int totalGymMembers, Map<MachineType, Integer> machinesDispo) {
        this.machinesDispo = machinesDispo;
        this.totalGymMembers = totalGymMembers;
    }
}