/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rayhan.alpc.vaxreg.model;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author Khanza
 */
@Data
public class Registration {
    
    private Long id = 0L;
    private Date date;
    private String state;
    private Integer total;
    private Integer phase;
    private Integer mysj;
    private Integer call;
    private Integer web;
    private Integer children;
    private Integer childrenSolo;
    private Integer adolescents;
    private Integer elderly;
    private Integer comorb;
    private Integer oku;

    public Registration() {
        id++;
    }
    
}
