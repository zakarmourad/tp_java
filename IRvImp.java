package gcm;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IRvImp implements IRv {

	@Override
	public void addRv(Rv r) {
		// TODO Auto-generated method stub
				String sql = "INSERT INTO rv(jour,client_id,creneau_id) VALUES(?,?,?)";
				try {
					PreparedStatement ps = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
					ps.setDate(1, (Date) r.getJour());
					ps.setInt(2, r.getClient_id());
					ps.setInt(3, r.getCreneau_id());
					ps.executeUpdate();

				}catch(SQLException e) {
					e.printStackTrace();
				}		
	}

	@Override
	public void deleteRv(int id) {
		// TODO Auto-generated method stub
		String sql="delete from rv where id= ?";
		try {
			PreparedStatement ps= DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
				ps.setInt(1, id);
				ps.execute();
			
			
		}catch(SQLException e) {
			e.getStackTrace();
		}		
	}

	@Override
	public void updateRv(Rv c) {
		// TODO Auto-generated method stub
		String sql = "UPDATE rv set jour=?,client_id=?,creneau_id=? where id=?";
		try {
			PreparedStatement ps = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
			ps.setDate(1, (Date) c.getJour());
			ps.setInt(2, c.getClient_id());
			ps.setInt(3, c.getCreneau_id());
			ps.setInt(5, c.getId());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Rv getRv(int id) {
		// TODO Auto-generated method stub
		Rv m = null;
		String sql = "Select * from rv where id= ?";
		try {
			PreparedStatement ps= DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
				ps.setInt(1, id);
				ResultSet res = ps.executeQuery();
				if(res.next()) {
					m = new Rv(res.getInt("id"),res.getDate("jour"),res.getInt("client_id"),res.getInt("creneau_id"));				}
			
		}catch(SQLException e) {
			System.out.println(e.getStackTrace());
		}
		// TODO Auto-generated method stub
		return m;
	}

	@Override
	public List<Rv> getRvs() {
		// TODO Auto-generated method stub
		String sql = "Select * from rv";
		List<Rv> lp= new ArrayList<>();
		
		try {
			PreparedStatement ps= DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
				ResultSet res = ps.executeQuery();
				while(res.next()) {
					Rv m = new Rv(res.getInt(1),res.getDate(2),res.getInt(3),res.getInt(4));
				}
			
		}catch(SQLException e) {
			System.out.println(e.getStackTrace());
		}
		// TODO Auto-generated method stub
		return lp;
		
	}

}
