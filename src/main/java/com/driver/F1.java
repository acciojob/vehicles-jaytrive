package com.driver;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.sound.midi.Soundbank;
import java.lang.ref.SoftReference;
import java.sql.SQLOutput;

@Getter
@Setter
public class F1 extends Car {

    public F1(String name, boolean isManual) {
        setName(name);
        setManual(isManual);
        //Use arbitrary values for parameters which are not mentioned;
    }


    public void accelerate(int rate){
        int newSpeed = getCurrentSpeed()+rate; //set the value of new speed by using currentSpeed and rate
        /**
         * speed 0: gear 1
         * speed 1-50: gear 1
         * speed 51-100: gear 2
         * speed 101-150: gear 3
         * speed 151-200: gear 4
         * speed 201-250: gear 5
         * speed more than 250: gear 6
         */

        //Stop the car, set gear as 1
        if(newSpeed == 0) {
            setCurrentGear(1);
            setCurrentSpeed(0);}
        //for all other cases, change the gear accordingly

        //1-50
        if(newSpeed>=1 && newSpeed<=50){
            setCurrentGear(1);
            setCurrentSpeed(newSpeed);
        }

        //51-100
        if(newSpeed>=51 && newSpeed<=100){
            setCurrentGear(2);
            setCurrentSpeed(newSpeed);
        }

        if(newSpeed>=101 && newSpeed<=150){
            setCurrentGear(3);
            setCurrentSpeed(newSpeed);
        }

        if(newSpeed>=151 && newSpeed<=200){
            setCurrentGear(4);
            setCurrentSpeed(newSpeed);
        }

        if(newSpeed>=201 && newSpeed<=250){
            setCurrentGear(5);
            setCurrentSpeed(newSpeed);
        }

        if(newSpeed>=250){
            setCurrentGear(6);
            setCurrentSpeed(newSpeed);
        }


        if(newSpeed > 0) {
            changeSpeed(newSpeed, getCurrentDirection());
        }
    }
}
