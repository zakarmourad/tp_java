package sample.Medecin;

public class Medecin {
 private String nom;
 private String prenom;
 private String titre;
 private int id;
 private int version;
 
 
 public Medecin( int id,String nom, String prenom, String titre, int version) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.titre = titre;
		this.id = id;
		this.version = version;
	}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getVersion() {
	return version;
}
public void setVersion(int version) {
	this.version = version;
}

}
