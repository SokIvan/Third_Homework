package src.main.java.base;

/* Паттерн Strategy
 * 
 * Позволяет выбрать поведение объекта. В моем случае анализ игры в шахматы.
 * Продолжить, сдаться или играть дальше.
 * 
 * 
 * 
 * Java Rush explain
 * 
 * Определяет ряд алгоритмов позволяя взаимодействовать между ними. 
 * Алгоритм стратегии может быть изменен во время выполнения программы.
*/

interface Strategic{
    void doStrategy();
}

class DrawStategy implements Strategic{
    public void doStrategy(){
        System.out.println("Согласен на ничью!");
    }
    public int strategyPoint(){return 1;}
}
class GiveUpStategy implements Strategic{
    public void doStrategy(){
        System.out.println("Отличная партия. Я сдаюсь.");
    }
        public int strategyPoint(){return 2;}
}
class PushStategy implements Strategic{
    public void doStrategy(){
        System.out.println("Продолжаем!");
    }
    public int strategyPoint(){return 3;}
}

class CheesGamer {
    Strategic strategy;
    void showStrategy(){strategy.doStrategy();}
    void changeStrategy(Strategic newStrategy){strategy = newStrategy;}
}
