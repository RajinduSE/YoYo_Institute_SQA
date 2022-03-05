/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentregistration.utils;

import java.sql.*;
/**
 *
 * @author Rajindu's PC
 */
public class IDGenerator {
    private ConnectionUtil conUtil = new ConnectionUtil();
    private Connection conn;
    private Statement st;
    private ResultSet rs;
    
    public String generateId(String tableName, String str){
        String currentId = null;
        String nextId = null;
        conn = conUtil.getConnection();
        String query = "SELECT id FROM " + tableName + " ORDER BY LENGTH(id) DESC,id DESC LIMIT 1";
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            if(rs.next()){
                currentId = rs.getString("id"); 
                nextId = str + (Integer.parseInt(currentId.substring(str.length())) + 1);
            }else{
                nextId = str + 1;
            }             
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return nextId;
    }
}
