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

        Thread supervisor = new Thread(createSupervisor(gymMembresProgramme));
        supervisor.start();

        gymMembresProgramme.forEach((t) -> t.start());

    }

    /* Ce thread contient les noms des threads encore actifs */
    private Thread createSupervisor(List<Thread> threads) {
        Thread supervisor = new Thread(() -> {
            while (true) {
                List<String> runningThreads;
                runningThreads = threads.stream().filter(Thread::isAlive).map(Thread::getName).collect(Collectors.toList());
                System.out.println(Thread.currentThread().getName() + " - " + runningThreads.size() + " members currently exercising: " + runningThreads + "\n");

                if (runningThreads.isEmpty()) break;

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                }
            }
            System.out.println(Thread.currentThread().getName() + "All members have finished exercising");
        });

        supervisor.setName("Gym Personnels");
        return supervisor;
    }
}