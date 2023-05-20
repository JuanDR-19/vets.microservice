package pawprints.micro.vets.Queries;

import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import pawprints.micro.vets.Entity.Vets;
import pawprints.micro.vets.Repository.VetRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Component
public class FbQ implements VetRepository {
    private static final String COLLECTION_NAME = "vets";

    public boolean existsById(Integer id) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        return dbFirestore.collection(COLLECTION_NAME).document(String.valueOf(id)).get().get().exists();
    }

    public void deleteById(Integer id) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        dbFirestore.collection(COLLECTION_NAME).document(String.valueOf(id)).delete();
    }

    public ArrayList<Vets> findAll() throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        List<QueryDocumentSnapshot> documents = dbFirestore.collection(COLLECTION_NAME).get().get().getDocuments();
        ArrayList<Vets> vetsList = new ArrayList<>();
        for (QueryDocumentSnapshot document : documents) {
            Vets vet = document.toObject(Vets.class);
            vetsList.add(vet);
        }
        return vetsList;
    }

    public void save(Vets vet) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        dbFirestore.collection(COLLECTION_NAME).add(vet);
        System.out.println("Se agregó un nuevo dato a la colección");
    }


}
