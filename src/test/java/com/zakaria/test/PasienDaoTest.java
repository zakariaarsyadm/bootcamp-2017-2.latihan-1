/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zakaria.test;

import com.tabeldata.dao.PasienDao;
import com.tabeldata.dao.RuangDao;
import java.sql.SQLException;
import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author namhee
 */
public class PasienDaoTest extends TestCase{
    
    private PasienDao pasienDao = new PasienDao();
    private RuangDao ruangDao = new RuangDao();
    
    @Test
    public void testSaveDataRuang() throws SQLException {
//        ruangDao.save();
    }
    
}
