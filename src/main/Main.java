import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Pet pet0 = new Pet("Pet0", LocalDate.of(1985,11,12), "lay,go");
        Pet pet1 = new Сat("Cat1", LocalDate.of(1986,7,5), "take, run");
        Pet pet2 = new Dog("Dog1", LocalDate.of(1987,3,4), "take, run");
        Pet pet3 = new Dog("Dog2", LocalDate.of(1987,3,4), "take, run");

        PetRegistry petRegistry = new PetRegistry();

        petRegistry.addPet(pet0);
        petRegistry.addPet(pet1);
        petRegistry.addPet(pet2);
        petRegistry.addPet(pet3);

        System.out.println(petRegistry.PetListToString());

        System.out.println("#####################################");
        System.out.println(petRegistry.getByName("Cat1").toString());
        System.out.println("######################################");
        System.out.println(petRegistry.getByName("Cat1").getClass().getName());
        System.out.println("######################################");
        System.out.println(petRegistry.getByName("Cat1").getCommands());

        petRegistry.getByName("Cat1").setCommands("1,23,4");
        System.out.println("######################################");
        System.out.println(petRegistry.getByName("Cat1").getCommands());

        petRegistry.getByName("Cat1").addCommand("rrrrrrrrrrrrrrrrrrrrr");
        System.out.println("######################################");
        System.out.println(petRegistry.getByName("Cat1").getCommands());

        System.out.println(petRegistry.findByBirthdate(LocalDate.of(1987,3,4)).toString());
    }
}
