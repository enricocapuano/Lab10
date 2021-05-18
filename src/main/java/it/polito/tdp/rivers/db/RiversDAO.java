package it.polito.tdp.rivers.db;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import it.polito.tdp.rivers.model.Flow;
import it.polito.tdp.rivers.model.Info;
import it.polito.tdp.rivers.model.River;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RiversDAO {

	public List<River> getAllRivers() {
		
		final String sql = "SELECT id, name FROM river";

		List<River> rivers = new LinkedList<River>();

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				rivers.add(new River(res.getInt("id"), res.getString("name")));
			}

			conn.close();
			
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new RuntimeException("SQL Error");
		}

		return rivers;
	}
	
	public Info getInfoRiver(int id) {
		String sql = "SELECT MAX(f.day) AS max, MIN(f.day) AS min, AVG(f.flow) AS media, COUNT(*) AS tot "
				+ "FROM flow f "
				+ "WHERE f.river = ?";
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet res = st.executeQuery();
			res.next();
			
			Info i = new Info(res.getDate("min").toLocalDate(), res.getDate("max").toLocalDate(), res.getFloat("tot"), res.getFloat("media"));
			
			res.close();
			st.close();
			conn.close();
			
			return i;
			
		} catch (SQLException e) {
			throw new RuntimeException("SQL Error", e);
		}

	}
	
	public River getRiver(int id) {
		for(River r : this.getAllRivers()) {
			if(r.getId() == id) {
				return r;
			}
		}
		return null;
	}
	
	public void getAllFlows(PriorityQueue<Flow> coda, int id) {
		String sql = "SELECT * "
				+ "FROM flow "
				+ "WHERE river = ?";
		

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				Flow flow = new Flow(res.getDate("day").toLocalDate(), res.getFloat("flow"), this.getRiver(res.getInt("river")));
				coda.add(flow);
			}

			conn.close();
			
		} catch (SQLException e) {
			throw new RuntimeException("SQL Error");
		}
	}
}
