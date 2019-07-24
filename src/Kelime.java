/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cem kuru
 */
class Kelime {
    
    int adet = 0;
    String kelime;
    
    public void arttir() {
        
        adet += 1;
    }
    
    public Kelime(int adet, String kelime) {
        this.adet = adet;
        this.kelime=kelime;
    }

    
}
