package org.project.FastFood.Security;
import org.project.FastFood.Services.UserService;
import org.project.FastFood.ServicesImp.UserServiceImp;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
	
	private final UserService userDetailsService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	  
	  public WebSecurity(UserService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
	        this.userDetailsService = userDetailsService;
	        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	     }
		  
		 
		 
		 
		  @Override
		    @Bean
		    public AuthenticationManager authenticationManagerBean() throws Exception {
		        return super.authenticationManagerBean();
		    }
		  @Override
			protected void configure(HttpSecurity http) throws Exception {
				

				http
				    .cors().and()
				    .csrf().disable()
					.authorizeRequests()
					.antMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL)
					.permitAll()
					.anyRequest().authenticated()
					.and()
					.addFilter(getAuthenticationFilter())
					.addFilter(new AuthorizationFilter(authenticationManager()))
					.sessionManagement()
				    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			}
			
			
			protected AuthenticationFilter getAuthenticationFilter() throws Exception {
			    final AuthenticationFilter filter = new AuthenticationFilter(authenticationManager());
			    filter.setFilterProcessesUrl("/users/login");
			    return filter;
			}
			
			@Override
			public void configure(AuthenticationManagerBuilder auth) throws Exception {
			    auth.userDetailsService( userDetailsService).passwordEncoder(bCryptPasswordEncoder);
			}
			
		}
	

