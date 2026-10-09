/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package freelance.job.platform.simulation;
import java.util.HashMap;
import java.util.Map;
public class PlatformManager {
   
    private Map<Integer, User> users = new HashMap<>();
    private Map<Integer, Job> jobs = new HashMap<>();

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public void addJob(Job job) {
        jobs.put(job.getId(), job);
        job.getClient().addJob(job);
    }

    public Job getJobById(int jobId) throws JobNotFoundException {
        if (!jobs.containsKey(jobId)) {
            throw new JobNotFoundException(jobId + " ID'li iş ilanı bulunamadı!");
        }
        return jobs.get(jobId);
    }

    public User getUserById(int userId) {
        return users.get(userId);
    }

    // Bir ilanın teklifini kabul edip Contract oluşturma
    public Contract acceptProposal(int jobId, String freelancerName) 
            throws JobNotFoundException, ProposalNotFoundException, InsufficientBalanceException {
        
        Job job = getJobById(jobId);
        Proposal selectedProposal = null;

        for (Proposal p : job.getProposals()) {
            if (p.getFreelancer().getName().equalsIgnoreCase(freelancerName)) {
                selectedProposal = p;
                break;
            }
        }

        if (selectedProposal == null) {
            throw new ProposalNotFoundException(freelancerName + " isimli freelancer'ın teklifi bulunamadı!");
        }

        // İş ilanını kapat
        job.setClosed(true);

        // Sözleşmeyi oluştur
        Contract contract = new Contract(job, job.getClient(), selectedProposal.getFreelancer(), selectedProposal.getOffer());
        selectedProposal.getFreelancer().addContract(contract);

        return contract;
    }
}

