/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.leecottrell.testjframelecture;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author lee_c
 */
public class PlanetFormTest {
    
    public PlanetForm theForm;
    public JLabel orbitLabel;
    public JLabel gravityLabel;
    public JComboBox planetBox;
    
    public void buildForm(){
        theForm = new PlanetForm();
        orbitLabel = theForm.getOrbitLabel();
        gravityLabel = theForm.getGravityLabel();
        planetBox = theForm.getPlanetBox();
        theForm.setVisible(true);
    }
    public PlanetFormTest() {
    }

    @Test
    public void testMarsGravityWorks() {
        buildForm();
        planetBox.setSelectedItem("Mars");
        String expected = ".375";
        String actual = gravityLabel.getText();
        assertEquals(expected, actual);
        theForm.setVisible(false);
        theForm.dispose();
    }
    
    @Test
    public void testMarsOrbitWorks(){
         buildForm();
        planetBox.setSelectedItem("Mars");
        String expected = "687 Earth Days";
        String actual = orbitLabel.getText();
        assertEquals(expected, actual);
        theForm.setVisible(false);
        theForm.dispose();
    }
    
    @Test
    public void testEarthGravityWorks() {
        buildForm();
        planetBox.setSelectedItem("Earth");
        String expected = "1";
        String actual = gravityLabel.getText();
        assertEquals(expected, actual);
        theForm.setVisible(false);
        theForm.dispose();
    }
    
    @Test
    public void testEarthOrbitWorks(){
         buildForm();
        planetBox.setSelectedItem("Earth");
        String expected = "365 Earth Days";
        String actual = orbitLabel.getText();
        assertEquals(expected, actual);
        theForm.setVisible(false);
        theForm.dispose();
    }
}
