/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.configs;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author namhee
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Rawat {

    private Integer id;
    private Integer pasienId;
    private Integer dokterId;
    private Integer ruangId;
    private Date waktuRegister;
    private Date waktuCheckout;

}
