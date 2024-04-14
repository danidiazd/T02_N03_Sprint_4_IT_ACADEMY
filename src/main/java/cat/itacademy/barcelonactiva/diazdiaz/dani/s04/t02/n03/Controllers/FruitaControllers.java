package cat.itacademy.barcelonactiva.diazdiaz.dani.s04.t02.n03.Controllers;

import cat.itacademy.barcelonactiva.diazdiaz.dani.s04.t02.n03.model.domain.Fruita;
import cat.itacademy.barcelonactiva.diazdiaz.dani.s04.t02.n03.model.services.FruitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruita")
public class FruitaControllers {

    @Autowired
    private FruitaService fruitaService;


    @PostMapping("/add")
    public ResponseEntity<Fruita> createFruita(@RequestBody Fruita fruita) {
        return ResponseEntity.ok().body(this.fruitaService.createFruita(fruita));
    }

    @PutMapping("/update")
    public ResponseEntity<Fruita> updateFruita(@RequestBody Fruita fruita) {
        return ResponseEntity.ok().body(this.fruitaService.updateFruita(fruita));
    }

    @DeleteMapping("/delete{id}")
    public ResponseEntity<Fruita> deleteFruita(@PathVariable("id") String id) {

        if (fruitaService.deleteFruita(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/getOne")
    public ResponseEntity<Fruita> getOneFruita(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(this.fruitaService.getOne(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruita>> getAllFruita() {
        return ResponseEntity.ok().body(this.fruitaService.getAll());
    }
}
