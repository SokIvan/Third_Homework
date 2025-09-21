package src.main.java.base;

/* 
 * Паттерн Decorator
 * 
 * Позволяет добавлять к существующему классу функционал.
 * В моем случае добавим к дому интерьер, что поменяет описание и стоимость.
 * 
 * Java Rush explain
 * 
 * Добавляет новые функциональные возможности существующего объекта без привязки его структуры.
*/


class Home{
    float cost = 1;
    String show(){
        return "Простой дом, цена: " + cost;
    }
}

abstract class Decorator extends  Home{
    protected Home decoratedHome;
    String show(){
        return decoratedHome.show();
    }
}
class HomeWithInterior extends Decorator {
    public HomeWithInterior(Home home) {
        this.decoratedHome = home;
    }
    
    String show() {
        this.cost = (float) (this.cost*1.5);//Ничего не понял
        return decoratedHome.show() + " + интерьер, цена: " + (cost);
    }
}
