/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package freelance.job.platform.simulation;
import java.util.ArrayList;
import java.util.List;
public class Job {
  
    private int id;
    private String title;
    private String description;
    private double budget;
    private Client client;
    private List<Proposal> proposals;
    private boolean closed; // İş kabul edildi mi/kapandı mı?

    public Job(int id, String title, String description, double budget, Client client) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.budget = budget;
        this.client = client;
        this.proposals = new ArrayList<>();
        this.closed = false;
    }

    // İlana teklif ekleme (Çift teklif kontrolü ile birlikte)
    public void addProposal(Proposal proposal) throws DuplicateProposalException {
        for (Proposal p : proposals) {
            if (p.getFreelancer().getId() == proposal.getFreelancer().getId()) {
                throw new DuplicateProposalException(proposal.getFreelancer().getName() + " bu ilana zaten teklif vermiş!");
            }
        }
        proposals.add(proposal);
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public double getBudget() { return budget; }
    public Client getClient() { return client; }
    public List<Proposal> getProposals() { return proposals; }
    public boolean isClosed() { return closed; }
    public void setClosed(boolean closed) { this.closed = closed; }
}

