package alura.com.br.agenda;

import android.app.Application;

import alura.com.br.agenda.dao.AlunoDao;
import alura.com.br.agenda.model.Aluno;

public class AgendaApplication extends Application {

    private final AlunoDao dao = new AlunoDao();

    @Override
    public void onCreate() {
        super.onCreate();
        criaAlunosDeTeste();
    }

    private void criaAlunosDeTeste() {
        dao.salva(new Aluno("Edu", "123", "edu@edu.com"));
        dao.salva(new Aluno("Edu2", "222", "222@teste2.com"));
    }
}
