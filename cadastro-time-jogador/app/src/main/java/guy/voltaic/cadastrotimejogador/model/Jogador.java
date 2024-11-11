package guy.voltaic.cadastrotimejogador.model;


/*
 *@author:<Robison>
 *@ra:<1110482313007>
 */
public class Jogador {
    private int id;
    private String nome;
    private String dataNasc;
    private float altura;
    private float peso;
    private String time;

    public Jogador() {}

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

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataNasc=" + dataNasc +
                ", altura=" + altura +
                ", peso=" + peso +
                ", time=" + time +
                '}';
    }
}

