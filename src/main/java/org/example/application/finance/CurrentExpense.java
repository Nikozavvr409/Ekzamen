package org.example.application.finance;

import java.util.ArrayList;

public class CurrentExpense {
    private ArrayList<String> currentExpenses;

    public CurrentExpense(){
        currentExpenses = new ArrayList<>();

    }

    public void addCurrentExpense(String cE, Double m){
        StringBuilder builder = new StringBuilder();
        builder.append(" Покупка на сумму: ");
        builder.append(m);
        builder.append("р. ");
        builder.append(cE);
        currentExpenses.add(builder.toString());
    }

    public void printCurrentExpense()throws NullPointerException{
        for (String s: currentExpenses){
            System.out.println(s);
        }
    }
}
