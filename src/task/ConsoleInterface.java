package task;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ConsoleInterface {
    private UserManager userManager = new UserManager();
    private UserInfoFileManager userInfoFileManager = new UserInfoFileManager();
    private Scanner scanner;
    public void runConsoleInterface() {
        while (true) {
            scanner = new Scanner(System.in);
            System.out.println("Введите команду:\n create - добавить\n sortAddress - сортировать пользователей по адресам\n sortName - сортировать пользователей по именам\n update - обновить\n get - получить пользователя\n list - вывести на экран\n delete - удалить пользователя\n exit - выход");
            String command = scanner.nextLine();
            switch (command) {
                case "create":
                create();
                    break;
                case "list":
                    list();
                    break;
                case "delete":
                    delete();
                    break;
                case "get":
                    get();
                    break;
                case "sortName":
                    sortName();
                    break;
                case "sortAddress":
                    sortAddress();
                case "update":
                    update();
                    break;
                case "exit":
                    scanner.close();
                    return;

                default:
                        System.out.println("Вы вводите неверную команду!");

            }
        }
    }
    private void create() {
        System.out.println("Введите ID пользователя");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите имя пользователя");
        String name = scanner.nextLine();
        System.out.println("Введите возраст пользователя");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите email пользователя");
        String email = scanner.nextLine();
        System.out.println("Введите адрес пользователя");
        String address = scanner.nextLine();

        userManager.createUser(id, name, age, email, address);
        User newUser = new User(id, name, age, email, address);
        userInfoFileManager.writeDownFile(newUser);
        System.out.println("Пользователь создан и информация записана в файл.");
    }
    private void list() {
        System.out.println("Список пользователей: ");
        userManager.getListUser().stream()
                .sorted(Comparator.comparing(User::getId))
                .forEach(user -> System.out.println(user.getId() + " " + user.getName() + " " + user.getAge() + " " + user.getEmail() + " " + user.getAddress()));
    }
    private void delete() {
        System.out.println("Введите ID пользователя для удаления");
        int id = Integer.parseInt(scanner.nextLine());
        userManager.deleteUser(id);
        System.out.println("Пользователь с ID " + id + " удален.");
    }
    private void get() {
        System.out.println("Введите ID пользователя");
        int id = Integer.parseInt(scanner.nextLine());
        User user = userManager.getUser(id);
        if (user != null) {
            System.out.println("Пользователь найден: " + user.getName() + " " + user.getAge() + " " + user.getEmail() + " " + user.getAddress());
        } else {
            System.out.println("Пользователь с ID " + id + " не найден");
        }
    }
    private void sortName(){
        Collections.sort(userManager.getListUser(), Comparator.comparing(User::getName));
        System.out.println("Пользователи отсортированы по имени");
        userManager.getListUser().forEach(usr -> System.out.println(usr.getName() + " " + usr.getAge() + " " + usr.getEmail() + " " + usr.getAddress()));

    }
    private void sortAddress(){
        Collections.sort(userManager.getListUser(), Comparator.comparing(User::getAddress));
        System.out.println("Пользователи отсортированы по адресам");
        userManager.getListUser().forEach(usr -> System.out.println(usr.getName() + " " + usr.getAge() + " " + usr.getEmail() + " " + usr.getAddress()));

    }
    private void update(){
        System.out.println("Введите ID пользователя для обновления");
        int id = Integer.parseInt(scanner.nextLine());
        User userToUpdate = userManager.getListUser().get(id);
        if (userToUpdate != null) {
            System.out.println("Введите новое имя пользователя");
            String newName = scanner.nextLine();
            userToUpdate.setName(newName);
            System.out.println("Пользователь успешно обновлен");
        } else {
            System.out.println("Пользователь с такими ID не найден");

        }
    }
}