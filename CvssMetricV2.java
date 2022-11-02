/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author HP
 */
public class CvssMetricV2 {
    public String source;
    public String type;
    public CvssData cvssData;
    public double exploitabilityScore;
    public double impactScore;
    public boolean acInsufInfo;
    public boolean obtainAllPrivilege;
    public boolean obtainUserPrivilege;
    public boolean obtainOtherPrivilege;
    public boolean userInteractionRequired;
    
    
    public String toString() {
        
        return "cvssData.baseScore: "+cvssData.baseScore+
                " impactScore : "+impactScore+
                " exploitabilityScore :  "
                +exploitabilityScore ; 
    }
}
