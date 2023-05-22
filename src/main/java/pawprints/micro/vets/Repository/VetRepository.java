package pawprints.micro.vets.Repository;


import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import pawprints.micro.vets.Entity.Vets;

import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

public interface VetRepository {
    boolean existsById(Integer id) throws ExecutionException, InterruptedException;
    void deleteById(Integer id);
    ArrayList<Vets> findAll() throws ExecutionException, InterruptedException;
    void save(Vets u);

    Optional<Vets> findById(Integer id) throws ExecutionException, InterruptedException;
}
