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
        int newSpeed = rate; //set the value of new speed by using currentSpeed and rate
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
        if(getCurrentSpeed()+rate>=1 && getCurrentSpeed()+rate<=50){
            setCurrentGear(1);
            setCurrentSpeed(getCurrentSpeed()+rate);
        }

        //51-100
        if(getCurrentSpeed()+rate>=51 && getCurrentSpeed()+rate<=100){
            setCurrentGear(2);
            setCurrentSpeed(getCurrentSpeed()+rate);
        }

        if(getCurrentSpeed()+rate>=101 && getCurrentSpeed()+rate<=150){
            setCurrentGear(3);
            setCurrentSpeed(getCurrentSpeed()+rate);
        }

        if(getCurrentSpeed()+rate>=151 && getCurrentSpeed()+rate<=200){
            setCurrentGear(4);
            setCurrentSpeed(getCurrentSpeed()+rate);
        }

        if(getCurrentSpeed()+rate>=201 && getCurrentSpeed()+rate<=250){
            setCurrentGear(5);
            setCurrentSpeed(getCurrentSpeed()+rate);
        }

        if(getCurrentSpeed()+rate>=250){
            setCurrentGear(6);
            setCurrentSpeed(getCurrentSpeed()+rate);
        }


        if(getCurrentSpeed()+rate > 0) {
            changeSpeed(getCurrentSpeed()+rate, getCurrentDirection());
        }
    }
}
