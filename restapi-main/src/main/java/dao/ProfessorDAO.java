package dao;
import model.Professor;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {
    private List<Professor> professores;

    public ProfessorDAO() {
        this.professores = new ArrayList<>();
        professores.add(new Professor(1, "Ana", 1111, "Segurança"));
        professores.add(new Professor(2, "Bob", 2222, "Biologia"));
        professores.add(new Professor(3, "Charles", 3333, "Economia"));
    }

    public Professor create(Professor professor) {
        long maxId = 0;
        for (Professor p : professores) {
            if (p.getId() > maxId) {
                maxId = p.getId();
            }
        }
        professor.setId(maxId + 1);
        professores.add(professor);
        return professor;
    }

    public List<Professor> listarProfessores() {
        return professores;
    }

    public Professor buscarPorId(long id) {
        for (Professor p : professores) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void atualizar(Professor professor) {
        for (int i = 0; i < professores.size(); i++) {
            if (professores.get(i).getId() == professor.getId()) {
                professores.set(i, professor);
                return;
            }
        }
    }

    public void deleteById(long id) {
        professores.removeIf(p -> p.getId() == id);
    }
}