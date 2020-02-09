package gcm;

import java.util.List;

public interface IRv {
	
	void addRv(Rv r);
	void deleteRv(int id);
	void updateRv(Rv c);
	Rv getRv(int id);
	List<Rv> getRvs();
}
