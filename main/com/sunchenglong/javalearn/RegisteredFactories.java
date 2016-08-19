package com.sunchenglong.javalearn;

import com.sun.net.httpserver.Filter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Chenglong Sun on 2016/8/19.
 */
class Part {
    public String toString() {
        return getClass().getName();
    }

    static List<Factory<? extends Part>> partFactories =
            new ArrayList<Factory<? extends Part>>();

    static {
        partFactories.add(new FuelFilter.Factory());
        partFactories.add(new CabinAirFilter.Factory());
        partFactories.add(new OilFilter.Factory());
        partFactories.add(new FenBelt.Factory());
        partFactories.add(new PowerSteeringBelt.Factory());
        partFactories.add(new GeneratorBelt.Factory());
    }

    private static Random random = new Random(47);
    public static Part createRandom(){
        int n = random.nextInt(partFactories.size());
        return partFactories.get(n).create();
    }
}

class FuelFilter extends Part {
    public static class Factory implements com.sunchenglong.javalearn.Factory<FuelFilter> {

        public FuelFilter create() {
            return new FuelFilter();
        }
    }
}

class CabinAirFilter extends Part {
    public static class Factory implements com.sunchenglong.javalearn.Factory<CabinAirFilter> {

        public CabinAirFilter create() {
            return new CabinAirFilter();
        }
    }
}

class OilFilter extends Part {
    public static class Factory implements com.sunchenglong.javalearn.Factory<OilFilter> {

        public OilFilter create() {
            return new OilFilter();
        }
    }
}

class Belt extends Part {
}

class FenBelt extends Belt {
    public static class Factory implements com.sunchenglong.javalearn.Factory<FenBelt> {

        public FenBelt create() {
            return new FenBelt();
        }
    }
}

class GeneratorBelt extends Belt {
    public static class Factory implements com.sunchenglong.javalearn.Factory<GeneratorBelt> {

        public GeneratorBelt create() {
            return new GeneratorBelt();
        }
    }
}

class PowerSteeringBelt extends Belt {
    public static class Factory implements com.sunchenglong.javalearn.Factory<PowerSteeringBelt> {

        public PowerSteeringBelt create() {
            return new PowerSteeringBelt();
        }
    }
}

public class RegisteredFactories {
    public static void main(String[] argv) {
        for(int i = 0; i <10;i++){
            System.out.println(Part.createRandom());
        }
    }
}
