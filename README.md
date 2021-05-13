![](./images/logos_feder.png)

| Entregable     | Procesador de eventos                                        |
| -------------- | ------------------------------------------------------------ |
| Fecha          | 27/04/2021                                                   |
| Revisado por   | Paloma Terán Pérez                                           |
| Proyecto       | [ASIO](https://www.um.es/web/hercules/proyectos/asio) (Arquitectura Semántica e Infraestructura Ontológica) en el marco de la iniciativa [Hércules](https://www.um.es/web/hercules/) para la Semántica de Datos de Investigación de Universidades que forma parte de [CRUE-TIC](https://www.crue.org/proyecto/hercules/) |
| Módulo         | Procesador de eventos                                        |
| Tipo           | Software                                                     |
| Objetivo       | Procesador de eventos del módulo de procesamiento para el proyecto Backend SGI (ASIO). |
| Estado         | **100%** |
| Próximos pasos | Finalizado.                                                  |
| Documentación  | [Manual de usuario](https://github.com/HerculesCRUE/ib-asio-docs-/blob/master/00-An%C3%A1lisis/Manual%20de%20usuario/Manual%20de%20usuario.md)<br />[Manual de despliegue](https://github.com/HerculesCRUE/ib-asio-composeset/blob/master/README.md)<br />[Documentación técnica](https://github.com/HerculesCRUE/ib-asio-docs-/blob/master/00-Arquitectura/arquitectura_semantica/documento_arquitectura/ASIO_Izertis_Arquitectura.md) |

# ASIO - Procesador de eventos

|     | Master |
| --- | ------ |
| Quality Gate | [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=HerculesCRUE_ib-event-processor&metric=alert_status)](https://sonarcloud.io/dashboard?id=HerculesCRUE_ib-event-processor) |
| Coverage | [![Coverage](https://sonarcloud.io/api/project_badges/measure?project=HerculesCRUE_ib-event-processor&metric=coverage)](https://sonarcloud.io/dashboard?id=HerculesCRUE_ib-event-processor) |

Procesador de eventos del módulo de procesamiento para el proyecto Backend SGI (ASIO).

## OnBoarding

Para iniciar el entorno de desarrollo se necesita cumplir los siguientes requisitos:

- OpenJDK 11
- Eclipse JEE 2019-09 con plugins:
  - Spring Tools 4
  - m2e-apt
  - Lombok
- Docker

## Metodología de desarrollo

La metodología de desarrollo es Git Flow.

## Entorno de desarrollo Docker

La inicialización de los elementos adicionales al entorno de desarrollo se realiza con docker.

En el directorio docker-devenv se ha configurado un fichero docker-compose.yml para poder arrancar el entorno de desarrollo.

Para arrancar el entorno:

```bash
docker-compose up -d
```

Para pararlo:

```bash
docker-compose down
```

## Instalación en entorno real

Será preciso configurar las siguientes variables de entorno cuando se instale en un entorno real:

| Variable                                     | Descripción                                                                                            | Valor por defecto     |
| -------------------------------------------- | ------------------------------------------------------------------------------------------------------ | --------------------- |
| `APP_KAFKA_MANAGEMENT_TOPIC_NAME`            | Nombre del topic de Kafka de gestión                                                                   | management-data       |
| `APP_KAFKA_CREATE_TOPICS`                    | Flag que indica si debe crear automáticamente los topics de Kafka. Valores admisibles `true` y `false` | false                 |
| `SPRING_KAFKA_BOOTSTRAP_SERVERS`             | URL del servicio de Kafka para los productores                                                         | localhost:29092       |
| `SPRING_KAFKA_CONSUMER_BOOTSTRAP_SERVERS`    | URL del servicio de Kafka para los consumidores                                                        | localhost:29092       |
| `SPRING_KAFKA_CONSUMER_GROUP_ID`             | ID del grupo de consumidores                                                                           | event-processor       |
| `APP_MICROSERVICES_STORAGE_ADAPTER_BASE_URL` | URL base del Storage Adapter                                                                           | http://localhost:9324 |
| `SPRING_ACTIVEMQ_USER`                       | Username cola JMS                                                                                      | admin                 |
| `SPRING_ACTIVEMQ_PASSWORD`                   | Password cola JMS                                                                                      | admin                 |
| `SPRING_ACTIVEMQ_BROKER_URL`                 | URL base de la cola JMS                                                                                | tcp://127.0.0.1:61616 |
| `SPRING_ACTIVEMQ_PACKAGES_TRUST_ALL`         | Variable que indica los paquetes permitidos en las colas JMS                                           | true                  |

### Ejecución

Al generarse un JAR bootable la ejecución se realizará mediante el siguiente comando:

```bash
java -jar {jar-name}.jar
```

Sustituyendo `{jar-name}` por el nombre del fichero JAR generado.

No es necesario especificar la clase de inicio de la aplicación, ya que el fichero MANIFEST.MF generado ya contiene la información necesaria. Solamente se especificarán los parametros necesarios.

## Testing y cobertura

Se incluyen los resultados del testing y cobertura en los siguientes enlaces:

- [Testing TDD](https://reports.herculesasioizertis.desa.um.es/event-processor/surefire/surefire-report.html)
- [Cobertura TDD](https://sonarcloud.io/component_measures?id=HerculesCRUE_ib-event-processor&metric=coverage&view=list)
- [Testing BDD](docs/testing.md)

## Documentación adicional

- [Compilación](docs/build.md)
- [Generación Docker](docs/docker.md)
