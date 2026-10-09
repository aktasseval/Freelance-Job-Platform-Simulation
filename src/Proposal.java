/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package freelance.job.platform.simulation;

public class Proposal {
   
    private Freelancer freelancer;
    private double offer;
    private String message;

    public Proposal(Freelancer freelancer, double offer, String message) {
        this.freelancer = freelancer;
        this.offer = offer;
        this.message = message;
    }

    public Freelancer getFreelancer() { return freelancer; }
    public double getOffer() { return offer; }
    public String getMessage() { return message; }

    @Override
    public String toString() {
        return "Freelancer: " + freelancer.getName() + " | Teklif: " + offer + " TL | Mesaj: " + message;
    }
}

