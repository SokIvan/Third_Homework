package src.main.java.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/* Паттерн Adapter
 * 
 * Позволяет связать различные объекты без изменения их реализации.
 * 
 * В моем случае это адаптер, который связывает компьютеры с сервером.
 * В данной реализации он берет от компьютеров только id и имя.
 * При увеличении сложности реализации можно добавить состояние, запросы и так далее, что
 * более приблизит к реальной версии компьютерного адаптера.
 * 
 * 
 * JavaRush explain
 * 
 * Используя паттерн, мы можем объединить два несовместимых объекта.
 * Конвертер между двумя несовместимыми объектами.
 * 
*/




class Server {
    private Map<Integer, List<String>> messages = new HashMap<>();
    
    public void sendMessage(int fromId, int toId, String message) {
        System.out.println("Сервер: Компьютер " + fromId + " → Компьютер " + toId + ": " + message);

        if (!messages.containsKey(toId)) {
            messages.put(toId, new ArrayList<>());
        }
        messages.get(toId).add("От " + fromId + ": " + message);
    }
    
    public List<String> getMessages(int computerId) {
        return messages.getOrDefault(computerId, new ArrayList<>());
    }
}
class Computer {
    private int id;
    private String name;

    public Computer(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() { return id; }
    public String getName() { return name; }
}
public class Adapter {
    private Server server;
    
    public Adapter(Server server) {
        this.server = server;
    }
    public void sendMessage(Computer from, Computer to, String message) {
        server.sendMessage(from.getId(), to.getId(), message);
    }
    public void showMessages(Computer computer) {
        List<String> messages = server.getMessages(computer.getId());
        System.out.println("Сообщения для " + computer.getName() + ":");
        for (String msg : messages) {
            System.out.println("  " + msg);
        }
    }
}
