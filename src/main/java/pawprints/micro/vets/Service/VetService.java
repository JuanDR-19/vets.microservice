package pawprints.micro.vets.Service;

import com.google.api.gax.rpc.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pawprints.micro.vets.Entity.Vets;
import pawprints.micro.vets.Repository.VetRepository;

import java.util.ArrayList;
import java.util.Optional;
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

    public Vets SearchByID(Integer id) {
        try {
            Optional<Vets> vetOptional = Repo.findById(id);
            if (vetOptional.isPresent()) {
                return vetOptional.get();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
