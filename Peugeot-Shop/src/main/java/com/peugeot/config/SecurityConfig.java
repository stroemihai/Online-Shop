package com.peugeot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Profile(value = "with_security")
public class SecurityConfig {
    public static final String ROLE_USER = "USER";
    public static final String ROLE_ADMIN = "ADMIN";

    @Bean
    @Primary
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        manager.createUser(User.withUsername("user")
                .password(bCryptPasswordEncoder().encode("1234")).roles(ROLE_USER).build());

        manager.createUser(User.withUsername("admin")
                .password(bCryptPasswordEncoder().encode("1234")).roles(ROLE_ADMIN, ROLE_USER).build());



        return manager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/api/v1/products/addProduct").hasRole(ROLE_ADMIN);
                    auth.requestMatchers("/api/v1/products/allProducts").hasRole(ROLE_ADMIN);
                    auth.requestMatchers("/api/v1/products/getProductById/{productId}").hasRole(ROLE_USER);
                    auth.requestMatchers("/api/v1/products/getProductById/{productId}").hasRole(ROLE_ADMIN);
                    auth.requestMatchers("/api/v1/products/updateProduct/{productId}").hasRole(ROLE_ADMIN);
                    auth.requestMatchers("/api/v1/products/deleteProductById/{productId}").hasRole(ROLE_ADMIN);

                    auth.requestMatchers("/api/v1/clients/addClient").hasRole(ROLE_ADMIN);
                    auth.requestMatchers("/api/v1/clients/getAllClients").hasRole(ROLE_ADMIN);
                    auth.requestMatchers("/api/v1/clients/getClientById/{clientId}").hasRole(ROLE_ADMIN);
                    auth.requestMatchers("/api/v1/clients/updateClient/{clientId}").hasRole(ROLE_ADMIN);
                    auth.requestMatchers("/api/v1/clients/deleteClientById/{clientId}").hasRole(ROLE_ADMIN);

                    auth.requestMatchers("/api/v1/orders/createOrder").hasRole(ROLE_ADMIN);
                    auth.requestMatchers("/api/v1/orders/getOrderById/{orderId}").hasRole(ROLE_ADMIN);
                    auth.requestMatchers("/api/v1/orders/getAllOrders").hasRole(ROLE_ADMIN);
                    auth.requestMatchers("/api/v1/orders/updateOrderById/{orderId}").hasRole(ROLE_ADMIN);
                    auth.requestMatchers("/api/v1/orders/deleteOrderById/{orderId}").hasRole(ROLE_ADMIN);
                    auth.requestMatchers("/api/v1/orders/assignClient").hasRole(ROLE_ADMIN);

                }).httpBasic(Customizer.withDefaults());

        return httpSecurity.build();

    }
}
