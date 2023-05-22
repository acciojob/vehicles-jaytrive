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
        super(name, 4, 2, 5, isManual, "luxury", 6);
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
            super.stop();
            super.changeGear(1);
        }
        //for all other cases, change the gear accordingly

        //1-50
        if(newSpeed>=1 && newSpeed<=50){
            changeGear(1);
        }

        //51-100
        if(newSpeed>=51 && newSpeed<=100){
            changeGear(2);
        }

        if(newSpeed>=101 && newSpeed<=150){
            changeGear(3);
        }

        if(newSpeed>=151 && newSpeed<=200){
            changeGear(4);
        }

        if(newSpeed>=201 && newSpeed<=250){
            changeGear(5);
        }

        if(newSpeed>=250){
            changeGear(6);
        }


        if(newSpeed > 0) {
            changeSpeed(newSpeed, getCurrentDirection());
        }
    }
}
