package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(convert(5));
        System.out.println(divisibleByFive(25));
        System.out.println(points(26,9));
        System.out.println(footballPoints(5,6,1));
        System.out.println(and(false,true));
        System.out.println(howManyWalls(10,15,12));
        System.out.println(squared(9));
        System.out.println(profitableGamble(0.9, 3, 2));
        System.out.println(frames(10, 25));
        System.out.println(mod(218,5));
    }
    public static int convert(int x) { return x*60; }
    public static boolean divisibleByFive(int x){
        return x%5==0;
    }
    public static int points(int x, int y){
        return (2*x+3*y);
    }
    public static int footballPoints(int x, int y, int z){
        return (3*x+y);
    }
    public static boolean and(boolean x, boolean y){
        return x&&y;
    }
    public static int howManyWalls(int n, int w, int h) { return n/(w*h); }
    public static int squared(int x){
        return x*x;
    }
    public static boolean profitableGamble(double prob, int prize, int pay){
        return prob*prize>pay;
    }
    public static int frames(int x, int y){
        return x*60*y;
    }
    public static int mod(int x, int y){
        return x-(x/y)*y;
    }
    }
