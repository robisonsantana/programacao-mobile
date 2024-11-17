package guy.voltaic.vaccinetracker.model;

/*
 *@author:<Robison>
 *@ra:<1110482313007>
 */
public class Usuario {
    private int id;
    private String nome;
    private String dataNascimento;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuário ID: " + id + "\n" +
                "Nome: " + nome + "\n" +
                "Data de Nascimento: " + dataNascimento + "\n" +
                "Email: " + email + "\n" +
                "------------------------------------------------------------------------------------\n";
    }
}

