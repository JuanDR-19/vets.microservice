package pawprints.micro.vets.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pawprints.micro.vets.Entity.Vets;
import pawprints.micro.vets.Repository.VetRepository;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@Service
public class VetService {
    @Autowired
    VetRepository Repo;

    public void Put (Vets u ){
        Repo.save(u);
    }
    public void Delete(Integer id) throws ExecutionException, InterruptedException {
        if (Repo.existsById(id)){
            Repo.deleteById(id);
        }
    }

    public ArrayList<Vets> SearchAll() throws ExecutionException, InterruptedException {
        return (ArrayList<Vets>) Repo.findAll();
    }
}
