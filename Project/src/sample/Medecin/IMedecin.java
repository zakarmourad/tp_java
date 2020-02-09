package sample.Medecin;

import java.util.List;

public interface IMedecin {
void addMedecin(Medecin m);
void deleteMedecin(int id);
void updateMedecin(Medecin m);
Medecin getMedecin(int id);
List<Medecin> getMedecins();
}
