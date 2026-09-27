package com.devops;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    public void setUp() {
        account = new BankAccount("ACC-1001", "John Doe", 500.0);
    }

    @Test
    public void testDeposit() {
        double updatedBalance = account.deposit(150.0);

        assertEquals(650.0, updatedBalance, 0.001);
        assertEquals(650.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawSuccess() {
        boolean result = account.withdraw(200.0);

        assertTrue(result);
        assertEquals(300.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        boolean result = account.withdraw(700.0);

        assertFalse(result);
        assertEquals(500.0, account.getBalance(), 0.001);
    }

    @Test
    public void testCalculateInterest() {
        double interest = account.calculateInterest(5.0);

        assertEquals(25.0, interest, 0.001);
    }

    @Test
    public void testDepositInvalidAmount() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-50.0));
        assertThrows(IllegalArgumentException.class, () -> account.deposit(0.0));
    }

    @Test
    public void testWithdrawInvalidAmount() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-20.0));
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(0.0));
    }

    @Test
    public void testCalculateInterestNegativeRate() {
        assertThrows(IllegalArgumentException.class, () -> account.calculateInterest(-2.5));
    }
}
