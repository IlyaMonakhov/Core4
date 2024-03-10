package task;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UserInfoFileManager {
    public void writeDownFile(User user){
        try(FileWriter fileWriter = new FileWriter("File.txt")){
            fileWriter.write("User Information:\n");
            fileWriter.write("Id: " + user.getId() + "\n");
            fileWriter.write("Name: " + user.getName() + "\n");
            fileWriter.write("Age: " + user.getAge() + "\n");
            fileWriter.write("Email: " + user.getEmail()+ "\n");
            fileWriter.write("Address: " + user.getAddress() + "\n");
            System.out.println("Информация о пользователе была записана на File.txt");
        } catch (IOException e) {
            System.out.println("При записи в файл произошла ошибка.");
        }


    }
}