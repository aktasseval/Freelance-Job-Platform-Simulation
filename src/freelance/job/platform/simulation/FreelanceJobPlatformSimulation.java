/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package freelance.job.platform.simulation;
import java.util.Scanner;

public class FreelanceJobPlatformSimulation {
    public static void main(String[] args) {
        PlatformManager manager = new PlatformManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== FREELANCE PLATFORM SIMULASYONU BAŞLADI ===");

        // 1. KULLANICILARI OLUŞTURMA
        // Client (İş Veren): ID = 1, Bakiye = 8000 TL
        Client client1 = new Client(1, "Ahmet Yılmaz", 8000.0);
        
        // Freelancer'lar (İş Yapanlar): Bakiye = 0 TL
        Freelancer freelancerA = new Freelancer(10, "Mehmet (Freelancer A)", 0.0);
        Freelancer freelancerB = new Freelancer(20, "Ayşe (Freelancer B)", 0.0);

        manager.addUser(client1);
        manager.addUser(freelancerA);
        manager.addUser(freelancerB);

        System.out.println("\n[Sistem] Kullanıcılar ve bakiyeleri sisteme tanımlandı.");
        System.out.println("Client: " + client1.getName() + " | Bakiye: " + client1.getBalance() + " TL");

        // 2. İŞ İLANI OLUŞTURMA
        // Müşteri 8000 TL bütçeli bir ilan açıyor
        Job job1 = new Job(101, "E-Ticaret Web Sitesi", "Java & React ile web sitesi yaptırılacak", 8000.0, client1);
        manager.addJob(job1);

        System.out.println("\n--------------------------------------------------");
        System.out.println("[İlan Açıldı] ID: " + job1.getId() + " | Başlık: " + job1.getTitle() + " | Bütçe: " + job1.getBudget() + " TL");

        // 3. TEKLİF VERME AŞAMASI (TRY-CATCH İLE HATA YÖNETİMİ)
        System.out.println("\n--------------------------------------------------");
        System.out.println("--- TEKLİFLER ALINIYOR ---");

        try {
            // Freelancer A 6500 TL teklif veriyor
            Proposal p1 = new Proposal(freelancerA, 6500.0, "15 günde teslim edebilirim.");
            job1.addProposal(p1);
            System.out.println("-> Freelancer A teklif verdi: 6500 TL");

            // DENEME: Freelancer A tekrar teklif vermeye çalışsın (Hata fırlatmalı)
            // Proposal p1_duplicate = new Proposal(freelancerA, 6000.0, "Fiyatı düşürdüm!");
            // job1.addProposal(p1_duplicate); 

            // Freelancer B 7200 TL teklif veriyor
            Proposal p2 = new Proposal(freelancerB, 7200.0, "10 günde kaliteli teslimat.");
            job1.addProposal(p2);
            System.out.println("-> Freelancer B teklif verdi: 7200 TL");

        } catch (DuplicateProposalException e) {
            System.err.println("[HATA] " + e.getMessage());
        }

        // 4. CLIENT'IN TEKLİFLERİ LİSTELEMESİ VE SEÇİM YAPMASI
        System.out.println("\n--------------------------------------------------");
        System.out.println("--- " + client1.getName() + " GELEN TEKLİFLERİ İNCELEYİP SEÇİYOR ---");
        
        for (Proposal p : job1.getProposals()) {
            System.out.println("- " + p.getFreelancer().getName() + " -> " + p.getOffer() + " TL (Mesaj: " + p.getMessage() + ")");
        }

        // 5. TEKLİFİN KABUL EDİLMESİ VE SÖZLEŞME (CONTRACT) OLUŞUMU
        Contract contract = null;
        try {
            // Client, Freelancer A'nın (Mehmet) teklifini kabul ediyor
            contract = manager.acceptProposal(101, "Mehmet (Freelancer A)");
            System.out.println("\n[Sözleşme Oluştu] " + contract.getFreelancer().getName() + " ile teklif kabul edildi.");
            System.out.println("Anlaşılan Fiyat: " + contract.getAgreedPrice() + " TL");

        } catch (JobNotFoundException | ProposalNotFoundException | InsufficientBalanceException e) {
            System.err.println("[HATA] " + e.getMessage());
        }

        // 6. İŞİN TAMAMLATILMASI VE PARA TRANSFERİ
        System.out.println("\n--------------------------------------------------");
        System.out.println("--- İŞİN TAMAMLANMASI VE PARA TRANSFERİ ---");

        if (contract != null) {
            try {
                // İş tamamlanıyor ve bakiyeler güncelleniyor
                contract.completeContract();

            } catch (InsufficientBalanceException e) {
                System.err.println("[HATA] Para transferi başarısız: " + e.getMessage());
            }
        }

        // 7. SON DURUM KONTROLÜ (BAKİYELER VE GEÇMİŞ)
        System.out.println("\n==================================================");
        System.out.println("--- SİSTEM SON DURUMU ---");
        System.out.println("Client Bakiyesi: " + client1.getBalance() + " TL (8000 TL idi, 6500 TL düştü)");
        System.out.println("Freelancer A Bakiyesi: " + freelancerA.getBalance() + " TL (0 TL idi, 6500 TL eklendi)");
        System.out.println("Freelancer B Bakiyesi: " + freelancerB.getBalance() + " TL");

        // Freelancer'ın yaptığı işler
        System.out.println("\nFreelancer A'nın Tamamladığı İşler:");
        for (Contract c : freelancerA.getMyContracts()) {
            System.out.println("- İş: " + c.getJob().getTitle() + " | Kazanç: " + c.getAgreedPrice() + " TL | Durum: " + (c.isCompleted() ? "Tamamlandı" : "Devam Ediyor"));
        }

        scanner.close();
    }
}
    
    

