package dao;
import model.Disciplina;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDAO {
    private List<Disciplina> disciplinas;

    public DisciplinaDAO() {
        this.disciplinas = new ArrayList<>();
        disciplinas.add(new Disciplina(1, "Programação de Sistemas II", "PSII", "Sistemas de Informação", 3));
        disciplinas.add(new Disciplina(1, "Estrutura de Dados", "ED", "Sistemas de Informação", 3));
        disciplinas.add(new Disciplina(1, "Fatores Humanos em Sistemas Computacionais", "FHSC", "Sistemas de Informação", 4));
    }

    public Disciplina create(Disciplina disciplina) {
        long maxId = 0;
        for (Disciplina d : disciplinas) {
            if (d.getId() > maxId) {
                maxId = d.getId();
            }
        }
        disciplina.setId(maxId + 1);
        disciplinas.add(disciplina);
        return disciplina;
    }

    public List<Disciplina> findAll() {
        return disciplinas;
    }

    public Disciplina findById(long id) {
        for (Disciplina d : disciplinas) {
            if (d.getId() == id) {
                return d;
            }
        }
        return null;
    }

    public void update(Disciplina disciplina) {
        for (int i = 0; i < disciplinas.size(); i++) {
            if (disciplinas.get(i).getId() == disciplina.getId()) {
                disciplinas.set(i, disciplina);
                return;
            }
        }
    }

    public void deleteById(long id) {
        disciplinas.removeIf(d -> d.getId() == id);
    }
}