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



}
