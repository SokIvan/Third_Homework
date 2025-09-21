package src.main.java.base;

/* Паттерн Proxy
 * 
 * По сути оборачивает объект и меняет поведение.
 * 
 * 
 * 
 * Java Rush explain
 * 
 * Представляет объекты, которые могут контролировать другие объекты перехватывая их вызовы. Можно перехватить вызов оригинального объекта.
 * 
*/


interface Call{
    void showNumber(String number);
    String getNumber();
}

class PhoneCall implements Call{
    String number;
    public void showNumber(String num){
        System.out.println(number);
    }
    public String getNumber(){return number;}
}

public class Proxy implements Call{
    PhoneCall phoneCall;

    public Proxy(PhoneCall call){this.phoneCall = call;}

    public void showNumber(String number){
        if (!number.startsWith("+7")&&!number.startsWith("8")){
            System.out.println("This is not Russia region, reccomend not to answer!"); //Или написать что подозрение на спам, подозрительный звонок и т.д.
        }
        phoneCall.showNumber(getNumber());
    }
    public String getNumber(){return phoneCall.getNumber();}
}
