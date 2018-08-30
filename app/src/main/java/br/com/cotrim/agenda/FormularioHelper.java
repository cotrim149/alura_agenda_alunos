package br.com.cotrim.agenda;

import android.app.Activity;
import android.widget.EditText;
import android.widget.RatingBar;

import br.com.cotrim.agenda.modelo.Aluno;

public class FormularioHelper {

    private Activity activity;

    private Aluno aluno;

    public FormularioHelper(FormularioActivity activity) {
        this.activity = activity;
        aluno = new Aluno();
    }

    private String getStringFromEditTextId(int id) {
        EditText editText = this.activity.findViewById(id);
        return editText.getText().toString();
    }

    private void setValueToEditTextOfId(int id, String value) {
        EditText editText = this.activity.findViewById(id);
        editText.setText(value);
    }

    public Aluno getAluno() {
        String nome = this.getStringFromEditTextId(R.id.formulario_nome);
        String endereco = this.getStringFromEditTextId(R.id.formulario_endereco);
        String telefone = this.getStringFromEditTextId(R.id.formulario_telefone);
        String site = this.getStringFromEditTextId(R.id.formulario_site);

        RatingBar campoNota = activity.findViewById(R.id.formulario_note);

        aluno.setNome(nome);
        aluno.setEndereco(endereco);
        aluno.setTelefone(telefone);
        aluno.setSite(site);
        aluno.setNota(Double.valueOf(campoNota.getProgress()));

        return aluno;
    }

    public void preencheFormulario(Aluno aluno) {
        setValueToEditTextOfId(R.id.formulario_nome, aluno.getNome());
        setValueToEditTextOfId(R.id.formulario_endereco, aluno.getEndereco());
        setValueToEditTextOfId(R.id.formulario_telefone, aluno.getTelefone());
        setValueToEditTextOfId(R.id.formulario_site, aluno.getSite());

        RatingBar campoNota = activity.findViewById(R.id.formulario_note);
        campoNota.setProgress(aluno.getNota().intValue());

        this.aluno = aluno;
    }
}
