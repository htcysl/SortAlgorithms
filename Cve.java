/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;


import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author HP
 */
public class Cve {
    public String id;
    public String sourceIdentifier;
    public Date published;
    public Date lastModified;
    public String vulnStatus;
    public ArrayList<Description> descriptions;
    public Metrics metrics;
    public ArrayList<Weakness> weaknesses;
    public ArrayList<Configuration> configurations;
    public ArrayList<Reference> references;
    public String evaluatorSolution;
    public String evaluatorImpact;
}
