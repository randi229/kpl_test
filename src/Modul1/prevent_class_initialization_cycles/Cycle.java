/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modul1.prevent_class_initialization_cycles;

/**
 *
 * @author Randi 133040229
 */
public class Cycle {
    /* NonCompliant Code
    private final int balance;
    private static final Cycle c = new Cycle();
    private static final int deposit = (int) (Math.random() * 100);
    
    public Cycle(){
        balance = deposit - 10;
    }
    */
    
    // Compliant Code
    private final int balance;
    private static final int deposit = (int) (Math.random() * 100);
    private static final Cycle c = new Cycle();
    
    public Cycle(){
        balance = deposit - 10;
    }
    
    /* 
     * ANALASIS : 
     * perbedaan pada kode diatas adalah pada saat instansiasi objek c,
     * pada Noncompliant code objek c sudah dibuat tetapi ada tambahan variabel deposit
     * dimana variabel tersebut akan memunculkan angka acak yang anantinya dikalikan 100
     * lalu pada konstruktur akan terjadi perhitungan dengan rumus yang sudah ditetapkan.
     * kesalahannya adalah pembuatan objek dilakukan sebelum semua atribut dibuat
     * yang nantinya hasilnya akan menunjukan -10 dikarenakan variabel deposit dianggap 0
     * sedangkan untuk Compliant code, objek dibuat ketika semua atribut objek sudah dibuat ( tidak ada tambahan atribut )
     * 
     * KESIMPULANNYA : 
     * kita haruslah berhati - hati dalam mendeklarasikan sebuah variabel
     */
    
    
    public static void main(String[] args) {
        System.out.println("The account balance is : "+c.balance);
    }
}
