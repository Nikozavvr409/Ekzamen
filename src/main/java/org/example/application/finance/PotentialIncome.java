package org.example.application.finance;

import java.util.ArrayList;

public class PotentialIncome {
    private ArrayList<String> potentialIncome;


    public PotentialIncome() {

        this.potentialIncome = new ArrayList<>();
    }

    public void addPotentialIncome(String s, Double m){
        StringBuilder builder = new StringBuilder();
        builder.append(" Назначение платежа: ");
        builder.append(s);
        builder.append(" Сумма: ");
        builder.append(m);
        potentialIncome.add(builder.toString());
    }

    public void printPotentialIncome(){
        for (String s: potentialIncome){
            System.out.println(s);
        }
    }
}
