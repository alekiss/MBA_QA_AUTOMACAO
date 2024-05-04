package teste;

import com.github.javafaker.Faker;
import entidades.Usuario;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class UsuarioTest {
    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = "https://serverest.dev/";
    }

    @Test
    public void criarUsuarioComSucesso(){
        Usuario user = geradorUser();
        RestAssured
                .given().contentType(ContentType.JSON).log().all()
                .when()
                .body(user)
                .post("usuarios")
                .then()
                .statusCode(201).log().all();
    }

    public Usuario geradorUser(){
        Faker faker = new Faker();
        Usuario user = new Usuario();
        user.setNome(faker.name().fullName());
        user.setEmail(faker.internet().emailAddress());
        user.setPassword("teste@123");
        user.setAdministrador("true");
        return user;
    }
}
