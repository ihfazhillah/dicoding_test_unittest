package com.ihfazh.dicodinglatihantesting;

import android.database.CursorIndexOutOfBoundsException;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MainViewModelTest {

    private MainViewModel mainViewModel;
    private CuboidModel cuboidModel;

    private final double dummyLength = 12.0;
    private final double dummyHeight = 6.0;
    private final double dummyWidth = 7.0;

    private final double dummyVolume = 504.0;
    private final double dummyCircumference = 100.0;
    private final double dummySurfaceArea = 396.0;

    @Before
    public void before(){
        cuboidModel = mock(CuboidModel.class);
        mainViewModel = new MainViewModel(cuboidModel);
    }


    @Test
    public void getVolume() {
        cuboidModel = new CuboidModel();
        mainViewModel = new MainViewModel(cuboidModel);
        mainViewModel.save(dummyLength, dummyHeight, dummyWidth);
        double volume = mainViewModel.getVolume();
        assertEquals(dummyVolume, volume, 0.0001);
    }

    @Test
    public void getSurfaceArea() {
        cuboidModel = new CuboidModel();
        cuboidModel = new CuboidModel();
        mainViewModel = new MainViewModel(cuboidModel);
        mainViewModel.save(dummyLength, dummyHeight, dummyWidth);
        double survvaceArea = mainViewModel.getSurfaceArea();
        assertEquals(dummySurfaceArea, survvaceArea, 0.0001);
    }

    @Test
    public void getCircumference() {
        cuboidModel = new CuboidModel();
        cuboidModel = new CuboidModel();
        mainViewModel = new MainViewModel(cuboidModel);
        mainViewModel.save(dummyLength, dummyHeight, dummyWidth);
        double circumference = mainViewModel.getCircumference();
        assertEquals(dummyCircumference, circumference, 0.0001);
    }

    @Test
    public void testMockVolume(){
        when(mainViewModel.getVolume()).thenReturn(dummyVolume);
        double volume = mainViewModel.getVolume();
        verify(cuboidModel).getVolume();
        assertEquals(dummyVolume, volume, 0.0001);

    }
    @Test
    public void testMockSurvaceArea(){
        when(mainViewModel.getSurfaceArea()).thenReturn(dummySurfaceArea);
        double surfaceArea = mainViewModel.getSurfaceArea();
        verify(cuboidModel).getSurfaceArea();
        assertEquals(dummySurfaceArea, surfaceArea, 0.0001);

    }
    @Test
    public void testMockCircumference(){
        when(mainViewModel.getCircumference()).thenReturn(dummyCircumference);
        double circumference = mainViewModel.getCircumference();
        verify(cuboidModel).getCircumference();
        assertEquals(dummyCircumference, circumference, 0.0001);

    }
}