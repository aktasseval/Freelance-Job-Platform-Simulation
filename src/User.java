/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package freelance.job.platform.simulation;
public abstract class User {
    
    private int id;
    private String name;
    private double balance;

    public User(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    // Bakiye Artırma (Para Kazanma/Yükleme)
    public void deposit(double amount) {
        this.balance += amount;
    }

    // Bakiye Düşme (Ödeme Yapma)
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (this.balance < amount) {
            throw new InsufficientBalanceException("Yetersiz bakiye! Mevcut bakiye: " + this.balance + " TL, Gerekli: " + amount + " TL");
        }
        this.balance -= amount;
    }

    // Getter ve Setter Metodları
    public int getId() { return id; }
    public String getName() { return name; }
    public double getBalance() { return balance; }
}

