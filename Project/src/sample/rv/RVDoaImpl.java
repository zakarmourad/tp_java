package sample.rv;

import sample.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RVDoaImpl implements DoaRV {

    @Override
    public void addCreneau(Creneau c) {
        // TODO Auto-generated method stub
        String sql = "INSERT INTO creneaux(version,hdebut,hfin,mdebut,mfin,medecin_id) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);

            ps.setInt(1, c.getVersion());
            ps.setInt(2, c.getHdebut());
            ps.setInt(3, c.getHfin());
            ps.setInt(4, c.getMdebut());
            ps.setInt(5, c.getMfin());
            ps.setInt(6, c.getMedecin_id());
            ps.executeUpdate();

        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCreneau(Creneau c) {
        // TODO Auto-generated method stub
        String sql = "UPDATE creneaux set version=?,hdebut=?,hfin=?,mdebut=?,mfin=?,medecin_id=? where id=?";
        try {
            PreparedStatement ps = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            ps.setInt(1, c.getVersion());
            ps.setInt(2, c.getHdebut());
            ps.setInt(3, c.getHfin());
            ps.setInt(4, c.getMdebut());
            ps.setInt(5, c.getMfin());
            ps.setInt(6, c.getMedecin_id());
            ps.setInt(6, c.getId());

            ps.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCreneau(int id) {
        // TODO Auto-generated method stub
        String sql="delete from creneaux where id= ?";
        try {
            PreparedStatement ps= DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();


        }catch(SQLException e) {
            e.getStackTrace();
        }
    }

    @Override
    public Creneau getCreneau(int id) {
        // TODO Auto-generated method stub
        Creneau m = null;
        String sql = "Select * from creneaux where id= ?";
        try {
            PreparedStatement ps= DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet res = ps.executeQuery();
            if(res.next()) {
                m = new Creneau(id,res.getInt("medecin_id"),res.getInt("hdebut"),res.getInt("hfin"),res.getInt("mdebut"),res.getInt("mfin"),res.getInt("version"));
            }

        }catch(SQLException e) {
            System.out.println(e.getStackTrace());
        }
        // TODO Auto-generated method stub
        return m;
    }

    @Override
    public List<Creneau> getCreneaux() {
        // TODO Auto-generated method stub
        String sql = "Select * from creneaux";
        List<Creneau> lp= new ArrayList<>();

        try {
            PreparedStatement ps= DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while(res.next()) {
                Creneau m = new Creneau(res.getInt(1),res.getInt(2),res.getInt(3),res.getInt(4),res.getInt(5),res.getInt(6),res.getInt(7));
            }

        }catch(SQLException e) {
            System.out.println(e.getStackTrace());
        }
        // TODO Auto-generated method stub
        return lp;

    }
}
