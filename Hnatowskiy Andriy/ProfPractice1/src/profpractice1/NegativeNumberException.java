/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profpractice1;

/**
 *
 * @author Andrew
 */
public class NegativeNumberException extends IllegalArgumentException {
    public NegativeNumberException(String mes) {
        super(mes);
    }
}
