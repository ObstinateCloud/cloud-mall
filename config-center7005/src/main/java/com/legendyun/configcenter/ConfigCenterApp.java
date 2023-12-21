package com.legendyun.configcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class ConfigCenterApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(ConfigCenterApp.class,args);

        //访问地址 http://localhost:7005/dev/application-pve.yml
    }
}
