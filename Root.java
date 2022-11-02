/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.ArrayList;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty ;

public class Root {
    public int resultsPerPage;
    public int startIndex;
    public int totalResults;
    public String format;
    public String version;
    public Date timestamp;
    public ArrayList<Vulnerability> vulnerabilities; // 2000 data set
    

     
    public String getCVE_ID(int i) {
        return vulnerabilities.get(i).cve.id ;
    }
    public double getBaseScore(int i) {
        return vulnerabilities.get(i).cve.metrics.cvssMetricV2.get(0).cvssData.baseScore ;
    }
    public double getImpactScore(int i) {
        return vulnerabilities.get(i).cve.metrics.cvssMetricV2.get(0).impactScore;
    }
    public double getExploitabilityScore(int i) {
        return vulnerabilities.get(i).cve.metrics.cvssMetricV2.get(0).exploitabilityScore;
    }
  
}














