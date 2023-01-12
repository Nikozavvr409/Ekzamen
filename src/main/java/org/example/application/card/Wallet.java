package org.example.application.card;

public class Wallet {
    private String name;
    private Double sum;

    public Wallet(String name, Double sum) {
        this.name = name;
        this.sum = sum;
    }

    public String getName() {
        return name;
    }

    public Double getSum() {
        return sum;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(" ");
        builder.append(name);
        builder.append(" Баланс карты: ");
        builder.append(sum);
        builder.append("р.");
        return builder.toString();
    }

    public void addMoney(Double money){
        sum += money;
    }

    public void withdrawMoney(Double money){
        if(money <= sum){
            sum -= money;
        } else {
            System.out.println("Недостаточно средств на карте");
        }
    }
}
