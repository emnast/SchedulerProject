package com.example.demo.batchprocessing;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.entity.Task;

public class TaskRowMapper implements RowMapper<Task>{
 
    @Override
    public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
 
    	Task task = new Task();
    	
    	task.setId(rs.getInt("id"));
    	task.setNom_job(rs.getString("nom_job"));
    	task.setDescription(rs.getString("description"));
    	task.setType_commande(rs.getString("type_commande"));
    	task.setScript(rs.getString("script"));
    	task.setDate_execution(rs.getDate("date_execution"));
    //	task.setCronExpression(rs.getString("cronExpression"));
    
             
        return task;
    } 

}
