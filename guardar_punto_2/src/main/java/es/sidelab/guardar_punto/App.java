package es.sidelab.guardar_punto;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;
import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;


@SpringBootApplication
@EnableAutoConfiguration
@EnableHazelcastHttpSession
@EnableCaching
public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
    
    private static final Log LOG = LogFactory.getLog(App.class);    
    
    //Configuracion para hazelcast
    @Bean
	public Config config() {
		Config config = new Config();
		JoinConfig joinConfig = config.getNetworkConfig().getJoin();
		joinConfig.getMulticastConfig().setEnabled(false);
		//Añadir servidores web
		joinConfig.getTcpIpConfig().addMember( "192.168.33.11" ).addMember( "192.168.33.12" ).setEnabled( true );
		return config;
    }
    
    //Configuracion cache
    @Bean
    public CacheManager cacheManager() {	
    	LOG.info("Activating Cache...");	
    	return new ConcurrentMapCacheManager("guardarpunto"); 
    }
}
