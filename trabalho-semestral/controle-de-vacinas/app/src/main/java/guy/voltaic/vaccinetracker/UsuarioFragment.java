package guy.voltaic.vaccinetracker;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.List;

import guy.voltaic.vaccinetracker.controller.UsuarioController;
import guy.voltaic.vaccinetracker.model.Usuario;
import guy.voltaic.vaccinetracker.persistence.DatabaseHelper;
import guy.voltaic.vaccinetracker.persistence.UsuarioDao;

/*
 *@author:<Robison>
 *@ra:<1110482313007>
 */
public class UsuarioFragment extends Fragment {

    private EditText edtId, edtNome, edtDataNascimento, edtEmail;
    private TextView txtResultados;
    private Button btnCadastrar, btnAtualizar, btnDeletar, btnProcurar, btnListar;
    private UsuarioController usuarioController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_usuario, container, false);

        edtId = view.findViewById(R.id.edtId);
        edtNome = view.findViewById(R.id.edtNome);
        edtDataNascimento = view.findViewById(R.id.edtDataNascimento);
        edtEmail = view.findViewById(R.id.edtEmail);

        txtResultados = view.findViewById(R.id.txtResultados);

        btnCadastrar = view.findViewById(R.id.btnCadastrar);
        btnAtualizar = view.findViewById(R.id.btnAtualizar);
        btnDeletar = view.findViewById(R.id.btnDeletar);
        btnProcurar = view.findViewById(R.id.btnProcurar);
        btnListar = view.findViewById(R.id.btnListar);

        DatabaseHelper dbHelper = new DatabaseHelper(getContext());
        usuarioController = new UsuarioController(new UsuarioDao(dbHelper.getWritableDatabase()));

        btnCadastrar.setOnClickListener(op -> cadastrarUsuario());
        btnAtualizar.setOnClickListener(op -> atualizarUsuario());
        btnDeletar.setOnClickListener(op -> deletarUsuario());
        btnProcurar.setOnClickListener(op -> procurarUsuario());
        btnListar.setOnClickListener(op -> listarUsuarios());

        return view;
    }

    private void cadastrarUsuario() {
        try {
            String nome = edtNome.getText().toString();
            String dataNascimento = edtDataNascimento.getText().toString();
            String email = edtEmail.getText().toString();

            if (TextUtils.isEmpty(nome) || TextUtils.isEmpty(dataNascimento) || TextUtils.isEmpty(email)) {
                Toast.makeText(getContext(), "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                return;
            }

            Usuario usuario = new Usuario();
            usuario.setNome(nome);
            usuario.setDataNascimento(dataNascimento);
            usuario.setEmail(email);

            usuarioController.inserirUsuario(usuario);
            Toast.makeText(getContext(), "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
            limparCampos();
        } catch (Exception e) {
            Toast.makeText(getContext(), "Erro ao cadastrar usuário: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void atualizarUsuario() {
        try {
            int id = Integer.parseInt(edtId.getText().toString());
            Usuario usuario = usuarioController.procurarUsuarioPorId(id);
            if (usuario == null) {
                Toast.makeText(getContext(), "Usuário não encontrado!", Toast.LENGTH_SHORT).show();
                return;
            }

            usuario.setNome(edtNome.getText().toString());
            usuario.setDataNascimento(edtDataNascimento.getText().toString());
            usuario.setEmail(edtEmail.getText().toString());

            usuarioController.atualizarUsuario(usuario);
            Toast.makeText(getContext(), "Usuário atualizado com sucesso!", Toast.LENGTH_SHORT).show();
            limparCampos();
        } catch (Exception e) {
            Toast.makeText(getContext(), "Erro ao atualizar usuário: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void deletarUsuario() {
        try {
            int id = Integer.parseInt(edtId.getText().toString());
            Usuario usuario = usuarioController.procurarUsuarioPorId(id);
            if (usuario == null) {
                Toast.makeText(getContext(), "Usuário não encontrado!", Toast.LENGTH_SHORT).show();
                return;
            }

            usuarioController.deletarUsuario(usuario);
            Toast.makeText(getContext(), "Usuário deletado com sucesso!", Toast.LENGTH_SHORT).show();
            limparCampos();
        } catch (Exception e) {
            Toast.makeText(getContext(), "Erro ao deletar usuário: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void procurarUsuario() {
        try {
            int id = Integer.parseInt(edtId.getText().toString());
            Usuario usuario = usuarioController.procurarUsuarioPorId(id);
            if (usuario == null) {
                txtResultados.setText("Usuário não encontrado!");
            } else {
                txtResultados.setText(usuario.toString());
            }
        } catch (Exception e) {
            Toast.makeText(getContext(), "Erro ao procurar usuário: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void listarUsuarios() {
        try {
            List<Usuario> usuarios = usuarioController.procurarTodosUsuarios();
            StringBuilder resultado = new StringBuilder();
            for (Usuario usuario : usuarios) {
                resultado.append(usuario).append("\n");
            }
            txtResultados.setText(resultado.toString());
        } catch (Exception e) {
            Toast.makeText(getContext(), "Erro ao listar usuários: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void limparCampos() {
        edtId.setText("");
        edtNome.setText("");
        edtDataNascimento.setText("");
        edtEmail.setText("");
    }
}
