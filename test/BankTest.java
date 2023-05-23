package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.items.Bank;

public class BankTest {
    private Bank bank;

    @BeforeEach
    public void setUp() {
        bank = new Bank(1000);
    }

    @Test
    public void testGetMoney() {
        int currentMoney = bank.getMoney();
        Assertions.assertEquals(1000, currentMoney);
    }

    @Test
    public void testAlterMoney_Add() {
        bank.alterMoney(500);
        int currentMoney = bank.getMoney();
        Assertions.assertEquals(1500, currentMoney);
    }

    @Test
    public void testAlterMoney_Subtract() {
        bank.alterMoney(-500);
        int currentMoney = bank.getMoney();
        Assertions.assertEquals(500, currentMoney);
    }

    @Test
    public void testDecreaseMoney() {
        bank.decreaseMoney(500);
        int currentMoney = bank.getMoney();
        Assertions.assertEquals(500, currentMoney);
    }
}
