package controllers;
import model.Professor;
import dao.ProfessorDAO;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;

@RestController
class ProfessorController {

    private ProfessorDAO professorDAO;

    public ProfessorController() {
        this.professorDAO = new ProfessorDAO();
    }

    @GetMapping("/api/professores")
    Iterable<Professor> getProfessores() {
        return professorDAO.listarProfessores();
    }

    @GetMapping("/api/professores/{id}")
    Optional<Professor> getProfessor(@PathVariable long id) {
        return Optional.ofNullable(professorDAO.buscarPorId(id));
    }

    @PostMapping("/api/professores")
    Professor createProfessor(@RequestBody Professor p) {
        return professorDAO.create(p);
    }

    @PutMapping("/api/professores/{professorId}")
    Optional<Professor> updateProfessor(@RequestBody Professor professorRequest, @PathVariable long professorId) {
        Optional<Professor> existingProfessor = Optional.ofNullable(professorDAO.buscarPorId(professorId));
        if (existingProfessor.isPresent()) {
            Professor professor = existingProfessor.get();
            professor.setNome(professorRequest.getNome());
            professor.setMatricula(professorRequest.getMatricula());
            professor.setArea(professorRequest.getArea());
            professorDAO.atualizar(professor);
        }
        return existingProfessor;
    }

    @DeleteMapping("/api/professores/{id}")
    void deleteProfessor(@PathVariable long id) {
        professorDAO.deleteById(id);
    }
}