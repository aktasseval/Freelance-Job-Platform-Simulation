/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package freelance.job.platform.simulation;
import freelance.job.platform.simulation.PlatformManager;

public class Contract {
   
    private Job job;
    private Client client;
    private Freelancer freelancer;
    private double agreedPrice;
    private boolean completed;

    public Contract(Job job, Client client, Freelancer freelancer, double agreedPrice) {
        this.job = job;
        this.client = client;
        this.freelancer = freelancer;
        this.agreedPrice = agreedPrice;
        this.completed = false;
    }

    // İşin bitirilmesi ve Para Transferi İş Mantığı
    public void completeContract() throws InsufficientBalanceException {
        if (completed) {
            System.out.println("Bu iş zaten tamamlandı!");
            return;
        }

        // 1. Müşteriden ücret düşülür (Yetersiz bakiye varsa exception fırlatır)
        client.withdraw(agreedPrice);

        // 2. Freelancer'ın bakiyesine ücret eklenir
        freelancer.deposit(agreedPrice);

        // 3. Sözleşme tamamlandı olarak işaretlenir
        this.completed = true;
        System.out.println("İş başarıyla tamamlandı! Transfer edilen tutar: " + agreedPrice + " TL");
    }

    public Job getJob() { return job; }
    public Client getClient() { return client; }
    public Freelancer getFreelancer() { return freelancer; }
    public double getAgreedPrice() { return agreedPrice; }
    public boolean isCompleted() { return completed; }
}
