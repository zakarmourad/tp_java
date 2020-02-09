package sample.rv;

import sample.Medecin.Medecin;

import java.util.List;

public interface DoaRV {

    void addCreneau(Creneau c);
    void updateCreneau(Creneau c);
    void deleteCreneau(int id);
    Creneau getCreneau(int id);
    List<Creneau> getCreneaux();
}
