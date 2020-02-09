package sample.Medecin;

public interface IClient {
	void addClient(Client c);
	void deleteClient(int id);
	void updateClient(Client c);
	Client getClient(int id);
	List<Client> getClients();
}
