/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rayhan.alpc.vax.model;

import lombok.Data;

/**
 *
 * @author Raihan
 */
//FOR RESPONSE VACCINE TYPE
@Data
public class Type {
    
    private Long id;
    private String type;
    private Integer total = 0;
    
}
