package doo.gl.config;

import com.stormpath.spring.filter.StormpathSecurityContextPersistenceFilter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/").permitAll();
//            .antMatchers("/restricted").authenticated();
    }

    @Bean
    public StormpathSecurityContextPersistenceFilter stormpathSecurityContextPersistenceFilter() {
        return new StormpathSecurityContextPersistenceFilter();
    }


}
