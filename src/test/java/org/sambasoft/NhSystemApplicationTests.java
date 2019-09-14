package org.sambasoft;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sambasoft.entities.Task;
import org.sambasoft.entities.Usuario;
import org.sambasoft.services.TaskService;
import org.sambasoft.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NhSystemApplicationTests {
	
      @Autowired
      private UsuarioService usuarioService;
      @Autowired
      private TaskService taskService;
       
      @Before
      public void initDb() {
    	  {
    		  Usuario newUser = new Usuario("testUser@mail.com", "testUser", "123456");
    		  usuarioService.createUser(newUser); 
    	  }
    	  {
    		  Usuario newUser = new Usuario("testAdmin@mail.com", "testAdmin", "123456");
    		  usuarioService.createUser(newUser); 
    	  }
    	  
    	  Task userTask = new Task("03/01/2018", "00:11", "11:00", "You need to work today");
    	  Usuario usuario = usuarioService.findOne("testUser@mail.com");
    	  taskService.addCompany(userTask, usuario);  
      }
	 
      @Test
      public void testUser() {
    	  Usuario usuario = usuarioService.findOne("testUser@mail.com");
          assertNotNull(usuario);
    	  Usuario admin = usuarioService.findOne("testAdmin@mail.com");
    	  assertEquals(admin.getEmail(),"testAdmin@mail.com");
      }
      
      @Test
      public void testTask() {
    	  Usuario usuario = usuarioService.findOne("testUser@mail.com");
    	  List<Task> task = taskService.findUserTask(usuario);
    	  assertNotNull(task); 

      }
      
      
      
     
	
}
