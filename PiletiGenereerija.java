package com.ruhmatoo.ruhmatoo;

import java.util.ArrayList;

public class PiletiGenereerija {

    public static ArrayList<ArrayList<Integer>> getPiletiAL() {
        ArrayList<ArrayList<Integer>> pilet = new ArrayList<>();
        pilet.add(Numbrid.Bnumbrid());
        pilet.add(Numbrid.Inumbrid());
        pilet.add(Numbrid.Nnumbrid());
        pilet.add(Numbrid.Gnumbrid());
        pilet.add(Numbrid.Onumbrid());
        return pilet;
    }
}
