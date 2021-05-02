package bsuir.group922402.var6.gluhova;

public class Member extends Printable {

    // Ф.И.О. игрока, игровой номер, возраст, рост, вес(сощдаем переменные)
    private String memberName;
    private int number;
    private int age;
    private int height;
    private int weight;

    public Member(String memberName, String number, String age, String height, String weight) {
        super("участник");
        this.memberName = memberName;  //присваиваем (конструктор создаем)
        this.number = Integer.valueOf(number);
        this.age = Integer.valueOf(age);
        this.height = Integer.valueOf(height);
        this.weight = Integer.valueOf(weight);
    }

    // геттеры
    public String getMemberName() {
        return memberName;
    }

    public int getNumber() {
        return number;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    // для вывода информации об участнике
    @Override
    public String print() {
        return getNamePrefix() + " " + memberName + " игровой номер " + number + " возраст " + age + " рост " + height + " вес " + weight;
    }
}
