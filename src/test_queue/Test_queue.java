/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_queue;

/**
 *
 * @author hsz0r
 */
public class Test_queue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        priority_queue test = new priority_queue();
        test.insert(3);
        test.insert(2);
        test.insert(5);
        test.insert(6);
        test.insert(8);


        System.out.println(test.print());
        test.delete();
        System.out.println(test.print());
        System.out.println(test.getMax());
        
        
    }
    
}
