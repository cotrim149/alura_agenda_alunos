package br.com.cotrim.agenda;

import android.app.Activity;
import android.widget.EditText;
import android.widget.RatingBar;

import br.com.cotrim.agenda.modelo.Aluno;

public class FormularioHelper {

    private Activity activity;

    public FormularioHelper(FormularioActivity activity) {
        this.activity = activity;
    }

    private String getStringFromEditTextId(int id) {
        EditText editText = this.activity.findViewById(id);
        return editText.getText().toString();
    }

    public Aluno getAluno() {
        String nome = this.getStringFromEditTextId(R.id.formulario_nome);
        String endereco = this.getStringFromEditTextId(R.id.formulario_endereco);
        String telefone = this.getStringFromEditTextId(R.id.formulario_telefone);
        String site = this.getStringFromEditTextId(R.id.formulario_site);

        RatingBar campoNota = activity.findViewById(R.id.formulario_note);

        Aluno aluno = new Aluno();

        aluno.setNome(nome);
        aluno.setEndereco(endereco);
        aluno.setTelefone(telefone);
        aluno.setSite(site);
        aluno.setNota(Double.valueOf(campoNota.getRating()));

        return aluno;
    }
}
