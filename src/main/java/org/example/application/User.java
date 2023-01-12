package org.example.application;

import com.sun.source.tree.CaseTree;
import org.example.application.card.CreditCard;
import org.example.application.card.Wallet;
import org.example.application.finance.CurrentExpense;
import org.example.application.finance.PotentialExpense;
import org.example.application.finance.PotentialIncome;

import java.util.HashMap;
import java.util.Map;

public class User {
    private String userName;
    private HashMap<String, CreditCard> creditCards;
    private HashMap<String, Wallet> wallets;
    private CurrentExpense currentExpense;
    private PotentialExpense potentialExpense;
    private PotentialIncome potentialIncome;


    public User(String userName) {
        this.userName = userName;
        this.creditCards = new HashMap<>();
        this.wallets = new HashMap<>();
        this.currentExpense = new CurrentExpense();
        this.potentialExpense = new PotentialExpense();
        this.potentialIncome = new PotentialIncome();
    }

    /**
     * Блок кошелька
     */

    public void addWallet(String nameWallet, String bank){
        Wallet wal = new Wallet(bank, 0.0);
        wallets.put(nameWallet, wal);
    }

    public void addMoneyWallet(String nameWallet, Double sum)throws NullPointerException{
        Wallet wal = wallets.get(nameWallet);
        wal.addMoney(sum);
    }

    public void withdrawWalletMoney(String nameWallet, Double money)throws NullPointerException{
        Wallet wal = wallets.get(nameWallet);
        wal.withdrawMoney(money);
        currentExpense.addCurrentExpense(wal.toString(), money);
    }

    public void checkWallet(String nameWallet)throws NullPointerException{
        System.out.println(" Кошелёк: " + nameWallet + wallets.get(nameWallet).toString());
    }

    public void printAllWallets()throws NullPointerException{
        for (Map.Entry wal : wallets.entrySet()){
            Wallet w = (Wallet) wal.getValue();
            System.out.println(" Кошелёк " + wal.getKey() + " " + w.toString());
        }
    }

    public Double getSumAllWallets()throws NullPointerException{
        Double sum = 0.0;
        for (Map.Entry s : wallets.entrySet()){
            Wallet w = (Wallet) s.getValue();
            sum += w.getSum();
        }
        System.out.println(" Суммарный баланс " + sum);
        return  sum;
    }

    public void  deleteWallet(String nameWallet)throws NullPointerException{
        wallets.remove(nameWallet);
    }

    /**
     * Блок кредитки
     */

    public void addCreditCard(String nameCreditCard, String bank,
                              Double limit, Integer gracePeriod, Double percent){
        CreditCard cc = new CreditCard(bank, limit, gracePeriod, percent);
        creditCards.put(nameCreditCard, cc);
    }

    public void addMoneyCreditCard(String nameCreditCard, Double sum)throws NullPointerException{
        CreditCard cc = creditCards.get(nameCreditCard);
        cc.addMoney(sum);
    }

    public void withdrawMoneyCreditCard(String nameCreditCard, Double money){
        CreditCard cc = creditCards.get(nameCreditCard);
        cc.addMoney(money);
        currentExpense.addCurrentExpense(cc.toString(),money);
    }

    public void checkCreditCard(String name)throws NullPointerException{
        System.out.println(" Кредитка " + name + creditCards.get(name).toString());
    }

    public Double getSumAllCreditCards(){
        Double sum = 0.0;
        for (Map.Entry s : creditCards.entrySet()){
            CreditCard cc = (CreditCard) s.getValue();
            sum += cc.getSum();
        }
        System.out.println(" Суммарный остаток " + sum);
        return  sum;
    }

    public void deleteCreditCard(String nameCreditCard)throws NullPointerException{
        creditCards.remove(nameCreditCard);
    }

    public void showCreditCards()throws NullPointerException{
        for (Map.Entry s : creditCards.entrySet()){
            CreditCard cc = (CreditCard) s.getValue();
            System.out.println(" Кредитка " + s.getKey() + " " + cc.toString());
        }
    }

    /**
     * Блок общих методов
     */
    public Double getAllMoney()throws NullPointerException{
        Double sum = getSumAllCreditCards();
        sum += getSumAllCreditCards();
        System.out.println(" Доступные средства " + sum + "р.");
        return sum;
    }

    /**
     * Блок потенциальных затрат
     */
    public void addPotentialExpense(String namePotentialExpense, Double sum){
        potentialExpense.addPotentialExpense(namePotentialExpense, sum);
    }
    public void printAllPotentialExpense()throws NullPointerException {
        potentialExpense.printPotentialExpense();
    }

    /**
     * Блок текущих затрат
     */
    public void getAllCurrentExpense()throws NullPointerException{
        try {
            currentExpense.printCurrentExpense();
        }catch (NullPointerException e){
            System.out.println(" Список пуст ");
        }
    }

    /**
     * Блок планируемых затрат
     */
    public void addPotentialIncome(String namePotentialIncome, Double sum){
        potentialIncome.addPotentialIncome(namePotentialIncome, sum);
    }
    public void printAllPotentialIncome()throws NullPointerException{
        potentialIncome.printPotentialIncome();
    }
}
