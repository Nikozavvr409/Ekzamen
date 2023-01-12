package org.example.application.card;

public class CreditCard {
    private String name;
    private Double limit;
    private Integer gracePeriod;
    private Double percent;
    private Double sum;

    public CreditCard(String name, Double limit, Integer gracePeriod, Double percent){
        this.name = name;
        this.limit = limit;
        this.gracePeriod = gracePeriod;
        this.percent = percent;
        this.sum = limit;
    }

    public String getName() {
        return name;
    }

    public Double getLimit() {
        return limit;
    }

    public Integer getGracePeriod() {
        return gracePeriod;
    }

    public Double getPercent() {
        return percent;
    }

    public Double getSum() {
        return sum;
    }

    @Override
    public  String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(" ");
        builder.append(name);
        builder.append(" Лимит по карте: ");
        builder.append(limit);
        builder.append("р. Льготный период");
        builder.append(gracePeriod);
        builder.append(" дней. Остаток");
        builder.append(sum);
        builder.append("р. Процент по карте");
        builder.append(percent);
        return  builder.toString();
    }

    public void addMoney(Double money){
        sum += money;
    }

    public void withdrawMoney(Double money){
        if(sum>=money){
            sum -= money;
        } else {
            System.out.println("Недостаточно средств на карте");
        }
    }
}
