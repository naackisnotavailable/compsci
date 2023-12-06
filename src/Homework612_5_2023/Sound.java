package Homework612_5_2023;

import java.util.ArrayList;

public class Sound { //5
    private int[] samples;
    public Sound(int[] samples){
        this.samples = samples;
    }
    public int limitAmplitude(int limit){
        int count = 0;
        for(int i=0; i<samples.length; i++){
            if(samples[i]>limit){
                samples[i]=limit;
                count+=1;
            }
            if(samples[i]<-limit){
                samples[i]=-limit;
                count+=1;
            }
        }
        return count;
    }
    public void trimSilenceFromBeginning(){
        ArrayList<Integer> list = new ArrayList<>();

        for (int sample : this.samples) {
            if (sample != 0) {
                list.add(sample);
            }
        }
        int[] arr = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            arr[i] = list.get(i);
        }
        samples = arr;
    }
    public int[] getSamples(){
        return this.samples;
    }
}
