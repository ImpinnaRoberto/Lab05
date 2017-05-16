package it.polito.tdo.anagrammi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class AnagrammaDAO {

	public AnagrammaDAO() {
		
	}

	
	public boolean isCorrect(String anagramma){
		String prova=
				"SELECT nome "+
				"FROM parola "+
				"WHERE nome=?";
		
	String jdbcURL="jdbc:mysql://localhost/dizionario?user=root&password=root";
	
	try {
		Connection conn = DriverManager.getConnection(jdbcURL);
		PreparedStatement st=conn.prepareStatement(prova);
		st.setString(1, anagramma);
		ResultSet res=st.executeQuery();
		if(res.next())
			return true;
		else
			return false;
		
	} catch (SQLException e) {
		e.printStackTrace();
		return false;
	}
	
	
	}
}
