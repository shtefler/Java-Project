package com.ruhmatoo.ruhmatoo;

import java.util.ArrayList;
import java.util.Random;

public class Numbrid {

    public static ArrayList<Integer> Bnumbrid(){
        Random rand = new Random();
        ArrayList<Integer> bnumbrid = new ArrayList();

        while (bnumbrid.size() < 5) {
            int bnum = rand.nextInt(14) + 1;
            if (!bnumbrid.contains(bnum)) {
                bnumbrid.add(bnum);
            }
        }
        return bnumbrid;
    }


    public static ArrayList<Integer> Inumbrid(){
        Random rand = new Random();
        ArrayList<Integer> inumbrid = new ArrayList();
        while (inumbrid.size() < 5){
            int inum = rand.nextInt(14) + 16;
            if (!inumbrid.contains(inum)) {
                inumbrid.add(inum);
            }
        }
        return inumbrid;

    }

    public static ArrayList<Integer> Nnumbrid(){
        Random rand = new Random();
        ArrayList<Integer> nnumbrid = new ArrayList();

        while (nnumbrid.size() < 5) {
            int nnum = rand.nextInt(14) + 31;
            if (!nnumbrid.contains(nnum)) {
                nnumbrid.add(nnum);
            }
        }
        return nnumbrid;
    }
    public static ArrayList<Integer> Gnumbrid(){
        Random rand = new Random();
        ArrayList<Integer> gnumbrid = new ArrayList();

        while (gnumbrid.size() < 5) {
            int gnum = rand.nextInt(14) + 46;
            if (!gnumbrid.contains(gnum)) {
                gnumbrid.add(gnum);
            }
        }
        return gnumbrid;
    }

    public static ArrayList<Integer> Onumbrid(){
        Random rand = new Random();
        ArrayList<Integer> onumbrid = new ArrayList();

        while (onumbrid.size() < 5) {
            int onum = rand.nextInt(14) + 61;
            if (!onumbrid.contains(onum)) {
                onumbrid.add(onum);
            }
        }
        return onumbrid;
    }


    public static void main(String[] args) {

        System.out.println("\n" +
                "Järgmine number on:");

        Random random = new Random();

        int num = random.nextInt(74) + 1;

        if (num < 16) {
            System.out.println("B" + num);
        }else if (num >= 16 && num < 31){
            System.out.println("I" + num);
        }else if (num >= 31 && num < 46) {
            System.out.println("N" + num);
        }else if (num >= 46 && num < 61){
            System.out.println("G" + num);
        } else {
            System.out.println("O" + num);
        }
    }
}