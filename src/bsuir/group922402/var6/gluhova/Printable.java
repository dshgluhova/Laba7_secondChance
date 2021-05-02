package bsuir.group922402.var6.gluhova;


// абстрактный класс - объекты которые умеют распечатывать свое состояние
public abstract class Printable {

    // какая-то приватная переменная - префикс имени объекта
    private String namePrefix;

    // для доступа к приватной namePrefix из подклассов
    protected String getNamePrefix() {
        return namePrefix;
    }

    // конструктор
    public Printable(String namePrefix) {
        this.namePrefix = namePrefix;
    }

    // static (аналог friend) демонстрирует доступ к приватной переменной абстрактного класса
    public static void run(Printable p) {
        System.out.println(p.namePrefix);
    }

    // абстрактный метод print, который будет переопределен в подклассах
    public abstract String print();

    @Override
    public String toString() {
        return print();
    }
}
