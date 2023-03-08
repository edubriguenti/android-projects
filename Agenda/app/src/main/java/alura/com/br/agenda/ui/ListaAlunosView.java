package alura.com.br.agenda.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import alura.com.br.agenda.dao.AlunoDao;
import alura.com.br.agenda.model.Aluno;
import alura.com.br.agenda.ui.adapter.ListaAlunosAdapter;

public class ListaAlunosView {

    private final AlunoDao dao;
    private final ListaAlunosAdapter adapter;
    private final Context context;

    public ListaAlunosView(Context context) {
        this.context = context;
        adapter = new ListaAlunosAdapter(context);
        dao = new AlunoDao();
    }

    public void configuraAlertDialog(MenuItem menuItem) {
        AlertDialog dialog = new AlertDialog
                .Builder(context)
                .setTitle("Removendo aluno")
                .setMessage("Tem certeza que quer remover o aluno?")
                .setPositiveButton("Sim", (dialog1, which) -> {
                    AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo();
                    Aluno aluno = adapter.getItem(menuInfo.position);
                    remove(aluno);
                })
                .setNegativeButton("Não", null)
                .create();
        dialog.show();
    }

    public void atualizaAlunos() {
        adapter.atualiza(dao.todos());
    }

    private void remove(Aluno aluno) {
        dao.remove(aluno);
        adapter.remove(aluno);
    }

    public void configuraAdapter(ListView listaDeAlunos) {
        listaDeAlunos.setAdapter(adapter);
    }
}
