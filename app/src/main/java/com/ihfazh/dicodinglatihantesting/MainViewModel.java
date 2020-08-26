package com.ihfazh.dicodinglatihantesting;

public class MainViewModel {
    private final CuboidModel cuboidModel;

    public MainViewModel(CuboidModel cuboidModel) {
        this.cuboidModel = cuboidModel;
    }

    void save(double l, double h, double w){
        cuboidModel.save(w, l, h);
    }

    double getVolume(){
        return cuboidModel.getVolume();
    }

    double getSurfaceArea(){
        return cuboidModel.getSurfaceArea();
    }

    double getCircumference(){
        return cuboidModel.getCircumference();
    }
}
