/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rayhan.alpc.vax.model;

import java.util.List;
import lombok.Data;

/**
 *
 * @author Khanza
 */
@Data
public class WeekMaxMin {
    
    private String max;
    private String min;
    private List<MaxMin> maxMins;
     
}
