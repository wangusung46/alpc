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
@Data
public class Vaccine {

    private Long id = 0L;
    private String date;
    private String state;
    private Integer dailyPartial;
    private Integer dailyFull;
    private Integer dailyBooster;
    private Integer daily;
    private Integer dailyPartialAdol;
    private Integer dailyFullAdol;
    private Integer dailyPartialChild;
    private Integer dailyFullChild;
    private Integer cumulPartial;
    private Integer cumulFull;
    private Integer cumulBooster;
    private Integer cumul;
    private Integer cumulPartialAdol;
    private Integer cumulFullAdol;
    private Integer cumulPartialChild;
    private Integer cumulFullChild;
    private Integer pfizer1;
    private Integer pfizer2;
    private Integer pfizer3;
    private Integer sinovac1;
    private Integer sinovac2;
    private Integer sinovac3;
    private Integer astra1;
    private Integer astra2;
    private Integer astra3;
    private Integer sinopharm1;
    private Integer sinopharm2;
    private Integer sinopharm3;
    private Integer cansino;
    private Integer cansino3;
    private Integer pending1;
    private Integer pending2;
    private Integer pending3;

}
