/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package freelance.job.platform.simulation;
public class JobNotFoundException extends Exception {
    // İstenen iş ilanı bulunamadığında fırlatılır

    public JobNotFoundException(String message) {
        super(message);
    }
}

