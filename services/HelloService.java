package br.com.bb.crv.bootstrap.services;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.enterprise.context.RequestScoped;
import org.eclipse.microprofile.opentracing.Traced;
import org.jboss.logging.Logger;
import java.time.LocalTime;
import java.time.ZoneId;


@ApplicationScoped
@Traced
public class HelloService {

    @Inject
    Logger LOG;

    static String hello = new String("Hello");

    public String respondeHello(){

        return HelloService.hello.concat("!");

    }
    public String respondeComNome(String nome){

       String resposta = new String(HelloService.hello);

        resposta = resposta.concat(" ");
        resposta = resposta.concat(nome);
        resposta = resposta.concat("!");

        return resposta;

    }

    public String respondeComData(String nome){

        String resposta = new String(HelloService.hello);
 
         resposta = resposta.concat(" ");
         resposta = resposta.concat(nome);
         resposta = resposta.concat("! Agora são ");

         LocalTime tempo = LocalTime.now(ZoneId.of("America/Sao_Paulo"));
         resposta = resposta.concat(String.valueOf(tempo.getHour())+":");
         resposta = resposta.concat(String.valueOf(tempo.getMinute())+":");
         resposta = resposta.concat(String.valueOf(tempo.getSecond() ));
         resposta = resposta.concat(", não esqueça!");
         
 
         return resposta;
 
     }


    
}
