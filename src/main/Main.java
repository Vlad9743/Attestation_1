import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {

        PetRegistry petRegistry = new PetRegistry();
        petRegistry.testPetRegistryGenerator();

        Pet pet1111 = new Cat("sbssb", LocalDate.of(1212,1,3), "ddbd");
        petRegistry.addPet(pet1111);

        Scanner scanner = new Scanner(System.in);

        //Menu
        boolean mainMenu = true;
        while (mainMenu) {
            System.out.println("Реестр домашних животных:" + "\n" +
                    "1. Добавить домашнее животное" + "\n" +
                    "2. Показать комманды животного" + "\n" +
                    "3. Добавтить комманду животному" + "\n" +
                    "4. Найти животных по дате рождения" + "\n" +
                    "5. Выыести весь реестр" + "\n" +
                    "0. Завершить работу" + "\n" + "\n" +
                    "Введите выбор: ");
            String userInput = scanner.nextLine();
            if (userInput.matches("[0-5]")){
                if (userInput.equals("0")){
                    System.out.println("Работа завершена." + "\n");
                    mainMenu = false;
                }
                
                else if (userInput.equals("1")){

                    System.out.println("Введите имя животного: ");
                    String tempName = scanner.nextLine();
                    System.out.println("Введите список изветных комманд животного:");
                    String tempCommands = scanner.nextLine();

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
                    System.out.print("Введите дату рождения (dd MM yyyy):");
                    LocalDate tempDate = LocalDate.parse(scanner.nextLine(), formatter);

                    System.out.println("Выберите класс животного." + "\n" +
                    "1 - кот" + "\n" +
                    "2 - собака" + "\n" +
                    "3 - хомяк" + "\n");
                    userInput = scanner.nextLine();
                    if (userInput.matches("[1-3]")){
                        Pet tempPet = new Pet();
                        if (userInput.equals("1")){
                            tempPet = new Cat(tempName, tempDate, tempCommands);
                        } else if (userInput.equals("2")) {
                            tempPet = new Dog(tempName, tempDate, tempCommands);
                        } else if (userInput.equals("3")) {
                            tempPet = new Hamster(tempName, tempDate, tempCommands);
                        }
                        petRegistry.addPet(tempPet);
                        System.out.println("Запись добавлена.");
                    }
                    else {
                        System.out.println("\n" + "\n" + "\n" + "Неверный класс животного." + "\n" + "\n" + "\n");
                    }
                }

                else if (userInput.equals("2")){
                    System.out.println("Введите имя животного:");
                    String tempName = scanner.nextLine();
                    Pet tempPet = petRegistry.getByName(tempName);
                    if (tempPet != null){
                        System.out.println(tempPet.getCommands());
                    }
                    else {
                        System.out.println("Такого животного в реестре нет");
                    }
                }

                else if (userInput.equals("3")){
                    System.out.println("Введите имя животного:");
                    String tempName = scanner.nextLine();
                    System.out.println("Введите команду для добавления: ");
                    String newCommand = scanner.nextLine();
                    try {
                        petRegistry.getByName(tempName).addCommand(newCommand);
                    }catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Животное не найдено");
                        }
                    }

                else if (userInput.equals("4")){
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
                    System.out.print("Введите дату рождения (dd MM yyyy):");


                    try {
                        LocalDate tempDate = LocalDate.parse(scanner.nextLine(), formatter);
                        List<Pet> tempList = petRegistry.findByBirthdate(tempDate);
                        System.out.println("Записей найдено- " + tempList.size() + ":" + "\n");
                        for (Pet item : tempList) {
                            System.out.println(item.getName());
                        }
                    }catch (DateTimeParseException e1){
                        System.out.println(e1.getMessage());
                        System.out.println("Неверный формат даты");
                    }

                }

                else if (userInput.equals("5")) {
                    System.out.println(petRegistry.PetListToString());
                }
                else {
                    System.out.println("\n" + "\n" + "\n" + "Введена неверная комманда." + "\n" + "\n" + "\n");
                }
            }
            else {
                System.out.println("\n" + "\n" + "\n" + "Введена неверная комманда." + "\n" + "\n" + "\n");
            }
        }
    }
}
