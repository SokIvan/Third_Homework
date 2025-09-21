package src.main.java.base;





public class TestPatterns {
    public static void main(String[] args) {
        System.out.println("=== ТЕСТИРОВАНИЕ ПАТТЕРНОВ ===");
        
        testAdapter();
        testBuilder();
        testChainOfResponsibility();
        testDecorator();
        testProxy();
        testStrategy();
    }
    
    private static void testAdapter() {
        System.out.println("\n--- Адаптер ---");
        Server server = new Server();
        Adapter adapter = new Adapter(server);
        
        Computer comp1 = new Computer(1, "Игровой ПК");
        Computer comp2 = new Computer(2, "Рабочий ноутбук");
        Computer comp3 = new Computer(3, "Сервер");
        
        adapter.sendMessage(comp1, comp2, "Привет! Как дела?");
        adapter.sendMessage(comp2, comp1, "Отлично! А у тебя?");
        adapter.sendMessage(comp1, comp3, "Нужна статистика");
        adapter.sendMessage(comp3, comp1, "Статистика готова");
        
        adapter.showMessages(comp1);
        adapter.showMessages(comp2);
        adapter.showMessages(comp3);
    }
    
    private static void testBuilder() {
        System.out.println("\n--- Строитель ---");
        Builder builder = new Builder();
        

        Phone budgetPhone = builder.buildPhone("Android 10", "Пластик", "Snapdragon 450", "3000mAh");
        Phone flagshipPhone = builder.buildPhone("iOS 15", "Стекло", "A15 Bionic", "4500mAh");
        
        System.out.println("Бюджетный телефон:");
        budgetPhone.show();
        
        System.out.println("Флагманский телефон:");
        flagshipPhone.show();
    }
    
    private static void testChainOfResponsibility() {
        System.out.println("\n--- Цепочка обязанностей ---");
        CandaIP canada = new CandaIP();
        GehmanyIP germany = new GehmanyIP();
        
        canada.changeLocation(germany);
        System.out.println("Пытаемся подключиться через цепочку:");
        canada.tryConnect();
    }
    
    private static void testDecorator() {
        System.out.println("\n--- Декоратор ---");
        Home simpleHome = new Home();
        System.out.println(simpleHome.show());
        

        HomeWithInterior decoratedHome = new HomeWithInterior(new Home());

        System.out.println(decoratedHome.show());
    }
    
    private static void testProxy() {
        System.out.println("\n--- Прокси ---");
        PhoneCall realCall = new PhoneCall();
        realCall.number = "+7**********"; // Российский номер
        
        Proxy callProxy = new Proxy(realCall);
        System.out.println("Российский номер:");
        callProxy.showNumber(realCall.number);
        

        PhoneCall foreignCall = new PhoneCall();
        foreignCall.number = "+44*********"; // Британский номер
        
        Proxy foreignProxy = new Proxy(foreignCall);
        System.out.println("Иностранный номер:");
        foreignProxy.showNumber(foreignCall.number);
    }
    
    private static void testStrategy() {
        System.out.println("\n--- Стратегия ---");
        CheesGamer player = new CheesGamer();

        player.changeStrategy(new PushStategy());
        player.showStrategy();
        
        player.changeStrategy(new DrawStategy());
        player.showStrategy();
        
        player.changeStrategy(new GiveUpStategy());
        player.showStrategy();
    }
}