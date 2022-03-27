/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rayhan.alpc.vax.model;

import java.util.List;
import lombok.Data;

/**
 *
 * @author Raihan
 */
//FOR PAYLOAD MAX MIN / WEEK DATA
@Data
public class WeekMaxMin {
    
    private String week;
    private List<MaxMin> maxMins;
     
}
