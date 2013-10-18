package org.iwb.bootstrap;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.hal.Jackson1HalModule;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
@Configuration
@ComponentScan("org.iwb")
@EnableWebMvc
public class SpringBootstrap extends WebMvcConfigurerAdapter implements WebApplicationInitializer {

    /**
     * {@inheritDoc}
     */
    @Override
    public void onStartup(ServletContext container) throws ServletException {
        AnnotationConfigWebApplicationContext ioc = new AnnotationConfigWebApplicationContext();
        ioc.getEnvironment().setActiveProfiles("in-memory");
        ioc.register(SpringBootstrap.class);

        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(ioc));
        dispatcher.addMapping("/services/*");

        FilterRegistration encodingFilter = container.addFilter("encoding-filter", CharacterEncodingFilter.class);
        encodingFilter.setInitParameter("encoding", "UTF-8");
        encodingFilter.setInitParameter("forceEncoding", "true");
        encodingFilter.addMappingForUrlPatterns(null, false, "/*");

        container.addListener(new ContextLoaderListener(ioc));

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJacksonHttpMessageConverter converter = new MappingJacksonHttpMessageConverter();
        List<MediaType> mediatypes = new ArrayList<>();
        mediatypes.add(MediaType.APPLICATION_JSON);
        converter.setSupportedMediaTypes(mediatypes);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new Jackson1HalModule());

        converter.setObjectMapper(objectMapper);
        converters.add(converter);
        converters.add(registerByteArrayHttpMessageConverter());
    }

    @Bean
    public HttpMessageConverter registerByteArrayHttpMessageConverter() {
        return new ByteArrayHttpMessageConverter();
    }

    @Bean
    public RequestMappingHandlerMapping handlerMapping() {
        return new RequestMappingHandlerMapping();
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        return new CommonsMultipartResolver();
    }

}
