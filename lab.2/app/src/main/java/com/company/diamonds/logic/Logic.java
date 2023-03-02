package com.company.diamonds.logic;

import com.company.diamonds.ui.OutputInterface;

import org.apache.commons.lang3.StringUtils;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
       implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    public void process(int size) {
        boolean flag = false;
        String inside;
        mOut.println('+'+StringUtils.repeat("-",size*2)+'+');
        for (int i=size; i>0; i--) {
            if (flag==true){
                break;
            }
            if ((i-size)%2==0) {
                inside="=";
            }
            else {
                inside="-";
            }
            if (i!=1){
                mOut.println('|'+StringUtils.repeat(" ", i-1)+'/'+StringUtils.repeat(inside, ((i-size)*(-1))*2)+'\\'+StringUtils.repeat(" ", i-1)+'|');
            }
            else{
                mOut.println("|<"+StringUtils.repeat(inside, (size*2)-2)+">|");
                while (i!=size){
                    if ((size-i)%2==0){
                        inside="--";
                    }
                    else{
                        inside="==";
                    }
                    mOut.println('|'+StringUtils.repeat(" ", i)+'\\'+StringUtils.repeat(inside, size-1-i)+'/'+StringUtils.repeat(" ", i)+'|');
                    i++;
                    if (i==size){
                        flag = true;
                    }
                }
            }
        }
        mOut.println('+'+StringUtils.repeat("-",size*2)+'+');
    }
}
