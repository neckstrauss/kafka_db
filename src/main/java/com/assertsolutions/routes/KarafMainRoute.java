package com.assertsolutions.routes;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.kafka.KafkaComponent;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.assertsolutions.dto.AuditoriaRequest;

/**
 * 
 * @author Assert Solutions S.A.S
 *
 */
@Component
public class KarafMainRoute extends RouteBuilder {
    
    @Value("${camel.component.servlet.mapping.context-path}")
    private String contextPath;
    
    @Autowired
    private CamelContext camelContext;

    @Override
    public void configure() throws Exception {
        camelContext.setUseMDCLogging(Boolean.TRUE);        
        KafkaComponent kafka = new KafkaComponent();
		kafka.setBrokers("{{kafka.host}}:{{kafka.port}}");
		camelContext.addComponent("kafka", kafka);
        log.info("Start rote: kafka server...........");

        from("kafka:{{kafka.topic}}"
        		+ "?"
        		//+ "brokers="+env.getProperty("kafka.url")
                //+ "&"
                + "maxPollRecords=5000"
                + "&consumersCount=1"
                + "&seekTo=beginning"
                + "&autoCommitEnable=true"
                + "&synchronous=true"
                + "&groupId=kafkaGroup"
                + "&seekTo=end"
        		)
                .routeId("FromKafka")
                .log("Termina consumir kafka .... ${body}")
                .unmarshal().json(JsonLibrary.Jackson, AuditoriaRequest.class)                
                .bean("utilBean","setCurrentDate")
                .to("sql:INSERT INTO {{sql.insert.esquema}}Auditoria_Log_Notificador2 (CLIENTE, FECHA_LOG, USUARIO_CREACION, NIVEL_LOG, TIPO_EVENTO, DESCRIPCION_EVENTO, CONTENIDO_LOG, IP_ORIGEN, ID_EXCHANGE, APLICACION, OPERACION) VALUES(:#${body.cliente}, :#${body.fechaLog}, :#${body.usuarioCreacion}, :#${body.nivelLog}, :#${body.tipoEvento}, :#${body.descripcion}, :#${body.contenidoLog}, :#${body.ipOrigen}, :#${body.idExchange}, :#${body.aplicacion}, :#${body.operacion});" + 
                		"?" +
                        "dataSource=dataSource")
                .end();
    }

}
