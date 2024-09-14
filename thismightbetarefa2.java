import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeParseException;

class Tarefa {
    private String titulo;
    private String descricao;
    private String prazo;
    private int prioridade;

    private boolean isPrazoValido(String prazo) {
        try {
            LocalDate.parse(prazo);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    private boolean isPrioridadeValida(int prioridade) {
        return prioridade >= 1 && prioridade <= 5;
    }

    public Tarefa(String titulo, String descricao, String prazo, int prioridade) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.prazo = prazo;
        if (isPrioridadeValida(prioridade)) {
            this.prioridade = prioridade;
        } else {
            this.prioridade = 1;
            System.out.println("Prioridade inválida. Definida como 1 por padrão.");
        }
    }

    public Tarefa(String titulo, String prazo) {
        this.titulo = titulo;
        this.prazo = prazo;
        this.descricao = "";
        this.prioridade = 1;
    }

    public Tarefa(String titulo, int prioridade) {
        this.titulo = titulo;
        this.descricao = "";
        this.prazo = LocalDate.now().toString();
        if (isPrioridadeValida(prioridade)) {
            this.prioridade = prioridade;
        } else {
            this.prioridade = 1;
            System.out.println("Prioridade inválida. Definida como 1 por padrão.");
        }
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPrazo() {
        return this.prazo;
    }

    public void setPrazo(String prazo) {
        if (isPrazoValido(prazo)) {
            this.prazo = prazo;
        } else {
            System.out.println("Data inválida.");
        }
    }

    public void exibirDetalhes() {
        System.out.println("Título: " + this.titulo);
        System.out.println("Descrição: " + this.descricao);
        System.out.println("Prazo: " + this.prazo);
        System.out.println("Prioridade: " + this.prioridade);
    }

    public long calcularDiasRestantes() {
        LocalDate dataPrazo = LocalDate.parse(this.prazo);
        LocalDate hoje = LocalDate.now();

        return ChronoUnit.DAYS.between(hoje, dataPrazo);
    }
}

public class Main {
    public static void main(String[] args) {
        Tarefa tarefa1 = new Tarefa("Estudar POO", "Revisar os conceitos de classes e objetos", "2024-05-15", 1);

        System.out.println("=============== Testando métodos gets ===============");
        System.out.println("Título: " + tarefa1.getTitulo());
        System.out.println("Descrição: " + tarefa1.getDescricao());
        System.out.println();

        System.out.println("=============== Imprimindo com método exibitDetalhes() ===============");
        tarefa1.exibirDetalhes();

        System.out.println("=============== Imprimindo tarefa com o construtor 2 ===============");
        Tarefa tarefa2 = new Tarefa("Estudar para provas", "2050-10-25");
        tarefa2.exibirDetalhes();

        System.out.println("Dias restantes para a tarefa 2: " + tarefa2.calcularDiasRestantes());

        System.out.println("=============== Imprimindo tarefa com o construtor 3 ===============");
        Tarefa tarefa3 = new Tarefa("Ler um livro", 3);
        tarefa3.exibirDetalhes();

        System.out.print("Novo prazo da tarefa 1: ");
        tarefa1.setPrazo("2024-05-15");
    }
}
