package org.example.seniorplus.config;

import org.example.seniorplus.domain.*;
import org.example.seniorplus.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

@Configuration
public class Instancias implements CommandLineRunner {

    @Autowired
    private IdosoRepository idosoRepository;

    @Autowired
    private CuidadorRepository cuidadorRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    @Autowired
    private ImagemRepository imagemRepository;

    @Autowired
    private ExercicioRepository exercicioRepository;

    @Autowired
    private ExameMedicoRepository exameMedicoRepository;

    @Autowired
    private DietaRepository dietaRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // Limpa os dados anteriores
        enderecoRepository.deleteAll();
        cuidadorRepository.deleteAll();
        idosoRepository.deleteAll();

        // IDOSOS
        Idoso i1 = new Idoso("11111111111", "RG1", "Maria Silva", "maria@gmail.com", sdf.parse("12/03/1945"),
                "1199999991", 60.0, 1.6, "O+", "usa bengala", "Hipertensão");

        Idoso i2 = new Idoso("22222222222", "RG2", "João Souza", "joao@gmail.com", sdf.parse("20/05/1948"),
                "1199999992", 75.0, 1.7, "A-", "", "Diabetes");

        Idoso i3 = new Idoso("33333333333", "RG3", "Ana Lima", "ana@gmail.com", sdf.parse("01/01/1950"),
                "1199999993", 65.0, 1.65, "B+", "", "");

        Idoso i4 = new Idoso("44444444444", "RG4", "Carlos Mendes", "carlos@gmail.com", sdf.parse("10/07/1955"),
                "1199999994", 80.0, 1.75, "AB-", "", "Alzheimer");

        Idoso i5 = new Idoso("55555555555", "RG5", "Helena Rocha", "helena@gmail.com", sdf.parse("15/09/1942"),
                "1199999995", 50.0, 1.55, "O-", "", "Osteoporose");

        idosoRepository.saveAll(Arrays.asList(i1, i2, i3, i4, i5));

        // CUIDADORES
        Cuidador c1 = new Cuidador(i3.getCpf(), "RG9", "Clara Martins", "clara@gmail.com", sdf.parse("10/08/1980"), "1198888881");
        Cuidador c2 = new Cuidador("88888888888", "RG8", "Pedro Alves", "pedro@gmail.com", sdf.parse("05/06/1975"), "1198888882");
        Cuidador c3 = new Cuidador("77777777777", "RG7", "Luciana Costa", "luciana@gmail.com", sdf.parse("22/11/1990"), "1198888883");

        cuidadorRepository.saveAll(Arrays.asList(c1, c2, c3));

        // ENDEREÇOS DOS IDOSOS
        Endereco e1 = new Endereco("11111111111", "Rua Alpha", 10, "Centro", "São Paulo", "SP", 11111111, "Apto 1");
        Endereco e2 = new Endereco("22222222222", "Rua Beta", 20, "Jardins", "Osasco", "SP", 22222222, "Casa");
        Endereco e3 = new Endereco("33333333333", "Rua Gama", 30, "Vila Nova", "Barueri", "SP", 33333333, "Fundos");
        Endereco e4 = new Endereco("44444444444", "Rua Delta", 40, "Granja", "Cotia", "SP", 44444444, "Casa 2");
        Endereco e5 = new Endereco("55555555555", "Rua dos Idosos", 50, "Bairro Feliz", "São Paulo", "SP", 55555555, "Apto 2");

        // ENDEREÇOS DOS CUIDADORES
        Endereco e6 = new Endereco("99999999999", "Rua dos Cuidadores", 60, "Jardim Cuida Bem", "São Paulo", "SP", 66666666, "Apto 101");
        Endereco e7 = new Endereco("88888888888", "Av. Saúde", 70, "Vila Cuidadora", "Osasco", "SP", 77777777, "Casa 5");
        Endereco e8 = new Endereco("77777777777", "Travessa Cuidado", 80, "Jardim Esperança", "Barueri", "SP", 88888888, "Bloco B, Apto 3");

        // Salva todos os endereços
        enderecoRepository.saveAll(Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8));

        medicamentoRepository.saveAll(List.of(
                new Medicamento("11111111111", "Losartana", "50mg", "Oral", "Tomar após o café da manhã",
                        LocalDate.now(), LocalDate.of(2025, 12, 31), List.of(LocalTime.now()),
                        true, 1, "Maria Silva", "1199999991", true, true, false,1)
        ));

        imagemRepository.saveAll(List.of(
                new Imagem("img001", "11111111111", "exame1.jpg", "https://exemplo.com/imagens/exame1.jpg", "imagem/jpeg", LocalDateTime.now()),
                new Imagem("img002", "22222222222", "perfil.png", "https://exemplo.com/imagens/perfil.png", "imagem/png", LocalDateTime.now()),
                new Imagem("img003", "33333333333", "vacina.pdf", "https://exemplo.com/docs/vacina.pdf", "application/pdf", LocalDateTime.now()),
                new Imagem("img004", "44444444444", "rx_torax.jpeg", "https://exemplo.com/imagens/rx_torax.jpeg", "imagem/jpeg", LocalDateTime.now()),
                new Imagem("img005", "55555555555", "cartao_sus.png", "https://exemplo.com/imagens/cartao_sus.png", "imagem/png", LocalDateTime.now())
        ));
        exercicioRepository.saveAll(List.of(
                new Exercicio("11111111111", "Caminhada", "30 minutos no parque", LocalDate.of(2025, 5, 10), 30, "moderada", "Sem desconforto."),
                new Exercicio("22222222222", "Yoga", "Sessão de alongamento", LocalDate.of(2025, 5, 12), 45, "leve", "Melhora na flexibilidade."),
                new Exercicio("33333333333", "Musculação", "Treino superior", LocalDate.of(2025, 5, 14), 60, "intensa", "Evitar sobrecarga no ombro."),
                new Exercicio("44444444444", "Ciclismo", "Pedalada na ciclovia", LocalDate.of(2025, 5, 11), 50, "moderada", "Leve dor nas pernas."),
                new Exercicio("55555555555", "Pilates", "Aula com bola e elástico", LocalDate.of(2025, 5, 13), 40, "moderada", "Boa postura durante o exercício.")
        ));
        exameMedicoRepository.saveAll(List.of(
                new ExameMedico("11111111111", "Hemograma", "Tudo normal", LocalDate.of(2025, 4, 20), "Laboratório Vida", "Paciente saudável."),
                new ExameMedico("22222222222", "Raio-X", "Sem fraturas", LocalDate.of(2025, 4, 22), "Clínica São Lucas", "Dor muscular apenas."),
                new ExameMedico("33333333333", "Eletrocardiograma", "Arritmia leve", LocalDate.of(2025, 4, 25), "Hospital Coração Feliz", "Acompanhamento necessário."),
                new ExameMedico("44444444444", "Ultrassom Abdominal", "Vesícula com cálculo", LocalDate.of(2025, 4, 26), "Centro Médico São Paulo", "Encaminhado para cirurgia."),
                new ExameMedico("55555555555", "Exame de Urina", "Infecção detectada", LocalDate.of(2025, 4, 28), "Laboratório Mais Saúde", "Receitado antibiótico.")
        ));
        imagemRepository.saveAll(List.of(
                new Imagem("img001", "11111111111", "dieta_joao.jpg", "http://exemplo.com/dieta_joao.jpg", "image/jpeg", LocalDateTime.of(2025, 4, 1, 10, 30)),
                new Imagem("img002", "22222222222", "dieta_maria.png", "http://exemplo.com/dieta_maria.png", "image/png", LocalDateTime.of(2025, 4, 2, 9, 15)),
                new Imagem("img003", "33333333333", "dieta_carlos.jpg", "http://exemplo.com/dieta_carlos.jpg", "image/jpeg", LocalDateTime.of(2025, 4, 3, 11, 0)),
                new Imagem("img004", "44444444444", "dieta_ana.png", "http://exemplo.com/dieta_ana.png", "image/png", LocalDateTime.of(2025, 4, 4, 14, 45)),
                new Imagem("img005", "55555555555", "dieta_paulo.jpg", "http://exemplo.com/dieta_paulo.jpg", "image/jpeg", LocalDateTime.of(2025, 4, 5, 16, 20))
        ));
        dietaRepository.saveAll(List.of(
                new Dieta("11111111111", "João Silva", "Dieta para controle de diabetes", LocalDate.of(2025, 1, 1), LocalDate.of(2025, 3, 1), "Açúcar, massas", "Ingerir frutas com moderação", 4, "3h",
                        "Café com leite e pão integral", "Fruta", "Arroz, feijão e frango grelhado", "Iogurte natural", "", ""),
                new Dieta("22222222222", "Maria Oliveira", "Dieta para emagrecimento", LocalDate.of(2025, 2, 1), LocalDate.of(2025, 4, 1), "Gorduras, frituras", "Beber bastante água", 5, "2h",
                        "Suco detox", "Ovo cozido com pão integral", "Peito de frango e salada", "Mix de castanhas", "Sopa leve", ""),
                new Dieta("33333333333", "Carlos Souza", "Dieta para ganho de massa", LocalDate.of(2025, 1, 15), LocalDate.of(2025, 5, 15), "Nenhuma", "Consumir proteínas", 6, "2h",
                        "Ovos mexidos e aveia", "Whey protein", "Carne vermelha com arroz integral", "Banana com pasta de amendoim", "Peito de frango e batata doce", "Iogurte com granola"),
                new Dieta("44444444444", "Ana Lima", "Dieta vegetariana", LocalDate.of(2025, 3, 1), LocalDate.of(2025, 6, 1), "Carne animal", "Evitar industrializados", 4, "4h",
                        "Vitamina de frutas", "Tapioca com queijo branco", "Arroz, feijão e legumes", "Salada com grão-de-bico", "", ""),
                new Dieta("55555555555", "Paulo Mendes", "Dieta para colesterol alto", LocalDate.of(2025, 2, 10), LocalDate.of(2025, 5, 10), "Frituras, embutidos", "Atividade física diária", 3, "5h",
                        "Mamão com aveia", "Sopa de legumes", "Peixe grelhado com arroz integral", "", "", "")
        ));
    }
}
