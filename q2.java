import java.util.*;
import java.time.*;

class Empresa {
    private String nome;
    private String CNPJ;
    private Departamento dep[] = new Departamento[10];

    public Empresa(String n, String cnpj) {
        this.nome = n;
        this.CNPJ = cnpj;
    }

    public void CriarDepartamento(String nome) {
        int i;
        for (i = 0; i <= 9; i++) {
            if (dep[i] == null) {
                dep[i] = new Departamento(nome);
                i = 11;
            }
        }
        if (i == 10) {
            System.out.println("Número máximo de departamentos cadastrados");
        }
    }

    public void AdFuncionario(String n, String nome, double s, Date data) {
        for (int i = 0; i <= 9; i++) {
            if (dep[i].getNome() == n) {
                dep[i].AdicionarFuncionario(nome, s, data);
            }
        }
    }
}

class Departamento {
    private String nome;
    private Funcionario func[] = new Funcionario[100];

    public Departamento(String n) {
        this.nome = n;
    }

    public String getNome() {
        return nome;
    }

    public void AdicionarFuncionario(String n, double s, Date data) {
        int i;
        for (i = 0; i <= 100; i++) {
            if (func[i] == null) {
                func[i] = new Funcionario(n, s, data);
                i = 102;
            }
        }
        if (i == 102) {
            System.out.println("Número máximo de funcionário já batido");
        }
    }
}

class Funcionario {
    private String nome;
    private double salario;
    private Date dataEmissao;

    public Funcionario(String nome, double salario, Date data) {
        this.nome = nome;
        this.salario = salario;
        this.dataEmissao = data;
    }
}

public class q2 {
    public static void main(String args[]) {
        Empresa apple = new Empresa("aaaa", "111.111.111");
        apple.CriarDepartamento("TI");
        apple.CriarDepartamento("RH");
        apple.AdFuncionario("TI", "Manuella", 1500, new Date());
        apple.AdFuncionario("RH", "Anelyse", 10000, new Date());
    }
}