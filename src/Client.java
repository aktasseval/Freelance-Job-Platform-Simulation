/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package freelance.job.platform.simulation;
import java.util.ArrayList;
import java.util.List;

public class Client extends User{


    private List<Job> myJobs;

    public Client(int id, String name, double balance) {
        super(id, name, balance);
        this.myJobs = new ArrayList<>();
    }

    public void addJob(Job job) {
        this.myJobs.add(job);
    }

    public List<Job> getMyJobs() {
        return myJobs;
    }
}

