package com.example;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import com.example.services.*;

@Component
public class ApplicationStartup 
implements ApplicationListener<ApplicationReadyEvent> {

  /**
   * This event is executed as late as conceivably possible to indicate that 
   * the application is ready to service requests.
   */
  @Override
  public void onApplicationEvent(final ApplicationReadyEvent event) {
 
    System.out.println("Running Startup Code");
    
    return;
  }
  
  @Bean
  CommandLineRunner init(UserRepository userRepository, BookmarkRepository bookmarkRepository) {
      return (args) ->
          Arrays.asList("1100036950107651".split(","))
              .forEach(a -> {
            	  System.out.printf("Seeding DB with bookmarks for user %s", a);
                  User user = userRepository.save(new User(a));
                  bookmarkRepository.save(new Bookmark(user, "http://bookmark.com/1/" + a, "A description"));
                  bookmarkRepository.save(new Bookmark(user, "http://bookmark.com/2/" + a, "A description"));
                  Collection<Bookmark> marks = bookmarkRepository.findAll();
                  
                  for(Bookmark mark : marks){
                	  System.out.println("Found Bookmark: " + mark.description);
                  }
              });
  }
 
} // class