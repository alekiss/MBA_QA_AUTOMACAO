import org.junit.jupiter.api.*;

public class TestJunit {

    @BeforeAll
    public static void beforeAll(){
        System.out.println("before all");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("after all");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("before all");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("before each");
    }
    @Test
    public void teste01(){
        Calculadora calc = new Calculadora();
        int soma = calc.soma(4,5);
        Assertions.assertEquals(9, soma);
        System.out.println("Executou o teste01");
    }

    @Test
    public void teste02(){
        Calculadora calc = new Calculadora();
        int soma = calc.soma(5,5);
        Assertions.assertEquals(10, soma);
        System.out.println("Executou o teste02");
    }
}
