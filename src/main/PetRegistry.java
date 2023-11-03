import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PetRegistry {
    private List<Pet> petList;

    public PetRegistry() {
        petList = new ArrayList<>();
    }

    public String PetListToString(){
        String output = "В реестре есть следующие домашние животные: \n";
        for (Pet item : petList) {
            output += "Имя: " + item.getName() + "\n";
            output += "Дата рождения: " + item.getBirthdate() + "\n";
            output += "Выполняет комманды: " + item.getCommands() + "\n";
            output += "Класс: " + item.getClass().getName() + "\n";
            output += "---------------------------------------\n";
        }
        return output;
    }

    public void addPet(Pet pet){
        petList.add(pet);
    }

    public Pet getByName(String name){
        for(Pet item : petList){
            if(item.getName().equals(name)){
                return item;
            }
        }
        return null;
    }

    public List<Pet> getPetList() {
        return petList;
    }

    public List<Pet> findByBirthdate(LocalDate date){
        List<Pet> foundList = new ArrayList<>();
        for(Pet item : petList){
            if(item.getBirthdate().equals(date)){
                foundList.add(item);
            }
        }
        return foundList;
    }

    public void testPetRegistryGenerator() {
        Pet pet0 = new Hamster("Hamster0", LocalDate.of(2020, 11, 12), "lay,go");
        Pet pet1 = new Hamster("Hamster1", LocalDate.of(2022, 12, 20), "lay,go");
        Pet pet2 = new Cat("Cat0", LocalDate.of(2010, 7, 5), "take, run");
        Pet pet3 = new Cat("Cat1", LocalDate.of(2015, 4, 18), "take, run");
        Pet pet4 = new Dog("Dog1", LocalDate.of(1987, 3, 4), "take, run");
        Pet pet5 = new Dog("Dog2", LocalDate.of(1987, 3, 4), "take, run");

        petList.add(pet0);
        petList.add(pet1);
        petList.add(pet2);
        petList.add(pet3);
        petList.add(pet4);
        petList.add(pet5);
    }

}
