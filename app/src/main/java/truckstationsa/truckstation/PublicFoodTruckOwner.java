package truckstationsa.truckstation;

import android.app.Fragment;

import java.util.EmptyStackException;

/**
 * Created by manal on 2/8/2018.
 */

public class PublicFoodTruckOwner  {

    private  String FUsername  , FPassword , FEmail  , FPreOrderStatuse , FWorkingHours , Fstatus , qusins;
    private  int FPoneNoumber ;
    private double XFLication;
    private double YFLocation;
    public PublicFoodTruckOwner (){}
    public PublicFoodTruckOwner ( String FUsername  ,String FPassword ,String FEmail ,  int FPoneNoumber , double XFLication , double YFLocation ,String  qusins  ){
        this.setFEmail(FEmail);

        this.setFPassword(FPassword);

        this.setFPoneNoumber(FPoneNoumber);

        this.setFUsername(FUsername);


        this.setXFLication(XFLication);

        this.setYFLocation(YFLocation);

        this.setQusins(qusins);


    }

    public void setQusins(String qusins) {
        this.qusins = qusins;
    }

    public void setFEmail(String FEmail) {
        this.FEmail = FEmail;
    }

    public void setFPassword(String FPassword) {
        this.FPassword = FPassword;
    }

    public void setFPoneNoumber(int FPoneNoumber) {
        this.FPoneNoumber = FPoneNoumber;
    }

    public void setFPreOrderStatuse(String FPreOrderStatuse) {
        this.FPreOrderStatuse = FPreOrderStatuse;
    }

    public void setFstatus(String fstatus) {
        Fstatus = fstatus;
    }


    public void setFUsername(String FUsername) {
        this.FUsername = FUsername;
    }

    public void setFWorkingHours(String FWorkingHours) {
        this.FWorkingHours = FWorkingHours;
    }

    public void setXFLication(double XFLication) {
        this.XFLication = XFLication;
    }

    public void setYFLocation(double YFLocation) {
        this.YFLocation = YFLocation;
    }

    public double getXFLication() {
        return XFLication;
    }

    public double getYFLocation() {
        return YFLocation;
    }

    public int getFPoneNoumber() {
        return FPoneNoumber;
    }

    public String getFEmail() {
        return FEmail;
    }

    public String getFPassword() {
        return FPassword;
    }

    public String getFPreOrderStatuse() {
        return FPreOrderStatuse;
    }

    public String getFstatus() {
        return Fstatus;
    }


    public String getFUsername() {
        return FUsername;
    }

    public String getFWorkingHours() {
        return FWorkingHours;
    }

    public String getQusins() {
        return qusins;
    }
}
