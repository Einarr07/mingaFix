package com.mingaFix.mingaFix.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "API de Reportes - MingaFix",
                version = "1.0",
                description = "API para la gestión de reportes en el sistema MingaFix 🚀\n\n" +
                        "Desarrollada en **Spring Boot** por **Mateo Congo & Miguel Carapaz.**",
                contact = @Contact(
                        name = "Mateo Congo",
                        email = "mateo-sebas_11@outlook.com",
                        url = "https://github.com/Einarr07"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0"
                )
        )
)
public class SwaggerConfig {
}
