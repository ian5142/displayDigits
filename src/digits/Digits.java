/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digits;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import java.util.ArrayList;

/**
 *  Library to display digits 0 to 9 on two separate 7-segment displays via Raspberry PI GPIO pins
 * @author Ian Van Schaick
 */
public class Digits {
    final GpioController gpio;
    final GpioPinDigitalOutput segA;
    final GpioPinDigitalOutput segB;
    final GpioPinDigitalOutput segC;
    final GpioPinDigitalOutput segD;
    final GpioPinDigitalOutput segE;
    final GpioPinDigitalOutput segF;
    final GpioPinDigitalOutput segG;
    final GpioPinDigitalOutput segDP;
    
    final GpioPinDigitalOutput segA1;
    final GpioPinDigitalOutput segB1;
    final GpioPinDigitalOutput segC1;
    final GpioPinDigitalOutput segD1;
    final GpioPinDigitalOutput segE1;
    final GpioPinDigitalOutput segF1;
    final GpioPinDigitalOutput segG1;
    final GpioPinDigitalOutput segDP1;
    
    ArrayList<ArrayList<GpioPinDigitalOutput>> firstDigit;
    ArrayList<ArrayList<GpioPinDigitalOutput>> secondDigit;
    
    /**
     * Initializes the Digits object
     */
    public Digits () { 
        gpio = GpioFactory.getInstance();
        segA = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "Segment A", PinState.HIGH);
        segB = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "Segment B", PinState.HIGH);
        segC = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "Segment C", PinState.HIGH);
        segD = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "Segment D", PinState.HIGH);
        segE = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "Segment E", PinState.HIGH);
        segF = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "Segment F", PinState.HIGH);
        segG = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06, "Segment G", PinState.HIGH);
        segDP = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07, "Segment DP", PinState.HIGH);
        
        segA1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_08, "Segment A1", PinState.HIGH);
        segB1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_09, "Segment B1", PinState.HIGH);
        segC1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_10, "Segment C1", PinState.HIGH);
        segD1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_11, "Segment D1", PinState.HIGH);
        segE1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_12, "Segment E1", PinState.HIGH);
        segF1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_13, "Segment F1", PinState.HIGH);
        segG1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_14, "Segment G1", PinState.HIGH);
        segDP1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_15, "Segment DP1", PinState.HIGH);
        
        segA.setShutdownOptions(true, PinState.LOW);
        segB.setShutdownOptions(true, PinState.LOW);
        segC.setShutdownOptions(true, PinState.LOW);
        segD.setShutdownOptions(true, PinState.LOW);
        segE.setShutdownOptions(true, PinState.LOW);
        segF.setShutdownOptions(true, PinState.LOW);
        segG.setShutdownOptions(true, PinState.LOW);
        segDP.setShutdownOptions(true, PinState.LOW);
        
        segA1.setShutdownOptions(true, PinState.LOW);
        segB1.setShutdownOptions(true, PinState.LOW);
        segC1.setShutdownOptions(true, PinState.LOW);
        segD1.setShutdownOptions(true, PinState.LOW);
        segE1.setShutdownOptions(true, PinState.LOW);
        segF1.setShutdownOptions(true, PinState.LOW);
        segG1.setShutdownOptions(true, PinState.LOW);
        segDP1.setShutdownOptions(true, PinState.LOW);
        
        setArrayList();
    }
    
    /**
     * Sets the two ArrayLists containing the correct pins for each digit plus the DP.
     */
    private void setArrayList() {
        ArrayList<GpioPinDigitalOutput> pins = new ArrayList<GpioPinDigitalOutput> ();
        ArrayList<GpioPinDigitalOutput> pins2 = new ArrayList<GpioPinDigitalOutput> ();
        
        for (int i = 0; i < 11 ; i++) {
            if(i == 0) {
                pins.add(segA);
                pins.add(segB);
                pins.add(segC);
                pins.add(segD);
                pins.add(segE);
                pins.add(segF);
                
                pins2.add(segA1);
                pins2.add(segB1);
                pins2.add(segC1);
                pins2.add(segD1);
                pins2.add(segE1);
                pins2.add(segF1);
            }
            else if (i == 1) {
                pins.add(segB);
                pins.add(segC);
                
                pins2.add(segB1);
                pins2.add(segC1);
            }
            else if(i == 2) {
                pins.add(segA);
                pins.add(segB);
                pins.add(segD);
                pins.add(segE);
                pins.add(segG);
                
                pins2.add(segA1);
                pins2.add(segB1);
                pins2.add(segD1);
                pins2.add(segE1);
                pins2.add(segG1);
            }
            else if (i == 3) {
                pins.add(segA);
                pins.add(segB);
                pins.add(segC);
                pins.add(segD);
                pins.add(segG);
                
                pins2.add(segA1);
                pins2.add(segB1);
                pins2.add(segC1);
                pins2.add(segD1);
                pins2.add(segG1);
            }
            else if (i == 4) {
                pins.add(segB);
                pins.add(segC);
                pins.add(segF);
                pins.add(segG);
                
                pins2.add(segB1);
                pins2.add(segC1);
                pins2.add(segF1);
                pins2.add(segG1);
            }
            else if (i == 5) {
                pins.add(segA);
                pins.add(segC);
                pins.add(segD);
                pins.add(segF);
                pins.add(segG);
                
                pins2.add(segA1);
                pins2.add(segC1);
                pins2.add(segD1);
                pins2.add(segF1);
                pins2.add(segG1);
            }
            else if (i == 6) {
                pins.add(segB);
                pins.add(segC);
                pins.add(segD);
                pins.add(segE);
                pins.add(segF);
                pins.add(segG);
                
                pins2.add(segB1);
                pins2.add(segC1);
                pins2.add(segD1);
                pins2.add(segE1);
                pins2.add(segF1);
                pins2.add(segG1);
            }
            else if (i == 7) {
                pins.add(segA);
                pins.add(segB);
                pins.add(segC);
                
                pins2.add(segA1);
                pins2.add(segB1);
                pins2.add(segC1);
            }
            else if (i == 8) {
                pins.add(segA);
                pins.add(segB);
                pins.add(segC);
                pins.add(segD);
                pins.add(segE);
                pins.add(segF);
                pins.add(segG);
                
                pins2.add(segA1);
                pins2.add(segB1);
                pins2.add(segC1);
                pins2.add(segD1);
                pins2.add(segE1);
                pins2.add(segF1);
                pins2.add(segG1);
            }
            else if (i == 9) {
                pins.add(segA);
                pins.add(segB);
                pins.add(segC);
                pins.add(segF);
                pins.add(segG);
                
                pins2.add(segA1);
                pins2.add(segB1);
                pins2.add(segC1);
                pins2.add(segF1);
                pins2.add(segG1);
            }
            else if (i == 10) {
                pins.add(segDP);
                
                pins2.add(segDP1);
            }
            firstDigit.add(pins);
            secondDigit.add(pins);
        }
    }
    
    /**
     * Gets the pins to display a certain digit on one of the 7-segment displays
     * @param display The chosen display, 0 for left digit, 1 for right digit.
     * @param digit The digit to display
     * @return An arraylist, of type GpioPinDigitalOutput, containing the pins 
     * to display the digit on the chosen display
     */
    public ArrayList<GpioPinDigitalOutput> getDigitPins (int display, int digit) {
        ArrayList<GpioPinDigitalOutput> digitPins = new ArrayList<GpioPinDigitalOutput>();
        if (display == 0) {
            for (int i = 0 ; i <= digit ; i++) {
                if (digit == i) {
                    digitPins = firstDigit.get(i);
                }
            }
        }
        else {
            for (int i = 0 ; i <= digit ; i++) {
                if (digit == i) {
                    digitPins = secondDigit.get(i);
                }
            }
        }
        return digitPins;
    }
}
