package controllers;
import model.Disciplina;
import dao.DisciplinaDAO;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;

@RestController
class DisciplinaController {

    private DisciplinaDAO disciplinaDAO;

    public DisciplinaController() {
        this.disciplinaDAO = new DisciplinaDAO();
    }

    @GetMapping("/api/disciplinas")
    Iterable<Disciplina> getDisciplinas() {
        return disciplinaDAO.findAll();
    }

    @GetMapping("/api/disciplinas/{id}")
    Optional<Disciplina> getDisciplina(@PathVariable long id) {
        return Optional.ofNullable(disciplinaDAO.findById(id));
    }

    @PostMapping("/api/disciplinas")
    Disciplina createDisciplina(@RequestBody Disciplina d) {
        return disciplinaDAO.create(d);
    }

    @PutMapping("/api/disciplinas/{disciplinaId}")
    Optional<Disciplina> updateDisciplina(@RequestBody Disciplina disciplinaRequest, @PathVariable long disciplinaId) {
        Optional<Disciplina> existingDisciplina = Optional.ofNullable(disciplinaDAO.findById(disciplinaId));
        if (existingDisciplina.isPresent()) {
            Disciplina disciplina = existingDisciplina.get();
            disciplina.setNome(disciplinaRequest.getNome());
            disciplina.setSigla(disciplinaRequest.getSigla());
            disciplina.setCurso(disciplinaRequest.getCurso());
            disciplina.setSemestre(disciplinaRequest.getSemestre());
            disciplinaDAO.update(disciplina);
        }
        return existingDisciplina;
    }

    @DeleteMapping("/api/disciplinas/{id}")
    void deleteDisciplina(@PathVariable long id) {
        disciplinaDAO.deleteById(id);
    }
}