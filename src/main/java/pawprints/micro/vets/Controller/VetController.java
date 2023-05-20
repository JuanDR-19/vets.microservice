package pawprints.micro.vets.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pawprints.micro.vets.Entity.Vets;
import pawprints.micro.vets.Service.VetService;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@RestController
public class VetController {
    @Autowired
    VetService vetService;
    @GetMapping(value = "/get_vets", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ArrayList<Vets> getAll() throws ExecutionException, InterruptedException {return vetService.SearchAll();}
    @PostMapping(value = "/new_vet")
    @CrossOrigin("http://localhost:4200")
    public void NewVet(@RequestBody Vets u){
        vetService.Put(u);
    }
    @DeleteMapping(value = "/delete_vet/{id}")
    public void DeleteVet (@PathVariable Integer id) throws ExecutionException, InterruptedException {
        vetService.Delete(id);
    }

}
