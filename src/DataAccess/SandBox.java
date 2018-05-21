package DataAccess;

import com.google.gson.Gson;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;

import Objects.Grupo;
import Objects.Rol;
import Objects.Usuario;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

public class SandBox {

	public static void main(String[] args) {
		          
	    MongoDbTransaction tran = new MongoDbTransaction();
	      
	      Usuario user = new Usuario();
	     /* user.setNombre("Jose");
	      user.setApellido("Solano");
	      user.setMail("chepesm@gmail.com");
	      user.setPassword("password");
	      Grupo gru = new Grupo();
	      ArrayList<String> pri = new ArrayList<>();
	      pri.add("All");
	      gru.setPrivilegios(pri);
	      user.setGrupos(gru);
	      Rol rol = new Rol();
	      rol.setPrivilegios(pri);
	      user.setRoles(rol);*/
	      
	      //tran.InsertDocuement(user, "Users");
	      
	      ArrayList<Object> re = tran.GetData(user, "Users");
	      
	      for(Object r : re){
	    	 Usuario userio1 = (Usuario)r;
	    	  
	    	 System.out.println(userio1.getNombre());
	      }
	      
	      System.out.println("Collection created successfully");  
	}

}
