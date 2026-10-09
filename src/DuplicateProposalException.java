/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package freelance.job.platform.simulation;
public class DuplicateProposalException extends Exception{
    // Aynı freelancer bir işe 2. kez teklif vermeye çalıştığında fırlatılır

    public DuplicateProposalException(String message) {
        super(message);
    }
}

