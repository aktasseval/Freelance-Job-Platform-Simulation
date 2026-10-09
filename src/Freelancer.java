/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package freelance.job.platform.simulation;
import java.util.ArrayList;
import java.util.List;

public class Freelancer extends User {
 

    private List<Contract> myContracts;

    public Freelancer(int id, String name, double balance) {
        super(id, name, balance);
        this.myContracts = new ArrayList<>();
    }

    public void addContract(Contract contract) {
        this.myContracts.add(contract);
    }

    public List<Contract> getMyContracts() {
        return myContracts;
    }
}

