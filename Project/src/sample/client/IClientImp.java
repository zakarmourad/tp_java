package sample.Medecin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IClientImp implements IClient {

	@Override
	public void addClient(Client c) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO clients(nom,prenom,titre,version) VALUES(?,?,?,?)";
		try {
			PreparedStatement ps = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
			ps.setString(1, c.getNom());
			ps.setString(2, c.getPrenom());
			ps.setString(3, c.getTitre());
			ps.setInt(4, c.getVersion());
			ps.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteClient(int id) {
		// TODO Auto-generated method stub
		String sql="delete from clients where id= ?";
		try {
			PreparedStatement ps= DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
				ps.setInt(1, id);
				ps.execute();
			
			
		}catch(SQLException e) {
			e.getStackTrace();
		}
	}

	@Override
	public void updateClient(Client c) {
		// TODO Auto-generated method stub
		String sql = "UPDATE clients set nom=?,prenom=?,titre=?,version=? where id=?";
		try {
			PreparedStatement ps = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
			ps.setString(1, c.getNom());
			ps.setString(2, c.getPrenom());
			ps.setString(3, c.getTitre());
			ps.setInt(4, c.getVersion());
			ps.setInt(5, c.getId());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Client getClient(int id) {
		// TODO Auto-generated method stub
		Client m = null;
		String sql = "Select * from clients where id= ?";
		try {
			PreparedStatement ps= DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
				ps.setInt(1, id);
				ResultSet res = ps.executeQuery();
				if(res.next()) {
					m = new Client(id,res.getString("nom"),res.getString("prenom"),res.getString("titre"),res.getInt("version"));
				}
			
		}catch(SQLException e) {
			System.out.println(e.getStackTrace());
		}
		// TODO Auto-generated method stub
		return m;
	}

	@Override
	public List<Client> getClients() {
		// TODO Auto-generated method stub
		String sql = "Select * from clients";
		List<Client> lp= new ArrayList<>();
		
		try {
			PreparedStatement ps= DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
				ResultSet res = ps.executeQuery();
				while(res.next()) {
					Client m = new Client(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getInt(5));
				}
			
		}catch(SQLException e) {
			System.out.println(e.getStackTrace());
		}
		// TODO Auto-generated method stub
		return lp;
		
	}

}
