package pawprints.micro.vets.Entity;
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;


@Entity
@Data
public class Vets implements Serializable{

        private String name_vet;
        private String location;
        private String email;

}


