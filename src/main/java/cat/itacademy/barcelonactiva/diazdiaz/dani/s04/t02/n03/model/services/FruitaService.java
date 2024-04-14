package cat.itacademy.barcelonactiva.diazdiaz.dani.s04.t02.n03.model.services;

import cat.itacademy.barcelonactiva.diazdiaz.dani.s04.t02.n03.model.domain.Fruita;
import cat.itacademy.barcelonactiva.diazdiaz.dani.s04.t02.n03.model.repository.FruitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitaService {

    @Autowired
    private FruitaRepository fruitaRepository;

    public Fruita createFruita(Fruita fruita) {
        return fruitaRepository.save(fruita);
    }
    public Fruita updateFruita(Fruita fruita) {
        Optional<Fruita> optionalFruita = fruitaRepository.findById(fruita.getId());

        if (optionalFruita.isPresent()) {
            Fruita updateFruita = optionalFruita.get();
            updateFruita.setId(fruita.getId());
            updateFruita.setName(fruita.getName());
            updateFruita.setQuantitatKg(fruita.getQuantitatKg());
            fruitaRepository.save(updateFruita);
            return updateFruita;
        } else {
            throw new RuntimeException("Error al actualizar la fruta");
        }
    }

    public boolean deleteFruita(String id) {
        boolean isDeleted;

        try {
            fruitaRepository.deleteById(id);
            isDeleted = true;
        } catch (Exception e) {
            System.out.println("No se ha podido borrar la fruta");
            isDeleted = false;
        }
        return isDeleted;
    }

    public Fruita getOne(String id) {
        return fruitaRepository.findById(id).orElse(null);
    }

    public List<Fruita> getAll() {
        return fruitaRepository.findAll();
    }
}
