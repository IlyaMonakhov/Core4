package task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UserManager {

    private List<User> usersList = new ArrayList<>();

    public void createUser(int id, String name, int age, String email, String address){
        User user = new User(id, name, age, email, address);
        usersList.add(user);
    }
    public List<User> getListUser(){
        return usersList;
    }
    public void updateUser(int id, String name, int age, String email, String address){
        usersList.stream().filter(user -> user.getId() == id).findFirst()
                .ifPresent(user -> {
                    user.setName(name);
                    user.setAge(age);
                    user.setEmail(email);
                    user.setAddress(address);
                });
    }
    public User getUser(int id) {
        return usersList.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }
    public void deleteUser(int id){
        usersList.removeIf(user -> getUser(id) == user);

    }

    public List <User> sortUserByAddress(){
        List<User> sortedUsersListAddress = new ArrayList<>();
        sortedUsersListAddress.sort((o1, o2) -> o1.getAddress().compareTo(o2.getAddress()));
        return sortedUsersListAddress;
    }
    public List<User> sortUsersByName(){
        List<User> sortedUsersListName = new ArrayList<>();
        sortedUsersListName.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        return sortedUsersListName;
    }




}
