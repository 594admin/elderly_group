package cn.lanhuhebi.elderly_group.config;

import cn.lanhuhebi.elderly_group.webservice.generator.SmartdatatransmissionServiceLocator;
import cn.lanhuhebi.elderly_group.webservice.generator.Smartdatatransmission_PortType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.rpc.ServiceException;

/**
 * @author dxq
 * @date 2019-09-02 - 20:26
 */
@Configuration
public class ServiceConfig {

    @Bean
    public Smartdatatransmission_PortType smartdatatransmission() throws ServiceException {
        SmartdatatransmissionServiceLocator locator = new SmartdatatransmissionServiceLocator();
        return locator.getsmartdatatransmission();
    }
}
