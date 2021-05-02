package bsuir.group922402.var6.gluhova;

import java.util.ArrayList;
import java.util.List;

public class Command extends Printable {

    private String commandName;
    private String country;
    // участники команды
    private List<Member> members;

    // конструктор
    public Command(String commandName, String country) {
        super("команда");
        this.commandName = commandName;
        this.country = country;
        this.members = new ArrayList<>();
    }

    // метод добавления участника команды в список
    public void add(Member member) {
        members.add(member);
    }

    // посчитать средний возраст
    public int getAverageAge() {
        if (members.size()==0) {
            return 0;
        }
        int age = 0;
        for (Member m : members) {
            age += m.getAge();
        }
        return age / members.size();
    }

    // посчитать средний рост
    public int getAverageHeight() {
        if (members.size()==0) {
            return 0;
        }
        int height = 0;
        for (Member m : members) {
            height += m.getHeight();
        }
        return height / members.size();
    }

    // посчитать средний вес
    public int getAverageWeight() {
        if (members.size()==0) {
            return 0;
        }
        int weight = 0;
        for (Member m : members) {
            weight += m.getWeight();
        }
        return weight / members.size();
    }

    @Override
    public String print() {
        if (members.size()==0) {
            return getNamePrefix() + " " + commandName + " (" + country + ")";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(getNamePrefix()).append(" ").append(commandName).append(" (").append(country).append("):\n");
            for (Member m : members) {
                sb.append(" - ").append(m).append("\n");
            }
            return sb.toString();
        }
    }
}
