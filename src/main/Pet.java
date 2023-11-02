import java.time.LocalDate;
import java.util.Date;

public class Pet {
    private String name;
    private LocalDate birthdate;

    private String commands;

    //public Pet() {
    //}

    public Pet(String name, LocalDate birthdate, String commands){
        this.name = name;
        this.birthdate = birthdate;
        this.commands = commands;
    }

    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                ", birthdate=" + birthdate +
                ", commands='" + commands + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public String getCommands() {
        return commands;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }

    public void addCommand(String newCommand) {
        this.commands += (", "+ newCommand);
    }
}
