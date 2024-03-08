package task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
        for (User user : usersList) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
    public void deleteUser(int id){
        User userToRemove = null;
        for (User user : usersList){
            if (user.getId() == id){
                userToRemove = user;
                break;
            }
        }
        if(userToRemove != null){
            usersList.remove(userToRemove);
        }
    }

    public List <User> sortUserByAddress(){
        List<User> sortedUsersListAddress = new ArrayList<>();
        Collections.sort(sortedUsersListAddress, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getAddress().compareTo(o2.getAddress());
            }
        });
        return sortedUsersListAddress;
    }
    public List<User> sortUsersByName(){
        List<User> sortedUsersListName = new ArrayList<>();
        Collections.sort(sortedUsersListName, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return sortedUsersListName;
    }




}
