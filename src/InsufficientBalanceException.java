/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package freelance.job.platform.simulation;
public class InsufficientBalanceException extends Exception {
    // Bakiye yetersiz olduğunda fırlatılır

    public InsufficientBalanceException(String message) {
        super(message);
    }
}

