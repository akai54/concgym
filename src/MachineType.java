import java.util.Random;

public class MachineType {
    LEGPRESSMACHINE("Leg Press"),
    HALTERE("Haltère"),
    SQUATMACHINE("Squat Machine"),
    LEGEXTENSIONMACHINE("Leg Extensions"),
    LEGCURLMACHINE("Leg Curls"),
    LATPULLDOWNMACHINE("Lat Pull Downs"),
    PECDECKMACHINE("Pec Deck Machine"),
    POULIEVISAVIS("Poulie vis à vis");

    public final String machineName;

    MachineType(String machineName) {
        this.machineName = machineName;
    }

    /* Retourne une machine de la salle au hassard */
    public static MachineType getRandomEquipment() {
        return MachineType.values()[new Random().nextInt(MachineType.values().length)];
    }
}
