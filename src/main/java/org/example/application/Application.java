package org.example.application;

import java.util.Scanner;

public class Application {
    public void start(){
        Scanner scanner = new Scanner(System.in);
        int operation;
        System.out.println("Начало работы! \nСоздать пользователя - 1 \nВыход - любая кнопка");
        if (scanner.hasNextInt()){
            operation = scanner.nextInt();
            if (operation == 1){
                System.out.println("Введите имя пользователя");
                User user = new User(scanner.next());
                objectSelection(user);
            }
        }
        System.out.println("Пока!");
    }

    private  void objectSelection(User user){
        Scanner scanner;
        do {
            System.out.println("Выбор объекта!");
            System.out.println("1 - Операции с кошельком " +
                    "\n2 - Операции с кредиткой " +
                    "\n3 - Посмотреть текущие затраты " +
                    "\n4 - Операции с потенциальными затратами " +
                    "\n5 - Операции с потенциальными доходами");
            scanner = new Scanner(System.in);
            if (scanner.hasNextInt()){
                try {
                    switch (scanner.nextInt()){
                        case (1):
                            operationWallet(user);
                            break;
                        case (2):
                            operationCreditCard(user);
                            break;
                        case (3):
                            operationCurrentExpense(user);
                            break;
                        case(4):
                            operationPotentialExpense(user);
                            break;
                        case(5):
                            operationPotentialIncome(user);
                            break;
                    }
                } catch (RuntimeException e){
                    System.out.println("Некорректный ввод");
                }
            }
            System.out.println("1 - Продолжить работу \nВыход - любая кнопка, кроме 1");
        } while (scanner.hasNextInt() && (scanner.nextInt() == 1));
    }

    private void operationWallet(User user)throws RuntimeException{
        String nB;
        String nW;
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - добавить кошелек" +
                "\n2 - пополнить кошелек \n3 - потратить деньги с кошелька " +
                "\n4 - проверить кошелек" +
                "\n5 - проверить все кошельки \n6 - запрос баланса по всем кошелькам" +
                "\n7 - удаление кошелька");
        switch (scanner.nextInt()){
            case (1):
                System.out.println(" Введите название банка ");
                nB = scanner.next();
                System.out.println(" Введите имя карты ");
                nW = scanner.next();
                user.addWallet(nW, nB);
                break;
            case(2):
                System.out.println(" Введите имя карты ");
                nW = scanner.next();
                System.out.println(" Введите сумму ");
                if (scanner.hasNextDouble()){
                    try {
                        user.addMoneyWallet(nW, scanner.nextDouble());
                    } catch (NullPointerException e){
                        System.out.println(" Нет такого кошелька ");
                    }
                } else {
                    System.out.println(" Введено не число ");
                }
                break;
            case (3):
                System.out.println(" Введите имя карты ");
                nW = scanner.next();
                System.out.println(" Введите сумму ");
                if (scanner.hasNextDouble()){
                    try {
                        user.withdrawWalletMoney(nW, scanner.nextDouble());
                    } catch (NullPointerException e){
                        System.out.println(" Нет такого кошелька");
                    }
                } else {
                    System.out.println(" Введено не число ");
                }
                break;
            case (4):
                System.out.println(" Введите имя карты ");
                nW = scanner.next();
                try {
                    user.checkWallet(nW);
                } catch (NullPointerException e){
                    System.out.println(" Список пуст ");
                }
                break;
            case (5):
                try {
                    user.printAllWallets();
                } catch (NullPointerException e){
                    System.out.println(" Список пуст ");
                }
                break;
            case (6):
                try {
                    user.getSumAllWallets();
                } catch (NullPointerException e){
                    System.out.println(" Список пуст ");
                }
                break;
            case (7):
                System.out.println(" Введите имя карты ");
                nW = scanner.next();
                try {
                    user.deleteWallet(nW);
                } catch (NullPointerException e){
                    System.out.println(" Нет такого кошелька");
                }
                break;
        }
    }

    private void operationCreditCard(User user) {
        String nB;
        String nCC;
        Double limit;
        Integer gP;
        Double percent;
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - добавить кредитку\n2 - пополнить кредитку " +
                "\n3 - потратить деньги с кредитки \n4 - проверить кредитку\n" +
                "5 - проверить все \n6 - показать кредитки \n7 - удалить кредитку");
        if (scanner.hasNextInt()) {
            switch (scanner.nextInt()) {
                case (1):
                    System.out.println("Введите название банка");
                    nB = scanner.next();
                    System.out.println("Введите имя кредитки");
                    nCC = scanner.next();
                    System.out.println("Введите лимит");
                    if (scanner.hasNextDouble()) {
                        limit = scanner.nextDouble();
                    } else {
                        System.out.println("Введено не число");
                        break;
                    }
                    System.out.println("Введите процент");
                    if (scanner.hasNextDouble()) {
                        percent = scanner.nextDouble();
                    } else {
                        System.out.println("Введено не число");
                        break;
                    }
                    System.out.println("Введите льготный период");
                    if (scanner.hasNextInt()) {
                        gP = scanner.nextInt();
                    } else {
                        System.out.println("Введено не число");
                        break;
                    }
                    user.addCreditCard(nCC, nB, limit, gP, percent);
                    break;
                case (2):
                    System.out.println("Введите имя кредитки");
                    nCC = scanner.next();
                    System.out.println("Введите сумму");
                    if (scanner.hasNextDouble()) {
                        try {
                            user.addMoneyCreditCard(nCC, scanner.nextDouble());
                        } catch (NullPointerException e) {
                            System.out.println("Нет такой кредитки");
                            ;
                        }
                    } else {
                        System.out.println("Введено не число");
                    }
                    break;
                case (3):
                    System.out.println("Введите имя кредитки");
                    nCC = scanner.next();
                    System.out.println("Введите сумму");
                    if (scanner.hasNextDouble()) {
                        try {
                            user.withdrawMoneyCreditCard(nCC, scanner.nextDouble());
                        } catch (NullPointerException e) {
                            System.out.println("Нет такой кредитки");
                        }
                    } else {
                        System.out.println("Введено не число");
                    }
                    break;
                case (4):
                    System.out.println("Введите имя кредитки");
                    nCC = scanner.next();
                    try {
                        user.checkCreditCard(nCC);
                    } catch (NullPointerException e) {
                        System.out.println("Нет такой кредитки");
                    }
                    break;
                case (5):
                    try {
                        user.getSumAllCreditCards();
                    } catch (NullPointerException e) {
                        System.out.println("Список пуст");
                    }
                    break;
                case (6):
                    try {
                        user.showCreditCards();
                    } catch (NullPointerException e) {
                        System.out.println("Список пуст");
                    }
                    break;
                case (7):
                    System.out.println("Введите имя кредитки");
                    nCC = scanner.next();
                    try {
                        user.deleteCreditCard(nCC);
                    } catch (NullPointerException e) {
                        System.out.println("Нет такой кредитки");
                    }
                    break;
            }
        } else {
            System.out.println("Некорректный ввод");
        }
    }

    private void operationCurrentExpense(User user) {
        try {
            user.getAllCurrentExpense();
        } catch (NullPointerException e) {
            System.out.println("Список пуст");
        }
    }

    private void operationPotentialExpense(User user) {
        String name;
        Scanner scanner = new Scanner(System.in);
        System.out.println("1- добавить потенциальную затрату \n2 - вывести список затрат");
        if (scanner.hasNextInt()) {
            switch (scanner.nextInt()) {
                case (1):
                    System.out.println("Введите назначение платежа");
                    name = scanner.next();
                    System.out.println("Введите сумму");
                    if (scanner.hasNextDouble()) {
                        user.addPotentialExpense(name, scanner.nextDouble());
                    } else {
                        System.out.println("Некорректный ввод");
                    }
                    break;
                case (2):
                    try {
                        user.printAllPotentialExpense();
                    }catch (NullPointerException e){
                        System.out.println("Список пуст");
                    }
                    break;
            }
        } else {
            System.out.println("Некорректный ввод");
        }
    }

    private void operationPotentialIncome(User user) {
        String name;
        Scanner scanner = new Scanner(System.in);
        System.out.println("1- добавить потенциальный доход \n2 - вывести список доходов");
        if (scanner.hasNextInt()) {
            switch (scanner.nextInt()) {
                case (1):
                    System.out.println("Введите название дохода");
                    name = scanner.next();
                    System.out.println("Введите сумму");
                    if (scanner.hasNextDouble()) {
                        user.addPotentialIncome(name, scanner.nextDouble());
                    } else {
                        System.out.println("Некорректный ввод");
                    }
                    break;
                case (2):
                    try {
                        user.printAllPotentialIncome();
                    }catch (NullPointerException e){
                        System.out.println("Список пуст");
                    }
                    break;
            }
        } else {
            System.out.println("Некорректный ввод");
        }
    }
}
