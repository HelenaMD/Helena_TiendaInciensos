package es.rf.tienda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import es.rf.tienda.objetos.repository.ICategoriaRepo;


@SpringBootApplication()
@EnableJpaRepositories("es.rf.tienda")
public class S4TiendaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(S4TiendaSpringApplication.class, args);
	}
//exclude = {DataSourceAutoConfiguration.class}
}
