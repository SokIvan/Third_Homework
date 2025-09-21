package src.main.java.base;

/* Паттерн Builder(класс Builder или же AppBuilder)
 * 
 * Позволяет создавать различные конфигурации телефона с помощью одного класса.
 * По сути объединение сложных процессов в одном классе для компактности и сокращения
 * строк кода.
 * 
 * Мой Builder выдает телефон, который состоит из модулей(модули так то тоже могут состоять из каких то других
 * классов или интерфейсов). Позволяет менять внутренние модули и сразу создавать собранный телефон.
 * 
 * 
 * 
 * JavaRush explain
 * 
 * Используется для создания сложного объекта с использованием простых объектов.
 * Постепенно он создает больший объект от малого и простого объекта. 
 * Позволяет изменять внутреннее представление конечного продукта.
 * 
*/


interface Module{
    void set(String name);
    void show();
}

class Software implements Module {
    String soft;
    public void set(String name){
        this.soft = name;
    }
    public void show(){
        System.out.println("Software: "+soft);
    }
}
class Case implements Module {
    String _case;
    public void set(String name){
        this._case = name;
    }
    public void show(){
        System.out.println("Case: "+_case);
    }
}
class CPU implements Module {
    String cpu;
    public void set(String name){
        this.cpu = name;
    }
    public void show(){
        System.out.println("CPU: "+cpu);
    }
}
class Battery implements Module {
    String battery;
    public void set(String name){
        this.battery = name;
    }
    public void show(){
        System.out.println("Battery: "+battery);
    }
}

class Phone {
    Module[] moduls = new Module[4];

        public void addSoftware(String soft){
        moduls[0] = new Software();
        moduls[0].set(soft);
    }
        public void addCase(String _case){
        moduls[1] = new Case();
        moduls[1].set(_case);
    }
        public void addCPU(String cpu){
        moduls[2] = new CPU();
        moduls[2].set(cpu);
    }
        public void addBattery(String battery){
        moduls[3] = new Battery();
        moduls[3].set(battery);
    }

public void show() {
    for (Module module : moduls) {
        if (module != null) {
            module.show();
        }
    }
}
}

public class Builder {//На самом деле лучше было назвать AppBuilder
    public Phone buildPhone(String soft, String _case, String cpu, String battery){
        Phone phone = new Phone();
        phone.addSoftware(soft);
        phone.addCase(_case);
        phone.addCPU(cpu);
        phone.addBattery(battery);
        return phone;
    }
}
