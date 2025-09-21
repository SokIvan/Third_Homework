package src.main.java.base;

/*
 * Паттерн Chain Of Responsibility
 * 
 * По сути позволяет вызывать альтернативные методы решения проблемы. 
 * Или по другому позволяет ставить объекты в очередь на определенных условиях.
 * 
 * 
 * Java Rush explain
 * 
 * Позволяет избежать жесткой зависимости отправителя запроса от его получателя,
 * при этом запрос может быть обработан несколькими объектами.
*/

interface Location{
    void changeLocation(Location loc);
    void tryConnect();
}
class CandaIP implements Location{
    Location loc = null;
    public void changeLocation(Location loc){
        this.loc = loc;
    }
    public void tryConnect() {
        System.out.println("Trying to connect Canada...");
            if (Math.random() > 0.5) { // 50% шанс успешного подключения
                System.out.println("Connected successfully!");
            } else if (loc != null) {
                loc.tryConnect();
            } else {
                System.out.println("All connections failed!");
        }
    }
}
class GehmanyIP implements Location{
    Location loc = null;
    public void changeLocation(Location loc){
        this.loc = loc;
    }
    public void tryConnect() {
        System.out.println("Trying to connect Gehmany...");
            if (Math.random() > 0.5) { // 50% шанс успешного подключения
                System.out.println("Connected successfully!");
            } else if (loc != null) {
                loc.tryConnect();
            } else {
                System.out.println("All connections failed!");
        }
    }
}



public class ChainOfResponsibility {// По сути VPN
    public static void main(String[] args){
        Location canda = new CandaIP();
        Location gehmany = new GehmanyIP();
        canda.changeLocation(gehmany);
        canda.tryConnect();
    }
}
