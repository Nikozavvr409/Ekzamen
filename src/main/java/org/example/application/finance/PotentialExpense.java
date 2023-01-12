package org.example.application.finance;

import java.util.ArrayList;

public class PotentialExpense {
    private ArrayList<String> potentialExpense;

    public PotentialExpense() {

        this.potentialExpense = new ArrayList<>();
    }

    public void addPotentialExpense(String s, Double m){
        StringBuilder builder = new StringBuilder();
        builder.append(" Назначение платежа: ");
        builder.append(s);
        builder.append(" Сумма: ");
        builder.append(m);
        potentialExpense.add(builder.toString());
}
public void printPotentialExpense(){
        for (String s: potentialExpense){
            System.out.println(s);
        }
}
}
