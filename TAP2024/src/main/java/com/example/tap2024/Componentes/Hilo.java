package com.example.tap2024.Componentes;

import javafx.scene.control.ProgressBar;

public class Hilo extends Thread {


    private ProgressBar pgbCarril;
    public Hilo(String name){
        super(name);


    }


    public void setPgbCarril (ProgressBar pgbCarril){
        this.pgbCarril=pgbCarril;

    }

    @Override
    public void run(){
        super.run();
        double avance=0;

        while (avance<=1){
        this.getName();

            //System.out.println("Km"+i+"llego"+this.getName());
            avance +=Math.random()/10;
            pgbCarril.setProgress(avance);
            try {
                Thread.sleep((long)(Math.random()*30000));
            }catch (Exception e){


            }


        }

    }
}
