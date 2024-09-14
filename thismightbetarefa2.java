import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeParseException;

class Tarefa {
    private String titulo;
    private String descricao;
    private String prazo;
    private int prioridade;

    // Método para validar prazo
    private boolean isPrazoValido(String prazo) {
        try {
            LocalDate.parse(prazo);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    // Construtor completo
    public Tarefa(String titulo, String descricao, String prazo, int prioridade) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.setPrazo(prazo); // Usando o setter para validar o prazo
        this.prioridade = prioridade;
    }

    // Construtor com menos parâmetros
    public Tarefa(String titulo, String prazo) {
        this(titulo, "", prazo, 0); // Chamando o construtor completo com valores padrão
    }

    // Métodos getters e setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPrazo() {
        return prazo;
    }

    public void setPrazo(String prazo) {
        if (isPrazoValido(prazo)) {
            this.prazo = prazo;
        } else {
            System.out.println("Data inválida.");
        }
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        // Adicione aqui a lógica para validar a prioridade se necessário
        this.prioridade = prioridade;
    }

    public void exibirDetalhes() {
        System.out.println("Título: " + titulo);
        System.out.println("Descrição: " + descricao);
        System.out.println("Prazo: " + prazo);
        System.out.println("Prioridade: " + prioridade);
    }

    public long calcularDiasRestantes() {
        LocalDate dataPrazo = LocalDate.parse(prazo);
        LocalDate hoje = LocalDate.now();
        return ChronoUnit.DAYS.between(hoje, dataPrazo);
    }
}

public class Main {
    public static void main(String[] args) {
        Tarefa tarefa1 = new Tarefa("Estudar POO", "Revisar os conceitos de classes e objetos", "2024-09-15", 1);
        tarefa1.exibirDetalhes();

        System.out.println("Dias restantes: " + tarefa1.calcularDiasRestantes());

        // Tentando setar um prazo inválido
        tarefa1.setPrazo("2024-15-48");
        tarefa1.exibirDetalhes();
    }
}
