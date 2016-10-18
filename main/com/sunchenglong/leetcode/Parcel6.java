package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/8/12.
 */
public class Parcel6 {
    private void internalTracking(boolean b) {
        if(b) {
            class TrackingSlip {
                private String id;
                TrackingSlip(String id) {
                    this.id = id;
                }
                String getSlip() {
                    return id;
                }
            }
            TrackingSlip trackingSlip = new TrackingSlip("Slip!");
            String s = trackingSlip.getSlip();
            System.out.println(s);
        }
    }
    public void track() {
        internalTracking(true);
    }

    public static void main(String[] args) {
        Parcel6 parcel6 = new Parcel6();
        parcel6.track();
    }
}
