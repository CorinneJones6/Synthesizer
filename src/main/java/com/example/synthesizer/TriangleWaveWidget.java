package com.example.synthesizer;

import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class TriangleWaveWidget extends GeneratorWidgetBase{
    TriangleWaveWidget(AudioComponent ac, AnchorPane parent) {
        super(ac, parent);
    }
    @Override
    void createView(){
        Label freqLabel = new Label("TriangleWave 300Hz");
        Slider freqSlider = new Slider(200, 400, 300);
        leftSide_.getChildren().add(freqLabel);
        leftSide_.getChildren().add(freqSlider);
        freqSlider.setOnMouseDragged(e->setFrequency(e, freqSlider, freqLabel));
    }
    private void setFrequency(MouseEvent e, Slider freqSlider, Label freqLabel) {
        ((TriangleWave)ac_).setFrequency((int) (freqSlider.getValue()+.5));
        int val = (int)freqSlider.getValue();
        freqLabel.setText("TriangleWave "+val+"Hz");
    }
}
