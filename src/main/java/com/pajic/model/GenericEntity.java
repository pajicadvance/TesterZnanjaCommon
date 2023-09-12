/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pajic.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public interface GenericEntity extends Serializable {

    String getTableName();

    String getColumnNamesForInsert();

    String getInsertValues();
    
    String getUpdateValues();
    
    String getWhereCondition();
    
    String getWhereFilteredCondition();
    
    PreparedStatement prepareStatement(PreparedStatement statement, GenericEntity entity);
    
    GenericEntity selectObject(ResultSet rs) throws SQLException;
    
    void setId(Long id);
    
}
