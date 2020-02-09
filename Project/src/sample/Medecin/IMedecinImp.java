package gcm;

import sample.Medecin.IMedecin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IMedecinImp implements IMedecin {
	@Override
	public void addMedecin(Medecin m) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO medecins(nom,prenom,titre,version) VALUES(?,?,?,?)";
		try {
			PreparedStatement ps = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
			ps.setString(1, m.getNom());
			ps.setString(2, m.getPrenom());
			ps.setString(3, m.getTitre());
			ps.setInt(4, m.getVersion());
			ps.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteMedecin(int id) {
		// TODO Auto-generated method stub
		String sql="delete from medecins where id= ?";
		try {
			PreparedStatement ps= DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
				ps.setInt(1, id);
				ps.execute();
			
			
		}catch(SQLException e) {
			e.getStackTrace();
		}
		
	}

	@Override
	public void updateMedecin(Medecin m) {
		// TODO Auto-generated method stub
		String sql = "UPDATE medecins set nom=?,prenom=?,titre=?,version=? where id=?";
		try {
			PreparedStatement ps = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
			ps.setString(1, m.getNom());
			ps.setString(2, m.getPrenom());
			ps.setString(3, m.getTitre());
			ps.setInt(4, m.getVersion());
			ps.setInt(5, m.getId());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Medecin getMedecin(int id) {
		Medecin m = null;
		String sql = "Select * from medecins where id= ?";
		try {
			PreparedStatement ps= DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
				ps.setInt(1, id);
				ResultSet res = ps.executeQuery();
				if(res.next()) {
					m = new Medecin(id,res.getString("nom"),res.getString("prenom"),res.getString("titre"),res.getInt("version"));
				}
			
		}catch(SQLException e) {
			System.out.println(e.getStackTrace());
		}
		// TODO Auto-generated method stub
		return m;
	}

	@Override
	public List<Medecin> getMedecins() {
		String sql = "Select * from medecins";
		List<Medecin> lp= new ArrayList<>();
		
		try {
			PreparedStatement ps= DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
				ResultSet res = ps.executeQuery();
				while(res.next()) {
					Medecin m = new Medecin(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getInt(5));
				}
			
		}catch(SQLException e) {
			System.out.println(e.getStackTrace());
		}
		// TODO Auto-generated method stub
		return lp;
	}

}
