package com.moberan.t03;

class JavaSAMSample {

    static SAMInterface ss = null;
    public static void setSAM(SAMInterface sam) {
        ss = sam;
    }

    public static void doFire(int pos) {
        if (ss != null)
            ss.onClick(pos);
        else
            System.out.println("ss is null");
    }

    interface SAMInterface {
        void onClick(int position);
    }
}